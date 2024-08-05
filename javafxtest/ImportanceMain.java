package javafxtest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class ImportanceMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create users
        User user1 = new User("johnD", "John Doe", 25, "Male", "New York");
        User user2 = new User("janeS", "Jane Smith", 30, "Female", "Los Angeles");

        // Create posts
        Post johnPost = new Post(user1, "Hello world!", 10, 50, new Date());
        Post janePost = new Post(user2,"Algorithms are cool!", 5, 100, new Date());
        Post musicPost = new Post(user1, "I love music!", 3, 70, new Date());
        Post uTuberPost = new Post(user2, "Sponsored by Raid Shadow Legends", 100, 150, new Date());
        Post streamerPost = new Post(user1, "Don't forget your Prime sub", 30, 120, new Date());

        // Create comments
        Comment comment1 = new Comment("Hello!", user2, new Date());
        Comment comment2 = new Comment("Very informative.", user1, new Date());

        // Add comments to posts
        johnPost.addComment(comment1);
        janePost.addComment(comment2);

        // Add posts to users
        user1.getPostsAuthored().add(johnPost);
        user2.getPostsAuthored().add(janePost);

        // Create connections
        Connection johnAndJane = new Connection(user1, user2, "friends");

        // Add connections to users
        user1.addConnection(johnAndJane);

        // Create a social media graph
        Graph socialMedia = new Graph();
        socialMedia.addUser(user1);
        socialMedia.addUser(user2);
        socialMedia.addPost(johnPost);
        socialMedia.addPost(janePost);
        socialMedia.addPost(musicPost);
        socialMedia.addPost(uTuberPost);
        socialMedia.addPost(streamerPost);

        // JavaFX setup
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Post");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Count");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Social Media Analysis");

        // Add data to the chart
        XYChart.Series<String, Number> commentChart = new XYChart.Series<>();
        commentChart.setName("Comments");

        XYChart.Series<String, Number> viewChart = new XYChart.Series<>();
        viewChart.setName("Views");

        XYChart.Series<String, Number> importanceChart = new XYChart.Series<>();
        importanceChart.setName("Importance Score"); // Can adjust the weight of comments or views in Post class

        // Loop grabs all the post that exist on the graph and adds them to the chart using get methods
        for (Post post : socialMedia.getPosts()) {
            commentChart.getData().add(new XYChart.Data<>(post.getContent(), post.getNumberOfComments()));
            viewChart.getData().add(new XYChart.Data<>(post.getContent(), post.getNumberOfViews()));
            importanceChart.getData().add(new XYChart.Data<>(post.getContent(), post.getImportanceValue()));
        }

        barChart.getData().addAll(commentChart, viewChart, importanceChart);

        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Social Media Analysis");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
