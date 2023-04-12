package com.lear.entity;

import java.util.*;

/**
 * 牌堆
 * @author 天狗
 */
public class Deck {

    List<Card> cardList;

    public static final Integer MAX_CARD_NUM = 52;

    public Deck() {
        cardList = new ArrayList<>(MAX_CARD_NUM);
        for (Card.Point point : Card.Point.values()) {
            for (Card.Color color : Card.Color.values()) {
                cardList.add(new Card(point, color));
            }
        }
        this.shuffle();
    }

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public void addCardList(List<Card> cardList) {
        this.cardList.addAll(cardList);
    }

    public void removeCard(int index) {
        cardList.remove(index);
    }
    public void removeCard(Card card) {
        cardList.remove(card);
    }

    public void removeCardList(List<Card> cardList) {
        this.cardList.removeAll(cardList);
    }

    public void clear() {
        cardList.clear();
    }

    public int size() {
        return cardList.size();
    }

    public Card getCard(int index) {
        return cardList.get(index);
    }

    public void setCard(int index, Card card) {
        cardList.set(index, card);
    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cardList.size(); i++) {
            builder.append(String.format("%-19s%s", cardList.get( i ), ( ( i + 1 ) % 4 == 0 ) ? "\n" : ""));
        }
        return builder.toString();
    }



}
