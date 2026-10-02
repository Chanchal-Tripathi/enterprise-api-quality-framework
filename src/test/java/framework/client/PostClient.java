package framework.client;

import framework.model.Post;
import io.restassured.response.Response;

import static framework.spec.ApiSpec.request;
import static io.restassured.RestAssured.given;

public class PostClient {
    public Response getPost(int id) {
        return given().spec(request()).when().get("/posts/{id}", id);
    }

    public Response createPost(Post post) {
        return given().spec(request()).body(post).when().post("/posts");
    }

    public Response deletePost(int id) {
        return given().spec(request()).when().delete("/posts/{id}", id);
    }
}
