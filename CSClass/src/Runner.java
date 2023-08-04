
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/** Runner class starts, and runs the processes from the Tetris class
 *
 */
public class Runner extends Tetris
{

    public static void main(String[] args) {
        JFrame f = new JFrame("Tetris Project");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(550, 650);
        f.setVisible(true);

        f.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:

                        methodOn = false;
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        Tetris game = new Tetris();
        game.initializeGrid();
        f.add(game);
        f.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.rotatePiece(+1);
                        break;
                    case KeyEvent.VK_Z:
                        game.rotatePiece(-1);
                        break;
                    case KeyEvent.VK_LEFT:
                        game.move(-1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.move(+1);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.dropPiece();
                        break;
                    case KeyEvent.VK_A:
                        game.rotatePiece(2);
                        break;
                    case KeyEvent.VK_Q:
                        System.exit(1);
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        //Creates a new Thread to keep the program running at all times
        new Thread()
        {
            @Override
            public void run()
            {
                if (checkLoss()) {
                    return;
                }
                while (true)
                {
                    try
                    {
                        if(methodOn == false)
                        {
                            elapsedTime = ((new Date()).getTime() - startTime)/1000;
                            game.dropPiece();
                        }
                        if (level == 1)
                        {
                            Thread.sleep(800);
                        }
                        else if (level == 2)
                        {
                            Thread.sleep(630);
                        }
                        else if (level == 3)
                        {
                            Thread.sleep(550);
                        }
                        else if (level == 4)
                        {
                            Thread.sleep(470);

                        }
                        else if (level == 5)
                        {
                            Thread.sleep(380);

                        }
                        else if (level == 6)
                        {
                            Thread.sleep(300);

                        }
                        else if (level == 7)
                        {
                            Thread.sleep(220);

                        }
                        else if (level == 8)
                        {
                            Thread.sleep(130);

                        }
                        else if (level >= 9)
                        {
                            Thread.sleep(100);
                        }

                    } catch (InterruptedException e) {
                    }
                }
            }

        }.start();
    }
}


