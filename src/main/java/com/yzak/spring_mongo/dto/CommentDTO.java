package com.yzak.spring_mongo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "comment")
public class CommentDTO implements Serializable {

    @Id
    private String Id;
    private LocalDateTime date;
    private String text;

    private AuthorDTO author;

    public CommentDTO(){}

    public CommentDTO(String id, LocalDateTime date, AuthorDTO author, String text) {
        Id = id;
        this.date = date;
        this.author = author;
        this.text = text;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
