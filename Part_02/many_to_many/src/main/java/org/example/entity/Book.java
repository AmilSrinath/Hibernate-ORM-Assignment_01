package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    private String bid;
    private String ISBN;
    private String title;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Book() {
    }

    public Book(String bid, String ISBN, String title, List<Author> authors) {
        this.bid = bid;
        this.ISBN = ISBN;
        this.title = title;
        this.authors = authors;
    }
}