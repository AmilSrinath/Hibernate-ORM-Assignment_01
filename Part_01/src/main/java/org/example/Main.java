package org.example;

import org.example.Util.FactoryConfiguration;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        options();
    }

    public static void options() {
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
        Scanner input = new Scanner(System.in);

        System.out.print("Book ID : ");
        String id = input.nextLine();

        System.out.print("Book ISBN : ");
        String isbn = input.nextLine();

        System.out.print("Book Title : ");
        String title = input.nextLine();

        System.out.print("Book Author : ");
        String author = input.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Book(
                id,
                isbn,
                title,
                author
        ));
        transaction.commit();
        session.close();
        options();
    }

    public static void updateBook(){
        Scanner input = new Scanner(System.in);

        System.out.print("Book ID : ");
        String id = input.nextLine();

        System.out.print("Book ISBN : ");
        String isbn = input.nextLine();

        System.out.print("Book Title : ");
        String title = input.nextLine();

        System.out.print("Book Author : ");
        String author = input.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(new Book(
                    id,
                    isbn,
                    title,
                    author
            ));
            transaction.commit();
        }catch (Exception ex){
            System.out.println("Don't Mach ID, Try Again!!");
        }finally {
            session.close();
            options();
        }
    }

    public static void deleteBook(){

    }

    public static void searchBook(){

    }
}