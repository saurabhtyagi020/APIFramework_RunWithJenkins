package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommanToAll;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.Booking;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testUpdateBooking extends CommanToAll {


    String bookingId="8012";
    String token="057661267652a7d";
    @Owner("#SAURABH TYAGI")
    @Description("Update the created booking with Booking Id")
    @Test(groups="QA",priority = 3)
    public void testUpdateBooking()
    {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_URL+"/"+bookingId);
        requestSpecification.body(PayloadManager.fullUpdatePUT()).cookie("token",token);

        response = requestSpecification.when().put();

        vr= response.then().statusCode(200);

        Booking bookingRes = PayloadManager.getbooking(response.asString());
        System.out.println(bookingRes.getFirstname());

    }
}
