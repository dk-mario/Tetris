package ru.kartsev.tetris.infrastructures;

import ru.kartsev.tetris.gamelogic.Block;
import ru.kartsev.tetris.gamelogic.Game;
import ru.kartsev.tetris.io.DataHandler;
import ru.kartsev.tetris.ui.Gui;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        DataHandler.load();

        Game.currentBlock = new Block();
        Game.blocks.add(Game.currentBlock);
        Game.nextBlock = new Block();

        try {
            Gui g = new Gui();
            g.create();
        } catch (FontFormatException | IOException e) {
            System.out.println("Failed to create GUI.");
            e.printStackTrace();
        }

        startLoop();

    }

    public static void startLoop() {
        GameLoop loop = new GameLoop();
        loop.start();
    }

}
