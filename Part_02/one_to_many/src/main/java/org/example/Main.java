package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        options();
    }

    public static void options() {
        Scanner input = new Scanner(System.in);
        f:while (true) {
            for (int i = 0; i < 32; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("|        1 Book Save           |");
            System.out.println("|        2 Book Update         |");
            System.out.println("|        3 Book Delete         |");
            System.out.println("|        4 Book Search         |");
            System.out.println("--------------------------------");
            System.out.println("|        5 Author Save         |");
            System.out.println("|        6 Author Update       |");
            System.out.println("|        7 Author Delete       |");
            System.out.println("|        8 Author Search       |");
            for (int i = 0; i < 32; i++) {
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
                case 5:
                    saveAuthor();
                case 6:
                    updateAuthor();
                case 7:
                    deleteAuthor();
                case 8:
                    searchAuthor();
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

    public static void saveAuthor(){

    }

    public static void updateAuthor(){

    }

    public static void deleteAuthor(){

    }

    public static void searchAuthor(){

    }
}