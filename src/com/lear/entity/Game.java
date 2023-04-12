package com.lear.entity;

import com.lear.exception.CardDeckEmptyException;
import com.lear.exception.SaveCardUnavailableException;
import com.lear.util.InputStrUtil;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 游戏实体类
 * @author 天狗
 */
public class Game {
    // 牌堆
    Deck deck;
    // 已翻开的牌堆
    // 采用线程安全的数组，防止在收牌时出现并发问题
    CopyOnWriteArrayList<Card> showCard;

    /**
     * 初始化游戏
     */
    private void initGame() {
        deck = new Deck();
        showCard = new CopyOnWriteArrayList<>();
    }

    /**
     * 默认初始化游戏
     */
    public Game() {
        this.initGame();
    }

    /**
     * 通过传入的牌堆初始化游戏
     * @param cardList  牌堆
     */
    public Game(List<Card> cardList) {
        deck = new Deck(cardList);
        showCard = new CopyOnWriteArrayList<Card>();
    }

    /**
     * 判断游戏是否结束
     * @return
     */
    public boolean isGameEnd() {
        return deck.isEmpty() && showCard.size()==0;
    }

    /**
     * 发牌
     */
    public Card dropCard() {
        if (!this.isGameEnd()) {
            Card card = deck.getCard(0);
            showCard.add(card);
            deck.removeCard(0);
            return card;
        } else {
            throw new CardDeckEmptyException();
        }
    }

    /**
     * 展示牌堆是否有指定点数的牌
     * @param point 指定点数
     * @return 有返回true，否则返回false
     */
    public boolean isSaveCardAvailable(Card.Point point) {
        for (int i = showCard.size()-2; i >= 0; i--) {
            if (showCard.get(i).getPoint() == point) {
                return true;
            }
        }
        return false;
    }

    /**
     * 收牌
     * @param fromIndex 从第几张牌开始收
     * @param toIndex   收到第几张牌
     */
    public void saveCard(int fromIndex, int toIndex) {
        if (fromIndex < 0 || fromIndex > showCard.size() - 1) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex);
        }
        if (toIndex < 0 || toIndex > showCard.size() - 1) {
            throw new IndexOutOfBoundsException("toIndex: " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex: " + fromIndex + " > toIndex: " + toIndex);
        }
        List<Card> saveCard = showCard.subList(fromIndex, toIndex + 1);
//        deck.addCardList(saveCard);
        showCard.removeAll(saveCard);
    }

    /**
     * 收牌到最后一张
     * @param fromIndex 从第几张牌开始收
     */
    public void saveCard(int fromIndex) {
        this.saveCard(fromIndex, showCard.size() - 1);
    }

    /**
     * 收牌点数相同的牌
     * @param point 点数
     */
    public void saveCard(Card.Point point) {
        if (!this.isSaveCardAvailable(point)) {
            throw new SaveCardUnavailableException();
        }
        for (int i = showCard.size()-2; i >= 0; i--) {
            if (showCard.get(i).getPoint() == point) {
                this.saveCard(i);
                return;
            }
        }
    }


    /**
     * 洗牌
     */
    public void shuffle() {
        deck.shuffle();
    }

    /**
     * 收牌并洗牌
     * @param fromIndex 从第几张牌开始收
     * @param toIndex  收到第几张牌
     */
    public void saveAndShuffle(int fromIndex, int toIndex) {
        this.saveCard(fromIndex, toIndex);
        this.shuffle();
    }

    /**
     * 按点数收牌并洗牌
     * @param point 点数
     */
    public void saveAndShuffle(Card.Point point) {
        this.saveCard(point);
        this.shuffle();
    }

    /**
     * 开始游戏
     */
    public void startGame(Scanner scanner) {
        while (!this.isGameEnd()) {
            Card card = this.dropCard();
            System.out.println(card);
            if (this.isSaveCardAvailable(card.getPoint())) {
                System.out.print("请选择是否收牌"+InputStrUtil.getPromptText()+":");
                String option = scanner.nextLine();
                if (InputStrUtil.isTrue(option)) {
                    this.saveAndShuffle(card.getPoint());
                } else {
                    System.out.println(InputStrUtil.getContinuePromptText());
                    option = scanner.nextLine();
                }
                System.out.println(this.nowShowCards());
                System.out.println("========================");
            }
        }
    }

    public String nowShowCards() {
        StringBuilder sb = new StringBuilder("当前展示牌堆:\n");
        for (Card card : showCard) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }


}
