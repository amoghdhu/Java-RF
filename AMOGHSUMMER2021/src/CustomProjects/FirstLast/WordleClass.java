package CustomProjects.FirstLast;

import java.util.*;
/**
 * Wordle is a recration of a web-based word game developed by Josh Wardle.
 * Players have six attempts to guess a five-letter word;
 * feedback is given for each guess, in the form of a letter bank,
 * indicating when letters match or occupy the correct position.
 *
 *
 */
public class WordleClass
{
    /**
     * The main method to which the game is played. The creation of character arrays occurs
     * in this method.
     */

    public static void main(String[] args)
    {
        final String wordle = "ADIEU";
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] solution = {'_','_','_','_','_'};
        int i = 0;
        System.out.println("Welcome to Wordle.");
        System.out.println("You have 6 tries to guess the mystery 5 letter word.");
        do
        {
            char[] guess = convert(guess(i+1));
            for(int j = 0; j<guess.length; j++)
            {
                boolean has = false;
                for(int k = 0; k<wordle.length(); k++)
                {
                    if(guess[j] == wordle.charAt(k) && k==j)
                    {
                        solution[j] = guess[j];
                        has = true;
                    }
                    else if (guess[j] == wordle.charAt(k))
                    {
                        solution[j] = Character.toLowerCase(guess[j]);
                        for(int m = 0; m<alphabet.length; m++)
                        {
                            if (alphabet[m] == guess[j])
                            {
                                alphabet[m] = Character.toLowerCase(alphabet[m]);
                            }
                        }
                        has = true;
                    }
                }
                if (!has)
                {
                    for(int l = 0; l<alphabet.length; l++)
                    {
                        for(int m = 0; m<guess.length; m++)
                        {
                            if(guess[j] == alphabet[l])
                            {
                                alphabet[l] = '_';
                            }
                        }
                    }
                }
            }
            print(solution, alphabet);
            i++;
        }while (i<6 && !terminate(solution, wordle));
        if(i>=6 && !terminate(solution, wordle))
        {
            System.out.println("You are out of tries. :(");
        }
        else if(i==1)
        {
            System.out.println("Congratulations! You got it in 1 try.");
        }
        else
        {
            System.out.println("Congratulations! You got it in "+i+" tries.");
        }
    }
    /**
     * The Guess method tracks what guess the user is on and makes sure that the player enters
     * the right amount of letters.
     *
     * @param guessNumber which is used to print the guess number to the user in order for them to
     *        know how many guesses they have used
     */
    public static String guess(int guessNumber)
    {
        Scanner s = new Scanner(System.in);
        String guess = "";
        while(guess.length()<5)
        {
            System.out.println("Please enter your 5-letter guess #"+guessNumber);
            guess = s.nextLine();
        }
        return guess.toUpperCase().substring(0,5);
    }
    /**
     * the method, convert, changes a string into a character array.
     *
     * @param guess what the user enters. changed into a character array in order for later
     *        methods to check each letter of the array for correction.
     */
    public static char[] convert(String guess)
    {
        return guess.toCharArray();
    }

    public static void print(char[] solution, char[] alphabet)
    {
        System.out.println("This is your progress:");
        for(char c: solution)
        {
            System.out.print(c);
        }
        System.out.println();
        System.out.println("This is the letter bank:");
        for(char d: alphabet)
        {
            System.out.print(d+" ");
        }
        System.out.println();
    }

    public static boolean terminate(char[] solution, String wordle)
    {
        int correct = 0;
        for(int i = 0; i<5; i++)
        {
            if(solution[i] == wordle.charAt(i))
            {
                correct+=1;
            }
        }
        if(correct==5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
