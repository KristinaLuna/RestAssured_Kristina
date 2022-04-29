package com.cydeo.day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetRequest {

    @Test
    public void test1() {

        Response response = given().
                accept(ContentType.JSON)
                .when()
                .get("/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        assertEquals(200, response.statusCode());

        assertEquals("application/json", response.contentType());


    }

    //Given Accept type application/xml
    //send get request to api/spartans/10 end point
    //status code must be 406
    //and response content type must be application/xm;;charset=UTF-8;

    @DisplayName("GET request with Accept XML individual Spartan")
    @Test
    public void test2(){
        Response response = given()
                .accept(ContentType.XML)
                .when().get("api/spartans/10");

        assertEquals(406, response.statusCode());
        assertEquals("application/xml;charset=UTF-8", response.contentType());

    }






}
