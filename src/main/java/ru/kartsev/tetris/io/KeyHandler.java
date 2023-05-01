package ru.kartsev.tetris.io;

import ru.kartsev.tetris.data.Collision;
import ru.kartsev.tetris.gamelogic.Game;
import ru.kartsev.tetris.gamelogic.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Dmitry Kartsev
 */
public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Start the game
        if (Game.gameState == GameState.start) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Game.gameState = GameState.inGame;
            }
        }
        // Control of the game
        if (Game.gameState == GameState.inGame) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    if (!Collision.collideInRotation(Game.current)) {
                        Game.current.rotate();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Game.speedUp = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                try {
                    if (!Collision.collideWithWall(Game.current, 1) &&
                            !Collision.collideWithWall(Game.current, 1)) {
                        Game.current.setX(Game.current.getX() + 1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                try {
                    if (!Collision.collideWithWall(Game.current, -1) &&
                            !Collision.collideWithWall(Game.current, -1)) {
                        Game.current.setX(Game.current.getX() - 1);
                    }
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            // Game on pause
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Game.gameState = GameState.pause;
            }
        } else if (Game.gameState == GameState.pause) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Game.gameState = GameState.inGame;
            }
            // Game Over
        } else if (Game.gameState == GameState.gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Game.gameState = GameState.inGame;
                Game.clear();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (Game.gameState == GameState.inGame) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Game.speedUp = false;
            }
        }

    }
}
