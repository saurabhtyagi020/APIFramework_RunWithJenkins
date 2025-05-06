package org.example.tests.integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.base.CommanToAll;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class E2E_Scenario extends CommanToAll {



    @Owner("#SAURABH TYAGI")
    @Description("Verify that booking created successfully!")
    @Test(groups="QA",priority = 1)
    public void testVerifyCreateBooking(ITestContext iTestContext)
    {
        requestSpecification.baseUri(APIConstants.BASE_URL).basePath(APIConstants.CREATE_UPDATE_URL)
                .body(PayloadManager.createBookingPayload());

        response =requestSpecification.log().all().when().post();

        vr= response.then().log().all().statusCode(200);

        BookingResponse bookingResponse= PayloadManager.bookingResponse(response.asString());
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking());
        Integer bookingId = bookingResponse.getBookingid();

        iTestContext.setAttribute("bookingid",bookingId);

        System.out.println(bookingId);


    }

    @Owner("#SAURABH TYAGI")
    @Description("Get the booking with bookingId")
    @Test(groups="QA",priority = 2,enabled = true)
    public void testGETBooking(ITestContext iTestContext)
    {
        Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
       requestSpecification.baseUri(APIConstants.BASE_URL).basePath(APIConstants.CREATE_UPDATE_URL+"/"+bookingId);

       response = requestSpecification.log().all().get();

       vr= response.then().log().all().statusCode(200);

        Booking booking = PayloadManager.getbooking(response.asString());
        System.out.println(booking.getFirstname());
        System.out.println(booking.getDepositpaid());

        assertThat(booking.getBookingdates()).isNotNull();


    }

    @Owner("#SAURABH TYAGI")
    @Description("Update the created booking with Booking Id")
    @Test(groups="QA",priority = 3,enabled = true)
    public void testUpdateBooking(ITestContext iTestContext)
    {
        String token = getToken();
        Integer bookingId =(Integer)iTestContext.getAttribute("bookingid");
        requestSpecification.baseUri(APIConstants.BASE_URL).basePath(APIConstants.CREATE_UPDATE_URL+"/"+bookingId);
        requestSpecification.body(PayloadManager.fullUpdatePUT()).cookie("token",token);

        response = requestSpecification.log().all().put();

        vr = response.then().log().all().statusCode(200);

        Booking booking = PayloadManager.getbooking(response.asString());
        System.out.println(booking.getFirstname());
        assertThat(booking.getLastname()).isEqualTo("Singh");


    }

    @Owner("#SAURABH TYAGI")
    @Description("Delete the created booking with Booking Id")
    @Test(groups="QA",priority = 4,enabled = true)
    public void testDeleteBooking(ITestContext iTestContext)
    {
        Integer bookingId = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();

        requestSpecification.given();
        requestSpecification.baseUri(APIConstants.BASE_URL).basePath(APIConstants.CREATE_UPDATE_URL+"/"+bookingId);
        requestSpecification.cookie("token",token);

        response = requestSpecification.delete();

        vr = response.then().statusCode(201);


    }
}
