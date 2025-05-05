package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.example.base.CommanToAll;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.BookingResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class testCreateBooking extends CommanToAll {


    @Owner("#SAURABH TYAGI")
    @Description("Verify the booking created successfully!")
    @Test(groups = "Sanity",priority = 1)
    public void testVerifyCreateBooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_URL)
                .body(PayloadManager.createBookingPayload());

        response = requestSpecification.log().all().when().post();

        vr= response.then().log().all().statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponse(response.asString());
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotEmpty().isEqualTo("Raghav");



    }



}
