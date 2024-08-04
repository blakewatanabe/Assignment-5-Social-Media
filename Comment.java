import java.util.Date;

public class Comment {
    private String content;
    private User author;
    private Date creationDate;

    public Comment(String content, User author, Date creationDate) {
        this.content = content;
        this.author = author;
        this.creationDate = creationDate;
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
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
