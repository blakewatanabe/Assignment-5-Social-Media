public class Connection {
    private User fromUser;
    private User toUser;
    private String type;

    public Connection(User fromUser, User toUser, String type) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
