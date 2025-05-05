package org.example.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommanToAll {


   public RequestSpecification requestSpecification;
   public Response response;
   public  ValidatableResponse vr;
   public PayloadManager payloadManager;


    @BeforeMethod
    public void setUp()
    {
        payloadManager = new PayloadManager();

        System.out.println("Running setup method...");

       requestSpecification = RestAssured.given();
       requestSpecification.baseUri(APIConstants.BASE_URL);
       requestSpecification.contentType(ContentType.JSON).log().all();

    }
}
