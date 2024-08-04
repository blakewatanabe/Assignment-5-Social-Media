package org.example.javafxtest;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String realName;
    private List<Connection> connections;
    private List<Post> postsCreated;
    private List<Post> postsViewed;
    private List<Comment> comments;

    public User(String userName, String realName, int age, String gender, String location) {
        this.userName = userName;
        this.realName = realName;
        this.connections = new ArrayList<>();
        this.postsCreated = new ArrayList<>();
        this.postsViewed = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Post> getPostsAuthored() {
        return postsCreated;
    }

    public void setPostsAuthored(List<Post> postsCreated) {
        this.postsCreated = postsCreated;
    }

    public List<Post> getPostsViewed() {
        return postsViewed;
    }

    public void setPostsViewed(List<Post> postsViewed) {
        this.postsViewed = postsViewed;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }
}
