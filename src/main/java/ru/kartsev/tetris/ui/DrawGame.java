package ru.kartsev.tetris.ui;

import ru.kartsev.tetris.data.Conversion;
import ru.kartsev.tetris.gamelogic.Game;
import ru.kartsev.tetris.gamelogic.GameState;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Kartsev
 */
public class DrawGame extends JLabel {

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        graphics.setColor(Game.current.getColor());
        for (int i = 0; i < Game.current.getBounds()[Game.current.getRotation()].length; i++) {
            for (int j = 0; j < Game.current.getBounds()[Game.current.getRotation()][i].length; j++) {
                if (Game.current.getBounds()[Game.current.getRotation()][i][j] == 1) {
                    graphics.fillRect(Conversion.cellToCoordinates(Game.current.getX() + i),
                            Conversion.cellToCoordinates(Game.current.getY() + j), 32, 32);
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
