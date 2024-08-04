import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private String content;
    private int numberOfComments;
    private int numberOfViews;
    private double importanceValue;
    private Date dateCreated;
    private List<Comment> comments;
    private List<User> viewers;

    public Post(String content, int numberOfComments, int numberOfViews, Date dateCreated) {
        this.content = content;
        this.numberOfComments = numberOfComments;
        this.numberOfViews = numberOfViews;
        this.dateCreated = dateCreated;
        this.comments = new ArrayList<>();
        this.viewers = new ArrayList<>();
        // This might be only needed for talking point 1.
        // Weights can be changed to make one worth more than the other (alpha is for # of comments, beta is # of views)
        calculateImportanceValue(0.5, 0.5); // This might be only needed for talking point 1.
    }

    // Getters and setters
    public String getContent() {
        return content;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date creationDate) {
        this.dateCreated = creationDate;
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

    public void calculateImportanceValue(double alpha, double beta) {
        this.importanceValue = alpha * numberOfComments + beta * numberOfViews;
    }
}
