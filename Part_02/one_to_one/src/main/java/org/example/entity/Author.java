package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
    @Id
    private String aid;
    private String name;
    private String email;
    @OneToOne
    private Book book;

    @Override
    public String toString() {
        return "Author{" +
                "aid='" + aid + '\'' +
                ", name='" + name + '\'' +
                ", email=" + email +
                ", bid='" + book + '\'' +
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

    public Book getBid() {
        return book;
    }

    public void setBid(Book book) {
        this.book = book;
    }

    public Author() {
    }

    public Author(String aid, String name, String email, Book book) {
        this.aid = aid;
        this.name = name;
        this.email = email;
        this.book = book;
    }
}
