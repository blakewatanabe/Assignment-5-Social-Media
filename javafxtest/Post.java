package javafxtest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private User author;
    private String content;
    private int numberOfComments;
    private int numberOfViews;
    private double importanceValue;
    private Date creationDate;
    private List<Comment> comments;
    private List<User> viewers;
    private double positionX;
    private double positionY;

    public Post(User author, String content, int numberOfComments, int numberOfViews, Date creationDate) {
        this.author = author;
        this.content = content;
        this.numberOfComments = numberOfComments;
        this.numberOfViews = numberOfViews;
        this.creationDate = creationDate;
        this.comments = new ArrayList<>();
        this.viewers = new ArrayList<>();
        // Weights can be changed to make one worth more than the other (alpha is for # of comments, beta is # of views)
        calculateImportanceValue(0.5, 0.5); // This might be only needed for talking point 1.
    }

    // Getters and setters
    public User getAuthor(){
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public int getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(int numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public double getImportanceValue() {
        return importanceValue;
    }

    public void setImportanceValue(double importanceValue) {
        this.importanceValue = importanceValue;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getViewers() {
        return viewers;
    }

    public void setViewers(List<User> viewers) {
        this.viewers = viewers;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addViewer(User user) {
        this.viewers.add(user);
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void setPosition(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }

    public void calculateImportanceValue(double alpha, double beta) {
        this.importanceValue = alpha * numberOfComments + beta * numberOfViews;
    }
}
