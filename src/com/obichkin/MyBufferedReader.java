package com.obichkin;

import java.io.*;

/**
 * Created by mobichkin on 12/03/14.
 */
public class MyBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        PrintWriter writer = null;
        String s;

        try{
            reader = new BufferedReader(new FileReader("input.txt"));
            writer = new PrintWriter(new FileWriter("output.txt"));
            while((s = reader.readLine()) != null){
                writer.println(s);
                writer.flush();
                System.out.println(s);
            }

        }finally {
            if(reader != null){
                reader.close();
            }
            if(writer != null){
                writer.close();
            }
        }
    }
}
