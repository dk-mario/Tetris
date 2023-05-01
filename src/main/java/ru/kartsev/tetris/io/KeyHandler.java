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
                    if (!Collision.collideInRotation(Game.currentBlock)) {
                        Game.currentBlock.rotate();
                    }
                } catch (Exception e1) {

                    e1.printStackTrace();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Game.speedUp = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                try {
                    if (!Collision.collideWithWall(Game.currentBlock, 1)
                            && !Collision.collideWithBlock(Game.currentBlock, 1)) {
                        Game.currentBlock.setX(Game.currentBlock.getX() + 1);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                try {
                    if (!Collision.collideWithWall(Game.currentBlock, -1)
                            && !Collision.collideWithBlock(Game.currentBlock, -1)) {
                        Game.currentBlock.setX(Game.currentBlock.getX() - 1);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
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