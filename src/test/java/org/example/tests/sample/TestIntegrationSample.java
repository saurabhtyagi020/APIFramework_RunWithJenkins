package org.example.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {


    @Owner("#SAURABH TYAGI")
    @Description("Verify that booking created successfully!")
    @Test(groups="QA",priority = 1)
    public void testVerifyCreateBooking()
    {
        Assert.assertTrue(true);
    }

    @Owner("#SAURABH TYAGI")
    @Description("Get the booking with bookingId")
    @Test(groups="QA",priority = 2)
    public void testGETBooking()
    {
        Assert.assertTrue(true);
    }

    @Owner("#SAURABH TYAGI")
    @Description("Update the created booking with Booking Id")
    @Test(groups="QA",priority = 3)
    public void testUpdateBooking()
    {
        Assert.assertTrue(true);
    }

    @Owner("#SAURABH TYAGI")
    @Description("Delete the created booking with Booking Id")
    @Test(groups="QA",priority = 3)
    public void testDeleteBooking()
    {
        Assert.assertTrue(true);
    }


}
