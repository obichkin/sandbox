package com.obichkin;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mobichkin on 13/03/14.
 */
public class MyScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = null;
        String s;
        Console console = null;
        char[] pass;

        try{
            /*
            scanner = new Scanner(new BufferedReader(new FileReader("input.txt")));
            scanner.useDelimiter(";");
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            */

            /*
            scanner = new Scanner(new InputStreamReader(System.in));
            System.out.println("Input your line:");
            s = scanner.nextLine();
            System.out.format("Your input: %s", s);
             */

            console = System.console();
            System.out.println("Enter your login: ");
            s = console.readLine();
            System.out.println("Enter your secure password: ");
            pass = console.readPassword();
            System.out.format("Your secure password for %s is: %s", s, Arrays.toString(pass) );

        }finally{
            if(scanner != null){
                scanner.close();
            }
        }
    }
}
