package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommanToAll;
import org.example.endpoints.APIConstants;
import org.testng.annotations.Test;

public class testDeleteBooking extends CommanToAll {


    String bookingId="1400";
    String token="e583465b8e0955a";

    @Owner("#SAURABH TYAGI")
    @Description("Delete the created booking with Booking Id")
    @Test(groups="QA",priority = 3,enabled = false)
    public void testDeleteBooking()
    {
       requestSpecification.basePath(APIConstants.CREATE_UPDATE_URL+"/"+bookingId);
       requestSpecification.cookie("token",token);

       response = requestSpecification.when().delete();

       vr= response.then().statusCode(201);
    }

}
