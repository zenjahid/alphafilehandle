package com.filehandle;

// packages
import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {

            // using string split
            try (BufferedReader f = new BufferedReader(new FileReader("readfile.txt"))) {
                String i;

                while ((i = f.readLine()) != null) {
                    String arr[] = i.split(" ");
                    String winner = null;
                    if (Integer.parseInt(arr[1]) > Integer.parseInt(arr[2])) {
                        arr[1] = Integer.toString(Integer.parseInt(arr[1]) + Integer.parseInt(arr[3]));
                        winner = "Biden";
                    } else {
                        arr[2] = Integer.toString(Integer.parseInt(arr[2]) + Integer.parseInt(arr[3]));
                        winner = "Trump";
                    }
                    System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]
                            + " The winner of this state is = " + winner);
                }

            } catch (Exception e) {
            }
            // using tokenizer
            try (BufferedReader f = new BufferedReader(new FileReader("readfile.txt"))) {
                String i;

                while ((i = f.readLine()) != null) {
                    String winner = null;
                    StringTokenizer str = new StringTokenizer(i);
                    String state = str.nextToken();
                    int biden = Integer.parseInt(str.nextToken());
                    int trump = Integer.parseInt(str.nextToken());
                    int electoral = Integer.parseInt(str.nextToken());

                    if (biden > trump) {
                        biden += electoral;
                        winner = "Biden";
                    }
                    if (biden < trump) {
                        trump += electoral;
                        winner = "Trump";
                    }
                    System.out.println(
                            state + " " + biden + " " + trump + " " + electoral + " The winner is = " +
                                    winner);

                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
