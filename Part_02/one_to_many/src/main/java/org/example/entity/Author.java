package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    private String aid;
    private String name;
    private String email;
    @OneToMany( mappedBy = "author")
    @Cascade(value = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Author{" +
                "aid='" + aid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                '}';
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Author() {
    }

    public Author(String aid, String name, String email, List<Book> books) {
        this.aid = aid;
        this.name = name;
        this.email = email;
        this.books = books;
    }
}
