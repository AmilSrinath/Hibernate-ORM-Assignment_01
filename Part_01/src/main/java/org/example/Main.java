package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        options();
    }

    public static void options() throws IOException {
        Scanner input = new Scanner(System.in);
        f:while (true) {
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("|        1 Book Save         |");
            System.out.println("|        2 Book Update       |");
            System.out.println("|        3 Book Delete       |");
            System.out.println("|        4 Book Search       |");
            for (int i = 0; i < 30; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.print("Select Option : ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    saveBook();
                case 2:
                    updateBook();
                case 3:
                    deleteBook();
                case 4:
                    searchBook();
                default:
                    System.out.println("Invalid!!, Try Again!!");
                    continue f;
            }
        }
    }

    public static void saveBook(){

    }

    public static void updateBook(){

    }

    public static void deleteBook(){

    }

    public static void searchBook(){

    }
}