package javafxtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Date;

public class GraphRepMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Graph socialMediaGraph = new Graph();

        // Create some sample data
        User user1 = new User("aliceB", "Alice", 25, "Female", "NYC");
        User user2 = new User("BBob", "Bob", 30, "Male", "LA");
        User user3 = new User("Dub", "Wayne", 30, "Male", "LA");
        User user4 = new User("Victory", "Victoria", 30, "Female", "LA");
        User user5 = new User("CDawg", "Connor", 30, "Male", "LA");

        // Creating posts that are authored by existing users on the media platform
        Post helloWorld = new Post(user1, "Hello world!", 0, 2, new Date());
        Post algoCool = new Post(user2, "Algorithms are cool!", 10, 50, new Date());

        // Adding users to a Post object's viewer list
        helloWorld.getViewers().add(user3);
        helloWorld.getViewers().add(user4);
        algoCool.getViewers().add(user3);
        algoCool.getViewers().add(user4);
        algoCool.getViewers().add(user5);

        // Adding users and posts to the graph
        socialMediaGraph.addUser(user1);
        socialMediaGraph.addUser(user2);
        socialMediaGraph.addUser(user3);
        socialMediaGraph.addUser(user4);
        socialMediaGraph.addUser(user5);
        socialMediaGraph.addPost(helloWorld);
        socialMediaGraph.addPost(algoCool);

        GraphVisualizer visualizer = new GraphVisualizer(socialMediaGraph, pane);
        visualizer.drawGraph(); //Using the visualizer class to create user and post nodes connected by edges

        Scene scene = new Scene(pane, 800, 600); // Size of the area for the visualization
        primaryStage.setTitle("Social Media Graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
