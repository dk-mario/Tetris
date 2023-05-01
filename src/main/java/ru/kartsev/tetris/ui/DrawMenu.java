package ru.kartsev.tetris.ui;

import ru.kartsev.tetris.gamelogic.Game;
import ru.kartsev.tetris.gamelogic.GameState;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Kartsev
 */
public class DrawMenu extends JLabel {

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);


        if (Game.gameState == GameState.start) {
            graphics.setColor(new Color(24, 70, 145));
            graphics.fillRect(0, Gui.height / 2 - 50, Gui.width + 200, 100);
            graphics.setColor(Color.WHITE);
            // Font
            graphics.setFont(Gui.pixelFont.deriveFont(14f));
            graphics.drawString("PRESS ENTER TO START", Gui.width / 2, Gui.height / 2 + 10);
        } else if (Game.gameState == GameState.pause) {
            graphics.setColor(new Color(255, 255, 0));
            graphics.fillRect(0, Gui.height / 2 - 50, Gui.width + 200, 100);
            graphics.setColor(Color.WHITE);
            // Font
            graphics.setFont(Gui.pixelFont.deriveFont(14f));
            graphics.drawString("PRESS ESC TO CONTINUE", Gui.width / 2 - 10, Gui.height / 2 + 10);
        } else if (Game.gameState == GameState.gameOver) {
            graphics.setColor(new Color(175, 20, 20));
            graphics.fillRect(0, Gui.height / 2 - 50, Gui.width + 200, 100);
            graphics.setColor(Color.WHITE);
            // Font
            graphics.setFont(Gui.pixelFont.deriveFont(14f));
            graphics.drawString("GAME OVER... PRESS ENTER TO START AGAIN", 75, Gui.height / 2 + 10);
        }

        repaint();
    }

}
