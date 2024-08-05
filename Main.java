import java.util.Calendar;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        User alicejohnson = new User("alicejohnson01", "Alice Johnson", 25, "Female", "New York");
        User bobsmith = new User("bobsmith02", "Bob Smith", 30, "Male", "Los Angeles");
        User caroldavis = new User("caroldavis03", "Carol Davis", 22, "Female", "Chicago");
        User davidwilson = new User("davidwilson04", "David Wilson", 28, "Male", "Houston");
        Graph Facebook = new Graph();
        Facebook.addUser(alicejohnson);
        Facebook.addUser(bobsmith);
        Facebook.addUser(caroldavis);
        Facebook.addUser(davidwilson);
        // Alice follows Bob
        Connection aliceFollowsBob = new Connection(alicejohnson, bobsmith, "follows");
        alicejohnson.addConnection(aliceFollowsBob);

        // Carol is friends with David
        Connection carolFriendsDavid = new Connection(caroldavis, davidwilson, "friends");
        caroldavis.addConnection(carolFriendsDavid);
        davidwilson.addConnection(carolFriendsDavid);

        // Bob and Alice are co-workers
        Connection bobCoworkerAlice = new Connection(bobsmith, alicejohnson, "co-worker");
        bobsmith.addConnection(bobCoworkerAlice);
        alicejohnson.addConnection(bobCoworkerAlice);

        // David has blocked Carol
        Connection davidBlockedCarol = new Connection(davidwilson, caroldavis, "blocked");
        davidwilson.addConnection(davidBlockedCarol);

        // Create a post by Alice
        Post postByAlice = new Post("Hello, world!", 0, 0, new Date(2024, Calendar.JULY,16));
        alicejohnson.getPostsAuthored().add(postByAlice);

        // Bob views and comments on Alice's post
        postByAlice.addViewer(bobsmith);
        bobsmith.getPostsViewed().add(postByAlice);

        Comment bobComment = new Comment("Nice post!", bobsmith, new Date(2024, Calendar.JULY,18));
        postByAlice.addComment(bobComment);
        bobsmith.getComments().add(bobComment);

        // Carol views Alice's post but doesn't comment
        postByAlice.addViewer(caroldavis);
        caroldavis.getPostsViewed().add(postByAlice);

        // David creates a post
        Post postByDavid = new Post("I'm happy to share that I just got a new job at XYZ corporation!", 0, 0, new Date(2024, Calendar.MARCH, 1));
        davidwilson.getPostsAuthored().add(postByDavid);

        // Alice views and comments on David's post
        postByDavid.addViewer(alicejohnson);
        alicejohnson.getPostsViewed().add(postByDavid);

        Comment aliceComment = new Comment("Congratulations David!", alicejohnson, new Date(2024, Calendar.MARCH,3));
        postByDavid.addComment(aliceComment);
        alicejohnson.getComments().add(aliceComment);


    }
}
