package POTW;

import java.util.*;
/**
 * Write a description of class Wordle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordsBank
{
    public static void main(String[] args)
    {
        final String wordle = "words";
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] solution = new char[5];
        int i = 0;
        do
        {
            char[] guess = convert(guess(i));
            for(int j = 0; j<wordle.length(); j++)
            {
                for(int k = 0; k<guess.length; k++)
                {
                    if(guess[k] == wordle.charAt(j) && k==j)
                    {
                        solution[k] = guess[k];
                    }
                    else if (guess[k] == wordle.charAt(j))
                    {
                        for(int a : alphabet)
                        {
                            if(a == guess[k])
                            {
                                alphabet[a] = Character.toLowerCase(alphabet[a]);
                            }
                        }
                    }
                    else
                    {
                        for(int b : alphabet)
                        {
                            if (b == guess[k])
                            {
                                alphabet[b] = ' ';
                            }
                        }
                    }
                }
            }
            print(solution, alphabet);
            i++;
        }while ((i < 5) && !terminate(solution, wordle));

    }
    public static String guess(int guessNumber)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Guess: "+ guessNumber + "Please Enter A 5 Letter Word.");
        return s.nextLine().toUpperCase().substring(0,4);
    }
    public static char[] convert(String guess)
    {
        return guess.toCharArray();
    }
    public static void print(char[] solution, char[] alphabet)
    {
        System.out.println("This is your progress:");
        for(int c : solution)
        {
            System.out.print(solution[c]);
        }
        System.out.println("This is the letter bank:");
        System.out.println("Missing letters are not in the solution");
        System.out.println("Lower case letters are in the wrong place");
        for(int d : alphabet)
        {
            System.out.print(alphabet[d]);
        }
    }
    public static boolean terminate(char[] solution, String wordle)
    {
        int correct = 0;
        for(int i = 0; i<=5; i++)
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
