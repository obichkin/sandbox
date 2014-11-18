package com.obichkin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mobichkin on 12/03/14.
 */
public class MyCharacterStream {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter wrighter = null;
        int c;

        try{
            reader = new FileReader("input.txt");
            wrighter = new FileWriter("output.txt");

            while((c = reader.read()) != -1){
                wrighter.write(c);
                System.out.print((char)c);
            }
        }finally {
            if(reader != null){
                reader.close();
            }
            if(wrighter != null){
                wrighter.close();
            }
        }
    }
}
