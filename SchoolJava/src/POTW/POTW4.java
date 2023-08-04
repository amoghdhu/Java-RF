package POTW;

import java.util.Scanner;

public class POTW4 {
    public static int fibonacci(int value)
    {
        if (value <= 1){
            return value;
        }
        return fibonacci(value-1) + fibonacci(value-2);
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int response = input.nextInt();

        if (response > 0 && response <= 1000){
            System.out.println(fibonacci(response));
        }
    }
}
