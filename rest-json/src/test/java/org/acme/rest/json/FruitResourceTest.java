package org.acme.rest.json;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FruitResourceTest {

    @Test
    @Disabled
    public void testHelloEndpoint() {
        given()
          .when().get("/fruits")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}