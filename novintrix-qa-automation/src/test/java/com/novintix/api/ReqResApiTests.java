package com.novintix.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqResApiTests {

    private final String BASE_URL = "https://reqres.in/api";

    
    @Test
    public void testGetUsers() {
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get(BASE_URL + "/users");

        response.prettyPrint(); 
        Assert.assertEquals(response.statusCode(), 200); 
    }

   
    @Test
    public void testCreateUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Shobika\",\"job\":\"QA\"}")
                .when()
                .post(BASE_URL + "/users");

        response.prettyPrint(); 
        Assert.assertNotNull(response.getBody()); 
    }

    
    @Test
    public void testUpdateUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Shobika\",\"job\":\"Senior QA\"}")
                .when()
                .put(BASE_URL + "/users/2");

        response.prettyPrint(); 
        Assert.assertNotNull(response.getBody());
    }

    
    @Test
    public void testDeleteUser() {
        Response response = given()
                .when()
                .delete(BASE_URL + "/users/2");

        System.out.println("Status code: " + response.statusCode());
        

}
}
