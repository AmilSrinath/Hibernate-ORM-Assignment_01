package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private String bid;
    private String ISBN;
    private String title;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Book(String bid, String ISBN, String title) {
        this.bid = bid;
        this.ISBN = ISBN;
        this.title = title;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Book(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    public Book(String bid) {
        this.bid = bid;
    }
}