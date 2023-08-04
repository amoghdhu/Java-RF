/**
 * Based off the Original Tetris, we created a replica using Java Swing for our APCS Final Project.
 *
 * @author Amogh Dhumal, Andy Liao, Evan Wang
 * @version 05/26/22
 */

import java.awt.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

/** Tetris method stores all the methods and implementation behind the game
 *
 */
public class Tetris extends JPanel
{
    public Point middlePoint;
    public int currentPiece;
    public int rotation;
    public ArrayList<Integer> nextPieces = new ArrayList<Integer>();
    public static Color[][] grid;
    public static long pointsGiven;
    public int futurePiece;
    public static int blankRotation;
    public static int numClears = 0;
    public static int prevNumClears = 0;
    public static boolean s = true;
    public static boolean methodOn = true;
    public static boolean tetris;
    public static long startTime = System.currentTimeMillis();
    public static long elapsedTime = 0;
    public static int level = 1;

    //Creates the different pieces by using different points
    public final Point[][][] tetrisObject =
            {
                    {
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
                    },
                    {
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
                            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
                            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
                    },
                    {
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
                            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
                            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
                    },
                    {
                            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
                    },
                    {
                            { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                            { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                            { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                            { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
                    },
                    {
                            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
                            { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
                    },
                    {
                            { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
                            { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
                    }
            };

    //Provides a list of colors to be used for each piece (unique to each piece)
    public final Color[] colorsList =
            {
                    new Color(151,213,254), new Color(168,194,252),new Color(255,200,174), new Color(252,255,166), new Color(189,255,178),new Color(198,174,255), new Color(255,159,187)
            };

    /** Initialize method creates the frame structure for the grid and the surrounding background.
     *
     */
    public void initializeGrid()
    {
        grid = new Color[12][24];
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 23; j++)
            {
                if (i == 0 || i == 11 || j == 22)
                {
                    grid[i][j] = new Color(80,89,116);
                } else
                {
                    grid[i][j] = Color.BLACK;
                }
            }
        }
        newPiece();
    }

    /** newPiece method creates a new piece using a Collection to randomize which piece is given.
     *
     */
    public void newPiece()
    {
        middlePoint = new Point(5, 0);
        rotation = 0;

        if (nextPieces.isEmpty())
        {
            Collections.addAll(nextPieces, 0, 1, 2, 3, 4, 5, 6);
            Collections.shuffle(nextPieces);

        }
        currentPiece = nextPieces.get(0);
        nextPieces.remove(0);
        int randomNum = ThreadLocalRandom.current().nextInt(0, 6 + 1);
        nextPieces.add(6, randomNum);
        futurePiece = nextPieces.get(0);
    }

    /** collidesWithPiece method checks the points of each piece to see if they collide with the edge of the grid
     * @param int x, int y, int rotation - piece attributes
     * @return boolean value - checks if piece is in grid
     */
    public boolean collidesWithPiece(int x, int y, int rotation)
    {
        for (Point p : tetrisObject[currentPiece][rotation])
        {
            if (grid[p.x + x][p.y + y] != Color.BLACK)
            {
                return true;
            }
        }
        return false;
    }

    /** rotatePiece method allows the piece to rotate based off the middle point
     * @param int i
     */
    public void rotatePiece(int i) {
        int newRotation = (rotation + i) % 4;
        if (newRotation < 0)
        {
            newRotation = 3;
        }
        if (!collidesWithPiece(middlePoint.x, middlePoint.y, newRotation))
        {
            rotation = newRotation;
        }
        repaint();
    }

    /** move method allows the user to use the block to move alongside the x-axis
     * @param int i
     */
    public void move(int i)
    {
        if (!collidesWithPiece(middlePoint.x + i, middlePoint.y, rotation))
        {
            middlePoint.x += i;
        }
        repaint();
    }

    /** dropPiece method is used when the block is moving down alongside the y-axis
     *
     */
    public void dropPiece()
    {
        if (!collidesWithPiece(middlePoint.x, middlePoint.y + 1, rotation))
        {
            middlePoint.y += 1;
        } else
        {
            lockPiece();
        }
        repaint();
    }

    /** lockPiece method locks the piece at the bottom of the grid to ensure it stays in place
     *
     */
    public void lockPiece()
    {
        for (Point p : tetrisObject[currentPiece][rotation])
        {
            grid[middlePoint.x + p.x][middlePoint.y + p.y] = colorsList[currentPiece];
        }
        clearRows();
        newPiece();
    }

    /** deleteRow deletes the row at the bottom of the grid
     * @param int row
     */
    public void deleteRow(int row)
    {
        for (int j = row - 1; j > 0; j--)
        {
            for (int i = 1; i < 11; i++)
            {
                grid[i][j + 1] = grid[i][j];
            }
        }
    }

    /** clearRows actually clears the row at the bottom of the grid and assigns scoring based
     * off the number of rows cleared at once
     */
    public void clearRows()
    {
        boolean gap;
        prevNumClears = numClears;

        for (int j = 21; j > 0; j--)
        {
            gap = false;
            for (int i = 1; i < 11; i++)
            {
                if (grid[i][j] == Color.BLACK)
                {
                    gap = true;
                    break;
                }
            }
            if (!gap)
            {
                deleteRow(j);
                j += 1;
                numClears += 1;
            }
        }
        switch (numClears - prevNumClears)
        {
            case 1:
                pointsGiven += 40 * level;
                break;
            case 2:
                pointsGiven += 100 * level;
                break;
            case 3:
                pointsGiven += 300 * level;
                break;
            case 4:
                pointsGiven += 1200 * level;
                tetris = true;
                break;
        }
        level = numClears / 4 + 1;

    }

    /** checkLoss method checks the loss condition which is when the block reaches a certain
     * point in the y-value
     * @return boolean - checks condition
     */
    public static boolean checkLoss()
    {
        if (grid[4][1] != Color.BLACK || grid[5][1] != Color.BLACK)
        {
            return true;
        }
        return false;
    }

    /** start method shows the start screen with the TETRIS letters
     * @param Graphic g - imported variable from Swing
     */

    public void start(Graphics g)
    {
        //g.setColor(Color.LIGHT_GRAY);
        g.setColor(new Color(176,184,206));
        g.fillRect(0, 0, 550, 650);

        Font startFont = new Font("YuKyokasho", Font.BOLD,150);
        g.setFont(startFont);

        g.setColor(Color.black);
        g.drawString("T", 15 + 1, 270 - 1);
        g.drawString("T", 15 + 1, 270 + 1);
        g.drawString("T", 15 - 1, 270 - 1);
        g.drawString("T", 15 - 1, 270 + 1);
        g.setColor(Color.RED);
        g.drawString("T", 15, 270);
        g.setColor(Color.black);

        g.drawString("E", 105 + 1, 270 - 1);
        g.drawString("E", 105 + 1, 270 + 1);
        g.drawString("E", 105 - 1, 270 - 1);
        g.drawString("E", 105 - 1, 270 + 1);
        g.setColor(Color.ORANGE);
        g.drawString("E", 105, 270);

        g.setColor(Color.black);
        g.drawString("T", 205 + 1, 270 - 1);
        g.drawString("T", 205 + 1, 270 + 1);
        g.drawString("T", 205 - 1, 270 - 1);
        g.drawString("T", 205 - 1, 270 + 1);
        g.setColor(Color.YELLOW);
        g.drawString("T", 205, 270);

        g.setColor(Color.black);
        g.drawString("R", 300 + 1, 270 - 1);
        g.drawString("R", 300 + 1, 270 + 1);
        g.drawString("R", 300 - 1, 270 - 1);
        g.drawString("R", 300 - 1, 270 + 1);
        g.setColor(Color.GREEN);
        g.drawString("R", 300, 270);

        g.setColor(Color.black);
        g.drawString("I", 400 + 1, 270 - 1);
        g.drawString("I", 400 + 1, 270 + 1);
        g.drawString("I", 400 - 1, 270 - 1);
        g.drawString("I", 400 - 1, 270 + 1);
        g.setColor(Color.BLUE);
        g.drawString("I", 400, 270);

        g.setColor(Color.black);
        g.drawString("S", 430 + 1, 270 - 1);
        g.drawString("S", 430 + 1, 270 + 1);
        g.drawString("S", 430 - 1, 270 - 1);
        g.drawString("S", 430 - 1, 270 + 1);
        g.setColor(Color.MAGENTA);
        g.drawString("S", 430, 270);

        Font infoText = new Font("YuKyokasho", Font.BOLD, 45);
        g.setFont(infoText);
        g.setColor(Color.black);
        g.drawString("'ENTER' to start game", 25 + 1, 350 - 1);
        g.drawString("'ENTER' to start game", 25 + 1, 350 + 1);
        g.drawString("'ENTER' to start game", 25 - 1, 350 - 1);
        g.drawString("'ENTER' to start game", 25 - 1, 350 + 1);
        g.setColor(Color.WHITE);
        g.drawString("'ENTER' to start game", 25,350);

        g.setColor(new Color(80,89,116));
        g.drawLine(55,120,450,120);
        g.drawLine(55,400,450,400);

        Font instructionText = new Font("YuKyokasho", Font.BOLD, 20);
        g.setFont(instructionText);
        g.setColor(Color.BLACK);
        g.drawString("Use ← and → to move left and right", 80, 450);
        g.drawString("Use ↓ to move down, ↑ to rotate clockwise ", 50, 490);
        g.drawString("'Z' to rotate counterclockwise, 'A' for 180 degrees", 23,530);
        g.drawString("Press 'Q' to quit anytime ", 130,570);
    }

    /** checkStart checks if the start method process is running
     * @param boolean s - checks if started
     */
    public boolean checkStart(boolean s)
    {
        return s;
    }

    /** lose method shows the lose screen with GAME OVER text
     * @param Graphic g - imported variable from Swing
     */
    public void lose(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 550, 650);
        g.setColor(Color.WHITE);
        Font loseFont = new Font("Serif", Font.BOLD,80);
        g.setFont(loseFont);
        g.drawString("GAME OVER", 25, 210);

        Font loseFont2 = new Font("Serif", Font.BOLD, 50);
        g.setFont(loseFont2);

        g.drawString("SCORE: " + pointsGiven, 145, 310);
        g.drawString("LINES CLEARED: " + numClears, 50, 410);

    }

    /** drawPiece draws the new piece at the top of the screen
     * @param Graphic g - imported variable from Swing
     */
    public void drawPiece(Graphics g)
    {
        if (checkStart(s) && methodOn == true)
        {
            return;
        }
        if (checkLoss())
        {
            return;
        }
        else
        {
            g.setColor(colorsList[currentPiece]);
            for (Point p : tetrisObject[currentPiece][rotation])
            {
                g.fillRect((p.x + middlePoint.x) * 26,
                        (p.y + middlePoint.y) * 26,
                        25, 25);
            }
        }
    }

    /** drawFutPiece displays the next (future) piece
     * @param Graphic g - imported variable from Swing
     */
    public void drawFutPiece(Graphics g)
    {
        if (checkStart(s) && methodOn == true)
        {
            return;
        }
        if (checkLoss())
        {
            return;
        }
        else
        {
            g.setColor(colorsList[futurePiece]);
            for (Point p : tetrisObject[futurePiece][blankRotation])
            {
                g.fillRect(((p.x) * 26) + 375,
                        ((p.y) * 26) + 200,
                        25, 25);
            }
        }
    }

    /** paintComponent displays the background alongside the logistics on the right
     * @param Graphic g - imported variable from Swing
     */
    @Override
    public void paintComponent(Graphics g)
    {
        if (checkStart(s) && methodOn == true) {
            start(g);
        }
        else
        {
            //g.setColor(Color.GRAY);
            g.setColor(new Color(176,184,206));
            g.fillRect(0, 0, 550, 650);

            g.setColor(new Color(80,89,116));
            g.fillRect(0, 0, 26 * 12, 26 * 23);
            for (int i = 0; i < 12; i++)
            {
                for (int j = 0; j < 23; j++)
                {
                    g.setColor(grid[i][j]);
                    g.fillRect(26 * i, 26 * j, 25, 25);
                }
            }

            g.setColor(new Color(80,89,116));
            g.fillRect(360, 0, 110, 80);
            g.setColor(Color.BLACK);
            g.fillRect(370, 10, 90, 60);
            Font myFont = new Font("Serif", Font.BOLD, 12);
            g.setFont(myFont);
            g.setColor(Color.WHITE);
            g.drawString("SCORE ", 385, 35);
            g.drawString("" + pointsGiven, 385, 55);

            g.setColor(new Color(80,89,116));
            g.fillRect(340, 130, 160, 170);
            g.setColor(Color.BLACK);
            g.fillRect(350, 140, 140, 150);
            g.setFont(myFont);
            g.setColor(Color.WHITE);
            g.drawString("NEXT PIECE ", 380, 160);

            g.setColor(new Color(80,89,116));
            g.fillRect(345, 350, 150, 80);
            g.setColor(Color.BLACK);
            g.fillRect(355, 360, 130, 60);
            g.setFont(myFont);
            g.setColor(Color.WHITE);
            g.drawString("LINES CLEARED: ", 370, 380);
            g.drawString("" + numClears, 370, 405);


            g.setColor(new Color(80,89,116));
            g.fillRect(345, 497, 150, 80);
            g.setColor(Color.BLACK);
            g.fillRect(355, 507, 130, 60);
            g.setFont(myFont);
            g.setColor(Color.WHITE);
            g.drawString("LEVEL: " + level, 385, 540);

            drawPiece(g);
            drawFutPiece(g);
        }

        if (tetris)
        {
            Font tetrisFont = new Font("Serif", Font.BOLD, 50);
            g.setFont(tetrisFont);
            g.setColor(Color.YELLOW);

            long currentTime = System.currentTimeMillis();
            long futureTime = currentTime + 8000;

            for (long i = currentTime; i <= futureTime; i+= 1000)
            {

                g.setColor(Color.RED);
                g.drawString("T", 55, 200);
                g.setColor(Color.ORANGE);
                g.drawString("E", 90, 200);
                g.setColor(Color.YELLOW);
                g.drawString("T", 120, 200);
                g.setColor(Color.GREEN);
                g.drawString("R", 155, 200);
                g.setColor(Color.BLUE);
                g.drawString("I", 190, 200);
                g.setColor(Color.MAGENTA);
                g.drawString("S", 210, 200);

            }
            tetris = false;
        }

        if (checkLoss())
        {
            lose(g);
        }

    }
}
