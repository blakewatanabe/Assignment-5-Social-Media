package org.example.javafxtest;

import java.util.Date;

public class Comment {
    private String content;
    private User author;
    private Date dateCreated;

    public Comment(String content, User author, Date dateCreated) {
        this.content = content;
        this.author = author;
        this.dateCreated = dateCreated;
    }

    // Getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return dateCreated;
    }

    public void setCreationDate(Date creationDate) {
        this.dateCreated = creationDate;
    }
}
