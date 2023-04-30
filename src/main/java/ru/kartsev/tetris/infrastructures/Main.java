package ru.kartsev.tetris.infrastructures;

import ru.kartsev.tetris.gamelogic.Block;
import ru.kartsev.tetris.gamelogic.Game;
import ru.kartsev.tetris.ui.Gui;

public class Main {
    public static void main(String[] args) {

        // Создаем два первых блока на два игровых поля
        Game.current = new Block();
        Game.blocks.add(Game.current);
        Game.nextBlock = new Block();

        Gui gui = new Gui();

        gui.create();

        startLoop();
    }

    public static void startLoop() {
        GameLoop loop = new GameLoop();
        loop.start();
    }
}