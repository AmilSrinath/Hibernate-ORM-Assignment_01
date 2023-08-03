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
            for (int i = 0; i < 32; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println("|        1 Book Save           |");
            System.out.println("|        2 Book Update         |");
            System.out.println("|        3 Book Delete         |");
            System.out.println("|        4 Book Search         |");

            for (int i = 0; i < 32; i++) {
                System.out.print("-");
            }
            System.out.println();
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
        Scanner input = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Book ID : ");
        book.setBid(input.nextLine());

        System.out.print("Book ISBN : ");
        book.setISBN(input.nextLine());

        System.out.print("Book Title : ");
        book.setTitle(input.nextLine());

        System.out.print("Author ID : ");
        String aid = input.nextLine();

        List<Book> books = new ArrayList<>();
        books.add(book);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Author author = session.get(Author.class, aid);
            book.setAuthor(author);

            session.persist(author);
            session.persist(book);

            transaction.commit();
        }catch (Exception e) {
            System.out.println("Don't Mach Author ID!!");
        }finally {
            session.close();
            options();
        }
    }

    public static void saveAuthor(){
        Scanner input = new Scanner(System.in);
        Author author = new Author();

        System.out.print("Author ID : ");
        author.setAid(input.nextLine());

        System.out.print("Author Name : ");
        author.setName(input.nextLine());

        System.out.print("Author Email : ");
        author.setEmail(input.nextLine());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author);

        transaction.commit();
        session.close();
        options();
    }

    public static void updateBook(){
        Scanner input = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Book ID : ");
        book.setBid(input.nextLine());

        System.out.print("Book ISBN : ");
        book.setISBN(input.nextLine());

        System.out.print("Book Title : ");
        book.setTitle(input.nextLine());

        System.out.print("Author ID : ");
        String aid = input.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Author author = session.get(Author.class, aid);
        author.setAid(aid);
        try{
            session.update(book);
            transaction.commit();
        }catch (Exception ex){
            System.out.println("Don't Mach ID, Try Again!!");
            ex.printStackTrace();
        }finally {
            session.close();
            options();
        }
    }

    public static void updateAuthor(){
        Scanner input = new Scanner(System.in);
        Author author = new Author();

        System.out.print("Author ID : ");
        author.setAid(input.nextLine());

        System.out.print("Author Email : ");
        author.setEmail(input.nextLine());

        System.out.print("Author Name : ");
        author.setName(input.nextLine());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.update(author);
            transaction.commit();
        }catch (Exception ex){
            System.out.println("Don't Mach ID, Try Again!!");
            ex.printStackTrace();
        }finally {
            session.close();
            options();
        }
    }

    public static void deleteBook(){
        Scanner input = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Book ID : ");
        book.setBid(input.nextLine());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(book);
            transaction.commit();
        }catch (Exception ex){
            System.out.println("Don't Mach ID, Try Again!!");
            ex.printStackTrace();
        }finally {
            session.close();
            options();
        }
    }

    public static void deleteAuthor(){
        Scanner input = new Scanner(System.in);
        Author author = new Author();

        System.out.print("Author ID : ");
        author.setAid(input.nextLine());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            session.delete(author);
            transaction.commit();
        }catch (Exception ex){
            System.out.println("Don't Mach ID, Try Again!!");
            ex.printStackTrace();
        }finally {
            session.close();
            options();
        }
    }

    public static void searchBook(){

    }

    public static void searchAuthor(){

    }

}