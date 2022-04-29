package com.cydeo.day5;

import com.cydeo.utilities.DBUtils;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class SpartanAPIvsDB extends SpartanTestBase {


    @DisplayName("Compare one spartan information api vs db")
    @Test
    public void test1() {

        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200).extract().response();


        // json to map

        Map<String, Object> apiMap = response.as(Map.class);
        System.out.println(apiMap.toString());


        //we need to get information from database
        //which db we will connect ? oracle so we added dependency
        //we need connection String of spartan db








    }
    }






