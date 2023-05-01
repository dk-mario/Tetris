package ru.kartsev.tetris.infrastructures;

import ru.kartsev.tetris.data.Collision;
import ru.kartsev.tetris.gamelogic.Block;
import ru.kartsev.tetris.gamelogic.Game;
import ru.kartsev.tetris.gamelogic.GameState;

/**
 * @author Dmitry Kartsev
 */
public class GameLoop extends Thread {
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                if (Game.gameState == GameState.inGame) {

                    if (!Collision.collideWithWall(Game.currentBlock, 0)
                            && !Collision.collideWithBlock(Game.currentBlock, 0)) {
                        Game.currentBlock.setY(Game.currentBlock.getY() + 1);
                        Collision.collideWithWall(Game.currentBlock, 0);

                    }

                    if (Game.spawnNewBlock) {
                        Collision.checkFullRow(1);
                        Game.blocks.add(Game.nextBlock);
                        Game.currentBlock = Game.nextBlock;
                        Game.nextBlock = new Block();
                        Game.spawnNewBlock = false;
                    }
                }
                if (!Game.speedUp) {
                    sleep(1000);
                } else {
                    sleep(100);
                }

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }
}
