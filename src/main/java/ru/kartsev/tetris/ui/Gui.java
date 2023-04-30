package ru.kartsev.tetris.ui;

import ru.kartsev.tetris.io.KeyHandler;

import javax.swing.*;

/**
 * @author Dmitry Kartsev
 */
public class Gui {

    // Ширина и высота игрового поля
    public static int width = 320, height = 576;

    // Класс для создания главного окна из библиотеки SWING (library GIU)
    JFrame jf;

    public void create() {
        jf = new JFrame("Tetris");
        jf.setSize(width + 17 + 200, height + 41); // 10 полей в ширину и 18 полей в высоту
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.addKeyListener(new KeyHandler());
        jf.requestFocus();

        // Рисуем основное игровое поле
        DrawGame drawGame = new DrawGame();
        setUpDraw(drawGame, 0, 0, width + 1, height + 1);

        // Рисуем дополнительное игровое поле со следующими фигурами
        DrawInterface drawInterface = new DrawInterface();
        setUpDraw(drawInterface, width + 1, 1, width, height);

        jf.setVisible(true);
    }

    private void setUpDraw(JLabel draw, int x, int y, int width, int height) {
        draw.setBounds(x, y, width, height);
        draw.setVisible(true);
        jf.add(draw);

    }
}
