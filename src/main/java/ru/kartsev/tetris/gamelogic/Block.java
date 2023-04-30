package ru.kartsev.tetris.gamelogic;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Dmitry Kartsev
 */
public class Block {

    // Default arguments
    BlockType blockType;
    int x, y, size, rotation = 0;
    int[][][] bounds;
    Color color;
    boolean movable = true;

    public Block() {
        blockType = BlockType.random();

        // размеры блоков для прямой и для квадрата, для всех остальных default значения
        switch (blockType) {
            case I:
                size = 4;
                break;
            case O:
                size = 2;
                break;
            default:
                size = 3;
                break;
        }

        // выбор цвета для типа блока
        switch (blockType) {
            case I:
                color = Color.CYAN;
                break;
            case O:
                color = Color.YELLOW;
                break;
            case T:
                color = Color.MAGENTA;
                break;
            case L:
                color = Color.ORANGE;
                break;
            case J:
                color = Color.BLUE;
                break;
            case Z:
                color = Color.RED;
                break;
            case S:
                color = Color.GREEN;
        }

        // Блоки появляются в центре игрового поля
        x = 4;
        // И чуть выше игрового поля
        y = -2;

        try {
            bounds = blockBuilder(blockType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void rotate() {
        rotation++;
        if (rotation == 4) {
            rotation = 0;
        }
    }

    // Функция для генерации блоков из текстового файла
    public int[][][] blockBuilder(BlockType blockType) throws FileNotFoundException {
        int[][][] bounds;


        switch (blockType) {
            case I:
                bounds = new int[4][4][4];
                break;
            case O:
                bounds = new int[4][2][2];
                break;
            default:
                bounds = new int[4][3][3];
                break;
        }

        File file = new File("src\\main\\resources\\blocks\\" + blockType + ".txt");
        // Для чтения из файла
        Scanner scanner = new Scanner(file);

        // 4 вращения 4 варианта блоков
        for (int variant = 0; variant < 4; variant++) {
            for (int i = 0; i < bounds[0].length; i++) {
                if (scanner.hasNext()) {
                    String[] srow = scanner.next().split("");
                    int[] row = new int[bounds[0].length];

                    for (int j = 0; j < row.length; j++) {
                        row[j] = Integer.parseInt(srow[j]);
                        bounds[variant][j][i] = row[j];
                    }
                }
            }
        }
        return bounds;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public void setBlockType(BlockType blockType) {
        this.blockType = blockType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int[][][] getBounds() {
        return bounds;
    }

    public void setBounds(int[][][] bounds) {
        this.bounds = bounds;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
}
