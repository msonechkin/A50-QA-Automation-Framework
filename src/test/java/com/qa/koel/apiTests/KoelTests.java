package com.qa.koel.apiTests;

import static io.restassured.RestAssured.given;

import com.qa.koel.models.InnerRule;
import com.qa.koel.models.Playlist;
import com.qa.koel.models.Rule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class KoelTests {
    RequestSpecification requestSpec;

    @Test
    public void getKoelMainPage(){
        Response response = given().
                            baseUri("https://qa.koel.app")
                            .when()
                            .get()
                            .then().extract().response();
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Incorrect status code returned");
    }
    @BeforeClass
    public void authSetup() {
        Response response = given()
                .params("email", "andrii.banak@testpro.io",
                        "password", "OknwxILOM2B3$")
                .baseUri("https://qa.koel.app")
                .post("https://qa.koel.app/api/me")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String accessToken = response.path("token");
        String Authorization = "Bearer " + accessToken;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Authorization", Authorization);
        requestSpec = builder.build();
    }
    @Test
    public void verifyPlaylistName() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("https://qa.koel.app/api/playlist").
                then().statusCode(200).extract().response();

        JsonPath json = response.jsonPath();
        Playlist[] playlists = response.as(Playlist[].class);
        Rule[] rules = json.getObject("rules[1]", Rule[].class);
        InnerRule innerRule = rules[0].getRules()[0];
        System.out.println("Model "+ innerRule.getModel());

        Assert.assertEquals(playlists[0].getName(), "qwerty098");
    }


}
