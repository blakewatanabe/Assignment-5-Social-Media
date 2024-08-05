package javafxtest;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class GraphVisualizer {
    private Graph graph;
    private Pane pane;
    private Map<User, Circle> userNodeMap;
    private Map<Post, Circle> postNodeMap;

    public GraphVisualizer(Graph graph, Pane pane) {
        this.graph = graph;
        this.pane = pane;
        this.userNodeMap = new HashMap<>();
        this.postNodeMap = new HashMap<>();
    }

    public void drawGraph() {
        // Creating user nodes by generating a circle from the drawUserNode method below
        int userIndex = 0; // Using an index to increment the position of the node
        for (User user : graph.getUsers()) { // Looping through the list of users in the graph, or exist on this platform
            double x = 100 + (userIndex % 5) * 150; // X-length between each of the user nodes
            double y = 100 + (userIndex / 5) * 150; // Y-length between each of the user nodes
            drawUserNode(user, x, y); // Creates a circle for a user node
            userIndex++;
        }

        // Creating post nodes with circles generated from drawPostNode method below
        // Then creates an edge with the
        int postIndex = 0; // Using an index to increment the position of the node
        for (Post post : graph.getPosts()) { // posts that exist on the platform
            double x = 100 + (postIndex % 5) * 150; // Distances between the post nodes
            double y = 400 + (postIndex / 5) * 150;
            drawPostNode(post, x, y); // Creates circle and determines the color based on the importance value
            drawEdgesForPost(post);
            postIndex++;
        }
    }

    private void drawUserNode(User user, double x, double y) {
        Circle circle = new Circle(x, y, 20, Color.GREEN);
        Text text = new Text(x - 10, y + 5, user.getUserName()); // Placing the name of the user in the node
        pane.getChildren().addAll(circle, text); // Combing the circle and text, adding it to the pane
        userNodeMap.put(user, circle); // Adding to the hashmap
        user.setPosition(x, y); // Setting the position attribute in the User class
    }

    private void drawPostNode(Post post, double x, double y) {
        Circle circle = new Circle(x, y, 20, importanceColor(post.getImportanceValue()));
        Text text = new Text(x - 10, y + 5, post.getContent());
        pane.getChildren().addAll(circle, text); // Combing the circle and text, adding it to the pane
        postNodeMap.put(post, circle); // Adding to the hashmap
        post.setPosition(x, y); // Setting the position in a Post object
    }

    private void drawEdgesForPost(Post post) {
        User author = post.getAuthor();
        drawEdge(author, post, "authored");

        for (User viewer : post.getViewers()) {
            drawEdge(viewer, post, "viewed");
        }
    }

    private void drawEdge(User user, Post post, String relationship) {
        Circle userCircle = userNodeMap.get(user);
        Circle postCircle = postNodeMap.get(post);

        if (userCircle != null && postCircle != null) {
            Line line = new Line(userCircle.getCenterX(), userCircle.getCenterY(), postCircle.getCenterX(), postCircle.getCenterY());
            line.setStroke(Color.GRAY);

            // Positions the text in the middle of the edge between connected nodes
            double midX = (userCircle.getCenterX() + postCircle.getCenterX()) / 2;
            double midY = (userCircle.getCenterY() + postCircle.getCenterY()) / 2;
            Text text = new Text(midX, midY, relationship);

            pane.getChildren().addAll(line, text);
        }
    }

    private Color importanceColor(double importanceValue) {
        // Highlighting the important posts with a different color, in this case Red is more important
        if (importanceValue > 10) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }
}

