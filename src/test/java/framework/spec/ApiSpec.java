package framework.spec;

import framework.config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.lessThan;

public final class ApiSpec {
    private ApiSpec() {}

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.baseUrl())
                .setContentType(JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    public static ResponseSpecification success() {
        return new ResponseSpecBuilder()
                .expectContentType(JSON)
                .expectResponseTime(lessThan(5000L))
                .build();
    }
}
