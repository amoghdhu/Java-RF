package POTW;
import java.util.Scanner;
import java.io.*;

public class MyClass {
    public static void main(String args[]) {
        String[] names = { "hello", "amogh" };
        String name = names[(int) (Math.random() * names.length)];
        System. out. println(name);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.print(input);


        while (true){
        if (input.equals(name))
        {
            System.out.println("You got it!");
            break;
        }
        else{
            System.out.println("");
        }

    }
    }
}

