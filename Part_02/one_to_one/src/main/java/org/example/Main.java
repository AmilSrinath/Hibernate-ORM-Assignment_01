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

        Book book = new Book();
        Author author = new Author();

        //---------------------------------------------------
        System.out.print("Book ID : ");
        book.setBid(input.nextLine());

        System.out.print("Book ISBN : ");
        book.setISBN(input.nextLine());

        System.out.print("Book Title : ");
        book.setTitle(input.nextLine());

        //---------------------------------------------------
        System.out.print("Author ID : ");
        author.setAid(input.nextLine());

        System.out.print("Author Name : ");
        author.setName(input.nextLine());

        System.out.print("Author Email : ");
        author.setEmail(input.nextLine());

        author.setBid(book);

        //---------------------------------------------------

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(author);

        transaction.commit();
        session.close();
        options();
    }

    public static void updateBookAndAuthor(){
        Scanner input = new Scanner(System.in);

        Book book = new Book();
        Author author = new Author();

        //---------------------------------------------------
        System.out.print("Book ID : ");
        book.setBid(input.nextLine());

        System.out.print("Book ISBN : ");
        book.setISBN(input.nextLine());

        System.out.print("Book Title : ");
        book.setTitle(input.nextLine());
        //---------------------------------------------------
        System.out.print("Author ID : ");
        author.setAid(input.nextLine());

        System.out.print("Author Name : ");
        author.setName(input.nextLine());

        System.out.print("Author Email : ");
        author.setEmail(input.nextLine());

        author.setBid(book);

        //---------------------------------------------------

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(book);
            session.update(author);
            transaction.commit();
        }catch (Exception ex){
            System.out.println("Don't Mach ID, Try Again!!");
        }finally {
            session.close();
            options();
        }
    }

    public static void deleteBookAndAuthor(){
        Scanner input = new Scanner(System.in);

        System.out.print("Book ID : ");
        String bid = input.nextLine();

        System.out.print("Author ID : ");
        String aid = input.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Author author = session.get(Author.class, aid);
            Book book = session.get(Book.class, bid);

            session.delete(author);
            session.delete(book);

            transaction.commit();
            options();
        }catch (Exception e){
            System.out.println("Don't Mach Author ID and Book ID, Try Again!!");
        }finally {
            session.close();
            options();
        }
    }

    public static void searchBookAndAuthor(){
        Scanner input = new Scanner(System.in);

        System.out.print("Book ID : ");
        String bid = input.nextLine();

        System.out.print("Author ID : ");
        String aid = input.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            System.out.println(session.get(Book.class, bid).toString());
            System.out.println(session.get(Author.class, aid).toString());
            transaction.commit();

        }catch (Exception e){
            System.out.println("Don't Mach ID, Try Again!!");
        }finally {
            session.close();
            options();
        }
    }
}