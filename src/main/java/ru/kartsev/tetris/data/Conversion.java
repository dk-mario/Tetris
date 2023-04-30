package ru.kartsev.tetris.data;

/**
 * @author Dmitry Kartsev
 */
public class Conversion {
    public static int cellToCoordinates(int cell) {
        return cell * 32;
    }

    public static int coordinatesToCell(int coordinates) {
        return coordinates / 32;
    }
}
