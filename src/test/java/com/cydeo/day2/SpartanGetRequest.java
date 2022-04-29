package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class SpartanGetRequest {

    String url = "http://54.234.255.231:8000";

    @DisplayName("ONE")
    @Test
    public void test1() {

        Response response = RestAssured.
                given().
                accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("application/json", response.contentType());


    }

    @DisplayName("TWO")
    @Test
    public void test2() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans/3");

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals("application/json", response.getContentType());

        Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }

    @DisplayName("THREE")
    @Test
    public void test3() {
        Response response = RestAssured.when().get(url + "/api/hello");

        response.prettyPrint();

        Assertions.assertEquals(200, response.getStatusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8", response.getContentType());


        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));

        System.out.println("response.header(\"Connection\") = " + response.header("Connection"));

    }
}
