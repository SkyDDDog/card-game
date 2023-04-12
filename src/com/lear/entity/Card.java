package com.lear.entity;

/**
 * 卡牌实体类
 * @author 天狗
 */
public class Card {

    /**
     * 点数
     */
    public static enum Point {
        // A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K
        Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    /**
     * 花色
     */
    public static enum Color {
        // 黑桃, 红桃, 梅花, 方块
        Clubs, Diamonds, Hearts, Spades
    };


    private Point point;
    private Color color;

    public Card(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", point, color );
    }

}

