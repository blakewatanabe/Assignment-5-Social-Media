package org.example.javafxtest;

// Representing a "weighted" edge between two users.
public class Connection {
    private User fromUser;
    private User toUser;
    private String relation;

    public Connection(User fromUser, User toUser, String relation) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.relation = relation;
    }

    // Getters and setters
    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
