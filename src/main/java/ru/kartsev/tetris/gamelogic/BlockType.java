package ru.kartsev.tetris.gamelogic;

import java.util.concurrent.ThreadLocalRandom;

public enum BlockType {
    I, J, L, O, S, T, Z;

    // Метод на выбор случайного блока из общего числа
    public static BlockType random() {
        return values()[ThreadLocalRandom.current().nextInt(0, values().length)];
    }
}
