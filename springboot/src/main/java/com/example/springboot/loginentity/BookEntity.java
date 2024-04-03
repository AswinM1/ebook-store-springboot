package com.example.springboot.loginentity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookEntity {

    @Id
    private int bid;
    private String  name;
    private String  genre;
    private String  author;
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public BookEntity(int bid, String name, String genre, String author) {
        this.bid = bid;
        this.name = name;
        this.genre = genre;
        this.author = author;
    }
    

    
   

}
