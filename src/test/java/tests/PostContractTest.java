package tests;

import framework.client.PostClient;
import org.testng.annotations.Test;

import static framework.spec.ApiSpec.success;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class PostContractTest {
    private final PostClient client = new PostClient();

    @Test(groups = {"smoke", "contract"})
    public void postResponseMatchesContract() {
        client.getPost(1)
                .then().spec(success()).statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"))
                .body("id", equalTo(1))
                .body("title", not(blankOrNullString()));
    }
}
