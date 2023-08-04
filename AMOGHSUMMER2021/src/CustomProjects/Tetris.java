package CustomProjects;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

class MyTetris extends JPanel {
    private Point middlePoint;
    private int currentPiece;
    private int rotation;
    private ArrayList<Integer> nextPieces = new ArrayList<Integer>();
    private static Color[][] grid;
    private static long pointsGiven;
    private static int changeLevel;
    private int futurePiece;
    private static int blankRotation;
    private static int numClears = 0;


    private final Point[][][] tetrisObject = {
            {
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)}
            },
            {
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0)}
            },
            {
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)}
            },
            {
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}
            },
            {
                    {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                    {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
                    {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)}
            },
            {
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2)},
                    {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2)}
            },
            {
                    {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)},
                    {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
                    {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)}
            }
    };

    private final Color[] colorsList = {
            Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red
    };

    private void initialize() {
        grid = new Color[12][24];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                if (i == 0 || i == 11 || j == 22) {
                    grid[i][j] = Color.DARK_GRAY;
                } else {
                    grid[i][j] = Color.BLACK;
                }
            }
        }
        newPiece();
    }

    public void newPiece() {
        middlePoint = new Point(5, 0);
        rotation = 0;

        if (nextPieces.isEmpty()) {
            Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
            Collections.shuffle(nextPieces);

        }
        currentPiece = nextPieces.get(0);
        nextPieces.remove(0);
        int randomNum = ThreadLocalRandom.current().nextInt(0, 6 + 1);
        nextPieces.add(6, randomNum);
        futurePiece = nextPieces.get(0);
    }

    private boolean collidesAt(int x, int y, int rotation) {
        for (Point p : tetrisObject[currentPiece][rotation]) {
            if (grid[p.x + x][p.y + y] != Color.BLACK) {
                return true;
            }
        }
        return false;
    }

    public void rotatePiece(int i) {
        int newRotation = (rotation + i) % 4;
        if (newRotation < 0) {
            newRotation = 3;
        }
        if (!collidesAt(middlePoint.x, middlePoint.y, newRotation)) {
            rotation = newRotation;
        }
        repaint();
    }

    public void move(int i) {
        if (!collidesAt(middlePoint.x + i, middlePoint.y, rotation)) {
            middlePoint.x += i;
        }
        repaint();
    }

    public void dropPiece() {
        if (!collidesAt(middlePoint.x, middlePoint.y + 1, rotation)) {
            middlePoint.y += 1;
        } else {
            lockPiece();
        }
        repaint();
    }

    public void lockPiece() {
        for (Point p : tetrisObject[currentPiece][rotation]) {
            grid[middlePoint.x + p.x][middlePoint.y + p.y] = colorsList[currentPiece];
        }
        clearRows();
        newPiece();
    }

    public void deleteRow(int row) {
        for (int j = row - 1; j > 0; j--) {
            for (int i = 1; i < 11; i++) {
                grid[i][j + 1] = grid[i][j];
            }
        }
    }

    public void clearRows() {
        boolean gap;

        for (int j = 21; j > 0; j--) {
            gap = false;
            for (int i = 1; i < 11; i++) {
                if (grid[i][j] == Color.BLACK) {
                    gap = true;
                    break;
                }
            }
            if (!gap) {
                deleteRow(j);
                j += 1;
                numClears += 1;
            }
        }
       /*
      switch (numClears)
      {
          case 1:
              pointsGiven += 40;
              break;
          case 2:
              pointsGiven += 100;
              break;
          case 3:
              pointsGiven += 300;
              break;
          case 4:
              pointsGiven += 1200;
              break;
      }*/


    }

    public static boolean checkLoss() {
        if (grid[4][1] != Color.BLACK || grid[5][1] != Color.BLACK) {
            return true;
        }
        return false;

    }

    public void lose(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 550, 650);
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", 250, 310);
        Font loseFont = new Font("Serif", Font.BOLD, 50);
        g.setFont(loseFont);

    }



    private void drawPiece(Graphics g) {
        if (checkLoss())
        {
            return;
        }
        else {
            g.setColor(colorsList[currentPiece]);
            for (Point p : tetrisObject[currentPiece][rotation]) {
                g.fillRect((p.x + middlePoint.x) * 26,
                        (p.y + middlePoint.y) * 26,
                        25, 25);
            }
        }
    }

    private void drawFutPiece(Graphics g) {
        if (checkLoss())
        {
            return;
        }
        else
        {
            g.setColor(colorsList[futurePiece]);
            for (Point p : tetrisObject[futurePiece][blankRotation]) {
                g.fillRect(((p.x) * 26) + 375,
                        ((p.y) * 26) + 200,
                        25, 25);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, 26 * 12, 26 * 23);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                g.setColor(grid[i][j]);
                g.fillRect(26 * i, 26 * j, 25, 25);
            }
        }
        g.setColor(Color.DARK_GRAY);
        g.fillRect(360, 0, 110, 80);
        g.setColor(Color.BLACK);
        g.fillRect(370, 10, 90, 60);
        Font myFont = new Font("Serif", Font.BOLD, 12);
        g.setFont(myFont);
        g.setColor(Color.WHITE);
        g.drawString("SCORE ", 385, 35);
        g.drawString("" + pointsGiven, 385, 55);

        //PREVIOUS BLOCK
        //g.drawString(""+ nextPieces,10, 10);
        //g.drawString(""+ nextPieces.get(1), 10, 30);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(340, 130, 160, 170);
        g.setColor(Color.BLACK);
        g.fillRect(350, 140, 140, 150);
        Font myFont2 = new Font("Serif", Font.BOLD, 12);
        g.setFont(myFont2);
        g.setColor(Color.WHITE);
        g.drawString("NEXT PIECE ", 380, 160);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(345, 350, 150, 80);
        g.setColor(Color.BLACK);
        g.fillRect(355, 360, 130, 60);
        Font myFont3 = new Font("Serif", Font.BOLD, 12);
        g.setFont(myFont3);
        g.setColor(Color.WHITE);
        g.drawString("NUM OF CLEARS ", 365, 380);
        g.drawString("" + numClears, 365, 400);

        if (checkLoss()) {
            lose(g);
        }

        drawPiece(g);
        drawFutPiece(g);

    }

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Tetris Project");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(550, 650);
        f.setVisible(true);

        MyTetris game = new MyTetris();
        game.initialize();
        f.add(game);

        f.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.rotatePiece(-1);
                        break;
                    case KeyEvent.VK_Z:
                        game.rotatePiece(+1);
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
                    case KeyEvent.VK_Q:
                        System.exit(1);
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        });


        new Thread() {
            @Override
            public void run() {
                if (checkLoss())
                {
                    return;
                }
                while (true) {
                    try {

                        if (pointsGiven < 100) {
                            Thread.sleep(1000);
                        } else if ((pointsGiven > 100) && (pointsGiven < 500)) {
                            Thread.sleep(500);
                        } else if ((pointsGiven > 500) && (pointsGiven < 1000)) {
                            Thread.sleep(350);
                        }

                        Thread.sleep(500);
                        game.dropPiece();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
    }
}




