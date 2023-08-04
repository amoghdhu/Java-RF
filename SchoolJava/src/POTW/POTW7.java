package POTW;

import java.util.Scanner;

public class POTW7 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        int reverse = number;
        for(int i = 2; reverse != i; i++)
        {
            reverse = reverse / i;
        }
        System.out.println("Reverse factorial of is: " + reverse);

    }
}
