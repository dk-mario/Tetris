package ru.kartsev.tetris.ui;

import ru.kartsev.tetris.data.Conversion;
import ru.kartsev.tetris.gamelogic.Game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Kartsev
 */
public class DrawGame extends JLabel {

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);


        graphics.setColor(Game.currentBlock.getColor());
        for (int j = 0; j < Game.currentBlock.getBounds()[Game.currentBlock.getRotation()].length; j++) {
            for (int k = 0; k < Game.currentBlock.getBounds()[Game.currentBlock.getRotation()][j].length; k++) {

                if (Game.currentBlock.getBounds()[Game.currentBlock.getRotation()][j][k] == 1) {
                    graphics.fillRect(Conversion.cellToCoordinates(Game.currentBlock.getX() + j),
                            Conversion.cellToCoordinates(Game.currentBlock.getY() + k), 32, 32);
                }
            }
        }

        for (int i = 0; i < Game.map.length; i++) {
            for (int j = 0; j < Game.map[i].length; j++) {
                if (Game.map[i][j] > 0) {
                    switch (Game.map[i][j]) {
                        case 1:
                            graphics.setColor(Color.CYAN);
                            break;
                        case 2:
                            graphics.setColor(Color.YELLOW);
                            break;
                        case 3:
                            graphics.setColor(Color.MAGENTA);
                            break;
                        case 4:
                            graphics.setColor(Color.ORANGE);
                            break;
                        case 5:
                            graphics.setColor(Color.BLUE);
                            break;
                        case 6:
                            graphics.setColor(Color.RED);
                            break;
                        case 7:
                            graphics.setColor(Color.GREEN);
                            break;
                    }
                    graphics.fillRect(Conversion.cellToCoordinates(i), Conversion.cellToCoordinates(j), 32, 32);
                }
            }
        }

//      graphics.setColor(new Color(100, 100, 100));
        graphics.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                // описание контура основогого игрового поля
                graphics.drawRect(i * 32, j * 32, 32, 32);
            }
        }

        // Черная оконтовка дополнительного игрового поля
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, Gui.width, Gui.height);

        repaint();
    }
}
