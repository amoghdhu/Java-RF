package CustomProjects;

import java.util.*;

/**
 * Simple Player vs Player TicTacToe application (instructions printed at the start of the run)
 *
 * @author Amogh Dhumal
 * @version February 17, 2022
 */

public class TicTacToe
{

    static String[] table;
    static String turn;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String winner = null;
        turn = "X";
        table = new String[9];

        for (int y = 0; y < 9; y++)
        {
            table[y] = String.valueOf(y + 1);
        }

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("\nConditions: "
                + "\n - First player to get 3 in a row (vertically, horizontally, diagonally)"
                + "\n - Game will result in tie if no user gets 3 in a row"
                + "\n - When all tiles are filled, the game will end");

        System.out.println("\nExample Gameboard: ");
        printTable();

        System.out.println("_____________________");

        System.out.println("\n(X) Select a tile: ");

        while (winner == null)
        {
            int numInput;
            numInput = scanner.nextInt();


            if (!(numInput > 0 && numInput <= 9))
            {
                System.out.println("Invalid tile; select another tile\n");
                continue;
            }

            if (table[numInput - 1].equals(String.valueOf(numInput)))
            {
                table[numInput - 1] = turn;

                if (turn.equals("X"))
                {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printTable();
                winner = checkWinner();
            }
            else {
                System.out.println("That tile is in use; select another tile\n");
            }
        }

        if (winner.equalsIgnoreCase("draw"))
        {
            System.out.println("Draw! Try again!");
        }

        else {
            System.out.println("Congratulations " + winner + "! Thanks for playing.");
        }
    }
    /**
     * The checkWinner method has multiple switch cases set up to test if the "3 in a rows"
     */
    static String checkWinner()
    {
        for (int i = 0; i < 8; i++) {
            String line = null;


            switch (i)
            {
                case 0:
                    line = table[0] + table[3] + table[6];
                    break;
                case 1:
                    line = table[1] + table[4] + table[7];
                    break;
                case 2:
                    line = table[2] + table[5] + table[8];
                    break;
                case 3:
                    line = table[0] + table[4] + table[8];
                    break;
                case 4:
                    line = table[2] + table[4] + table[6];
                    break;
                case 5:
                    line = table[0] + table[1] + table[2];
                    break;
                case 6:
                    line = table[3] + table[4] + table[5];
                    break;
                case 7:
                    line = table[6] + table[7] + table[8];
                    break;

            }

            if (line.equals("XXX"))
            {
                return "X";
            }
            else if (line.equals("OOO"))
            {
                return "O";
            }
        }

        for (int x = 0; x < 9; x++)
        {
            if (Arrays.asList(table).contains(String.valueOf(x + 1))) {
                break;
            }
            else if (x == 8) {
                return "draw";
            }
        }

        System.out.println("\n(" + turn + ") Select a tile: ");
        return null;
    }

    /**
     * The printTable method displays the game board
     *
     */
    static void printTable()
    {
        System.out.println("+-----------+");
        System.out.println("+ " + table[0] + " | " + table[1] + " | " + table[2]+ " + ");

        System.out.println("+-----------+");
        System.out.println("+ " + table[3] + " | " + table[4] + " | " + table[5] + " + ");

        System.out.println("+-----------+");
        System.out.println("+ " + table[6] + " | " + table[7] + " | " + table[8] + " + ");

        System.out.println("+-----------+");
    }
}