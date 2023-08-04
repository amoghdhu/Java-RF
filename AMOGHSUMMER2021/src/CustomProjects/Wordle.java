package CustomProjects;

import java.util.Scanner;

/**
 * Write a description of class Wordle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wordle {

    public static void main(String[] args) {
        Integer[] list  = {3,15,61,11,7,9,2};
        //System.out.println(sort1(list));


    }

    public static void sort1(Comparable[] list)
    {
        int i, j, min;
        for( i=0; i<list.length-1; i++)
        {
            min = i;
            for(j=i+1; j<list.length; j++)
            {
                if(list[min].compareTo(list[j]) > 0)
                    min = j;
            }
            if( min != i)
            {
                Comparable temp = list[min];
                list[min] = list[i];
                list[i] = temp;
            }
        }

    }
}