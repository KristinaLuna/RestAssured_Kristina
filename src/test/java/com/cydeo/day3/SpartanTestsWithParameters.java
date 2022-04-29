package com.cydeo.day3;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTestsWithParameters extends SpartanTestBase {

//    given accept type os json and id parameter value is 5
//    when user sends Get rq tp /api/spartans/{id}
//    response status should be 200
//    response content type: application/json
//    and "Blythe" should be in response payload


    @DisplayName("Get request to /api/spartans/{id} with ID 5")
    @Test
    public void test1(){
     Response response = given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id", 5)
        .when()
                .get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Blythe"));
    }
   /*
        TASK
        Given accept type is Json
        And Id parameter value is 500
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */

        @DisplayName("GET request with ID 500")
        @Test
        public void test2() {

            Response response = given()
                    .accept(ContentType.JSON)
                    .and()
                    .pathParam("id", 500)
                    .when()
                    .get("/api/spartans/{id}");

            assertEquals(404, response.statusCode());
            assertEquals("application/json" , response.header("content-type"));
            assertTrue(response.body().asString().contains("Not Found"));

        }

  /*
        Given Accept type is Json
        And query parameter values are:
        gender|Female
        nameContains|e
        When user sends GET request to /api/spartans/search
        Then response status code should be 200
        And response content-type: application/json
        And "Female" should be in response payload
        And "Janette" should be in response payload
     */

    @DisplayName("GET request to /api/spartans/search with Query Params")
    @Test
    public void test3() {

        Response response = given()
                .accept(ContentType.JSON)
                .and().queryParam("gender" , "Female")
                .and().queryParam("nameContains" , "e")
                .when()
                .get("/api/spartans/search");


        assertEquals(200, response.statusCode());
        assertEquals("application/json" , response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));




    }


    @DisplayName("GET request to /api/spartans/search with Query Params (MAP)")
    @Test
    public void test4() {
        //create a map and store query params information
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("gender", "Female");
        queryMap.put("nameContains", "e");

        Response response = given()
                .accept(ContentType.JSON)
                .queryParams(queryMap)
                .when().get("/api/spartans/search");


        assertEquals(200, response.statusCode());
        assertEquals("application/json" , response.contentType());
        assertTrue(response.body().asString().contains("Female"));
        assertTrue(response.body().asString().contains("Janette"));





    }







}
