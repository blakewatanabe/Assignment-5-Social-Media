import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    //Using Map allows for O(1) average time complexities for lookup, insertion, and deletion with quick access using keys.
    private Map<String, User> users; // Storing data in key(username) and value(User object) pairs,
    private Map<String, Post> posts; // Key (post content), value (Post object)

    public Graph() {
        // Hashmap uses keys that serves as the nodes, paired with values which are the adjacency lists
        this.users = new HashMap<>();
        this.posts = new HashMap<>();
    }

    public void addUser(User userToAdd) {
        users.put(userToAdd.getUserName(), userToAdd);
    }

    public void addPost(Post postToAdd) {
        posts.put(postToAdd.getContent(), postToAdd);
    }

    // Edges that have a "value" which is a string describing the type of connection between two users.
    // Connections (which are also objects) are stored within a list in a User object.
    public void addConnection(String fromUser, String toUser, String type) {
        User from = users.get(fromUser);
        User to = users.get(toUser);
        if (from != null && to != null) {
            from.addConnection(new Connection(from, to, type));
        }
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public Post getPost(String content) {
        return posts.get(content);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }
}
