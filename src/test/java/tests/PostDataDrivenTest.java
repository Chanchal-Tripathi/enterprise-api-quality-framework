package tests;

import framework.client.PostClient;
import framework.data.PostData;
import org.testng.annotations.Test;

import static framework.spec.ApiSpec.success;
import static org.hamcrest.Matchers.*;

public class PostDataDrivenTest {
    private final PostClient client = new PostClient();

    @Test(dataProvider = "validPostIds", dataProviderClass = PostData.class)
    public void knownPostsExposeRequiredBusinessFields(int id) {
        client.getPost(id)
                .then().spec(success()).statusCode(200)
                .body("id", equalTo(id))
                .body("userId", greaterThan(0))
                .body("title", not(blankOrNullString()))
                .body("body", not(blankOrNullString()));
    }
}
