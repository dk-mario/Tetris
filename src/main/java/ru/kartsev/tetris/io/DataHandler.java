package ru.kartsev.tetris.io;

import ru.kartsev.tetris.gamelogic.Game;

import java.io.*;
import java.util.Scanner;

/**
 * @author Dmitry Kartsev
 */
public class DataHandler {

    public static void load() {
        File file = new File("src\\main\\resources\\data\\score.txt");

        try {
            Scanner sc = new Scanner(file);
            Game.highScore = sc.nextInt();
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        File file = new File("src\\main\\resources\\data\\score.txt");

        try {
            OutputStream stream = new FileOutputStream(file);
            try {
                stream.write(Integer.toString(Game.highScore).getBytes());
                stream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}