package CustomProjects;

import java.util.Scanner;

/**
 * This Wordle Application is a MOCK Wordle (originally created by Josh Wardle).
 * Users enter 5 letter guesses in order to decipher the word with a maximum of 6 tries.
 *
 * @author Amogh Dhumal
 * @version 02/09/2022
 */

public class MoreWordle {
    static final String wordleOTD = "ADIEU";
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static char[] result = {'_','_','_','_','_'};


    /**
     * The main method contains most of the operations with making and checking of the character arrays.
     *
     */
    public static void main(String[] args) {
        System.out.println("MOCK Wordle (inspired by Josh Wardle)");
        System.out.println("\nIn six trials, guess the WORDLE. Each guess must be a five-letter " +
                "\nword that is acceptable. To submit, use the enter key. \n" +
                "Upon completion of each guess, the output will inform \n" +
                "how close your guess was to the word.\n\n");

            int i = 0;
            do
            {
                char[] guess = stringToArray(input(i + 1));
                for(int j = 0; j < guess.length; j++)
                {
                    boolean isWord = false;
                    for(int k = 0; k < wordleOTD.length(); k++)
                    {
                        if(guess[j] == wordleOTD.charAt(k) && k==j)
                        {
                            result[j] = guess[j];
                            isWord = true;
                        }
                        else if (guess[j] == wordleOTD.charAt(k))
                        {
                            result[j] = Character.toLowerCase(guess[j]);
                            for(int m = 0; m < alphabet.length; m++)
                            {
                                if (alphabet[m] == guess[j])
                                {
                                    alphabet[m] = Character.toLowerCase(alphabet[m]);
                                }
                            }
                            isWord = true;
                        }
                    }
                    if (!isWord)
                    {
                        for(int x = 0; x < alphabet.length; x++)
                        {
                            for(int y = 0; y < guess.length; y++)
                            {
                                if(guess[j] == alphabet[x])
                                {
                                    alphabet[x] = '_';
                                }
                            }
                        }
                    }
                }
                toString(result, alphabet);
                i++;
            }while (i < 6 && !remove(result, wordleOTD));

            if(i >= 6 && !remove(result, wordleOTD))
            {
                System.out.println("Nice try, you have ran out of attempts. The correct word was " + wordleOTD);
            }
            else if(i == 1)
            {
                System.out.println("Congratulations! You got it in 1 attempt.");
            }
            else
            {
                System.out.println("Congratulations! You got it in " + i + " attempts.");
            }

    }

    /**
     * The input method tracks the user's guess and ensure's only the first 5 characters of the input is
     * taken into consideration.
     *
     * //@param int totalGuesses: Records the amount of guesses the user utilizes through the span of the game.
     */
    public static String input(int totalGuesses)
    {
        Scanner scanner = new Scanner(System.in);
        String guess = "";

        while (guess.length() < 5)
        {
            System.out.println("Enter a 5-letter guess (#" + totalGuesses + "):");
            guess = scanner.next();

        }
        return guess.toUpperCase().substring(0, 5);

    }

    /**
     * toString method is used as a print method that prints the character's and letters depending if they're
     * in the solution or alphabet
     *
     * //@param char[] solution: used to print the correct and incorrect slots of the users guess and the wordle.
     * //@param char[] alphabet: used to print the letters that have and haven't been used.
     */
    public static void toString(char[] solution, char[] alphabet)
    {
        for(char character: solution)
        {
            System.out.print(character);
        }
        System.out.println();
        for(char letter: alphabet)
        {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    /**
     * stringToArray method converts the the provided String into a character array.
     *
     * //@param String guessWord: utilizes user's guess to change into character array.
     */
    public static char[] stringToArray(String guessWord)
    {
        char[] array = new char[5];
        for (int i = 0; i < guessWord.length(); i++)
        {
            array[i] = guessWord.charAt(i);
        }
        return array;
    }

    /**
     * remove method checks and matches the user input with the wordle.
     *
     * //@param char[] result: used as a placeholder for the user's inputs
     * //@param String wordle: variable stored for the wordle
     */
    public static boolean remove(char[] result, String wordle)
    {
        int correct = 0;
        for(int i = 0; i < 5; i++)
        {
            if(result[i] == wordle.charAt(i))
            {
                correct += 1;
            }
        }
        if (correct == 5)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
