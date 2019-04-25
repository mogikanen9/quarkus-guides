package org.acme.persistence;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class SantaClausResourceTest {

    @Test
    @Disabled
    public void testHelloEndpoint() {
        given()
          .when().get("/santa")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}