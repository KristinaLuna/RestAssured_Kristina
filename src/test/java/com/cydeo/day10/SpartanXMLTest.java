package com.cydeo.day10;


import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class SpartanXMLTest extends SpartanAuthTestBase {

    //we will ask for xml result
    //assert status code
    //assert content type xml
    //verify first name

    @Test
    public void test1(){

        given()
                .accept(ContentType.XML)
                .and()
                .auth().basic("admin", "admin")
        .when()
                .get("/api/spartans")
        .then()
                .statusCode(200)
                .and()
                .contentType("application/xml")
                .body("list.item[0].name", is("Meade"))
                .body("list.item[0].gender",is("Male"))
                .log().all()   ;


    }

    @DisplayName("GET all spartans with XML")
    @Test
    public void test2(){

        Response response = given()
                .accept(ContentType.XML)
                .and()
                .auth().basic("admin", "admin")
                .when()
                .get("api/spartans");

        XmlPath xmlPath = response.xmlPath();

        String name = xmlPath.getString("List.item[0].name");
        System.out.println("name = " + name);

        String name3 = xmlPath.getString("List.item[3].name");
        System.out.println("name = " + name3);

        int id = xmlPath.getInt("List.item[0].id");
        System.out.println("name = " + id);

        List<String> names = xmlPath.getList("list.item.name");
        System.out.println("names = " + names);




    }








}
