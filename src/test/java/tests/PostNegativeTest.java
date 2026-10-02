package tests;

import framework.client.PostClient;
import org.testng.annotations.Test;

public class PostNegativeTest {
    private final PostClient client = new PostClient();

    @Test(groups = "negative")
    public void unknownPostReturnsNotFound() {
        client.getPost(999999).then().statusCode(404);
    }
}
