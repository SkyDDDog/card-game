package com.lear;

import com.lear.entity.Deck;
import com.lear.entity.Game;

import java.util.Scanner;

/**
 * 主启动类
 * @author 天狗
 */
public class CardGameApplication {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        game.startGame(scanner);
        scanner.close();
    }

}
