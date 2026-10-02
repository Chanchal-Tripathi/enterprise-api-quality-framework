package tests;

import framework.client.PostClient;
import framework.model.Post;
import org.testng.annotations.Test;

import static framework.spec.ApiSpec.success;
import static org.hamcrest.Matchers.*;

public class PostCrudTest {
    private final PostClient client = new PostClient();

    @Test(groups = "smoke")
    public void createPostReturnsCreatedRepresentation() {
        Post request = new Post(7, null, "Quality engineering", "Fast feedback reduces release risk");

        client.createPost(request)
                .then().spec(success()).statusCode(201)
                .body("userId", equalTo(7))
                .body("title", equalTo("Quality engineering"))
                .body("body", containsString("feedback"))
                .body("id", notNullValue());
    }

    @Test
    public void deletePostReturnsSuccess() {
        client.deletePost(1).then().statusCode(200);
    }
}
