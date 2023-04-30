package ru.kartsev.tetris.gamelogic;

import java.util.ArrayList;

/**
 * @author Dmitry Kartsev
 */
public class Game {

    public static int score, highScore, scoreToAdd = 0;
    public static boolean spawnNewBlock, speedUp = false;

    public static ArrayList<Block> blocks = new ArrayList<>();
    public static Block current, nextBlock;

    public static int[][] map = new int[10][18];

    public static GameState gameState = GameState.start;

    public static void clear() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map.length; y++) {
                map[x][y] = 0;
            }
        }
        // Начинаем новую игру с результатом 0
        score = 0;
    }

}
