package ru.kartsev.tetris.ui;

import ru.kartsev.tetris.data.Conversion;
import ru.kartsev.tetris.gamelogic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Kartsev
 */
public class DrawInterface extends JLabel {

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Game.nextBlock.getColor());
        for (int i = 0; i < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length; i++) {
            for (int j = 0; j < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i].length; j++) {
                if (Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i][j] == 1) {
                    graphics.fillRect(Conversion.cellToCoordinates(1 + i),
                            Conversion.cellToCoordinates(j), 32, 32);
                }
            }
        }

//      graphics.setColor(new Color(100, 100, 100));
        graphics.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // описание контура дополнительного игрового поля
                graphics.drawRect(i * 32 + 32, j * 32, 32, 32);
            }
        }

        // Черная оконтовка дополнительного игрового поля
        graphics.setColor(Color.BLACK);
        graphics.drawRect(32, 0, 128, 128);

        repaint();
    }
}
