package CH1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {
    public static void main (String[] args) throws IOException {
        //System.out.print(getUserInput("enter  number"));

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number");
        int n= Integer.parseInt(br.readLine());
        if(n>0)
        {
            System.out.println("The number is POSITIVE");
        }
        else if(n<0)
        {
            System.out.println("The number is NEGATIVE");
        }
        else
        {
            System.out.println("The number is ZERO");
        }
    }

    public static String getUserInput(String prompt){
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        }catch (IOException e) {
                System.out.print("IO Exception" + e);
            }
        return  inputLine;
        }
    }

