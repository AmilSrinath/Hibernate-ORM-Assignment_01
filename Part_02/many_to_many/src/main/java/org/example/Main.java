package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        options();
    }

    public static void options() {
        Scanner input = new Scanner(System.in);
        f:while (true) {
            for (int i = 0; i < 39; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("|        1 Book & Author Save         |");
            System.out.println("|        2 Book & Author Update       |");
            System.out.println("|        3 Book & Author Delete       |");
            System.out.println("|        4 Book & Author Search       |");
            for (int i = 0; i < 39; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.print("Select Option : ");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    saveBookAndAuthor();
                case 2:
                    updateBookAndAuthor();
                case 3:
                    deleteBookAndAuthor();
                case 4:
                    searchBookAndAuthor();
                default:
                    System.out.println("Invalid!!, Try Again!!");
                    continue f;
            }
        }
    }

    public static void saveBookAndAuthor(){
        Scanner input = new Scanner(System.in);

        Author author1 = new Author();
        author1.setAid("A001");
        author1.setName("Srinath");
        author1.setEmail("amilsrinath@gmail.com");

        Author author2 = new Author();
        author2.setAid("A002");
        author2.setName("Srinath");
        author2.setEmail("amilsrinath@gmail.com");

        Book book1 = new Book();
        book1.setBid("B001");
        book1.setISBN("123");
        book1.setTitle("ABC");

        Book book2 = new Book();
        book2.setBid("B002");
        book2.setISBN("123");
        book2.setTitle("ABC");

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author2);

        author1.getBooks().add(book1);
        author2.getBooks().add(book2);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book1);
        session.persist(author1);
        session.persist(book2);
        session.persist(author2);

        transaction.commit();
        session.close();
        options();
    }

    public static void updateBookAndAuthor(){

    }

    public static void deleteBookAndAuthor(){

    }

    public static void searchBookAndAuthor(){

    }
}