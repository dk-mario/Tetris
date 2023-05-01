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
        for (int j = 0; j < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length; j++) {
            for (int k = 0; k < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][j].length; k++) {

                if (Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][j][k] == 1) {
                    graphics.fillRect(Conversion.cellToCoordinates(1 + j),
                            Conversion.cellToCoordinates(k), 32, 32);
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
        graphics.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                graphics.drawRect(i * 32 + 32, j * 32, 32, 32);
            }
        }

        graphics.setColor(Color.BLACK);
        graphics.drawRect(32, 0, 128, 128);

        graphics.setFont(Gui.pixelFont);
        graphics.drawString("SCORE: " + Game.score, 32, 200);

        graphics.drawString("HIGHSCORE: " + Game.highScore, 32, 250);

        repaint();
    }
}
