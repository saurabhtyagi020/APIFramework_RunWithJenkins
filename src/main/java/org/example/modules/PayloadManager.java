package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {

    static Gson gson;
    public static String createBookingPayload()
    {
        Booking booking = new Booking();
        booking.setFirstname("Raghav");
        booking.setLastname("Singh");
        booking.setTotalprice(900);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("All");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-01-01");
        bookingdates.setCheckout("2024-09-01");
        booking.setBookingdates(bookingdates);

        gson = new Gson();
        String jsonString = gson.toJson(booking);
        return jsonString;

    }

    public static BookingResponse bookingResponse(String response)
    {
        gson = new Gson();
        BookingResponse jsonStringResponse=gson.fromJson(response, BookingResponse.class);
        return jsonStringResponse;
    }

    public static String fullUpdatePUT()
    {
        Booking booking = new Booking();
        booking.setFirstname("Sharma");
        booking.setLastname("Singh");
        booking.setTotalprice(1000);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("All");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-01-01");
        bookingdates.setCheckout("2024-09-01");
        booking.setBookingdates(bookingdates);

        gson = new Gson();
        String jsonFullString = gson.toJson(booking);
        return jsonFullString;
    }


    public static Booking getbooking(String response)
    {
         gson = new Gson();
        Booking jsonbooking = gson.fromJson(response, Booking.class);
        return jsonbooking;
    }

    public static String createToken()
    {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson = new Gson();
        String jsontoken =gson.toJson(auth);
        return jsontoken;
    }

    public static String tokenResponse(String response)
    {
        gson = new Gson();
        AuthResponse tokenresponse = gson.fromJson(response, AuthResponse.class);
        return tokenresponse.getToken();
    }

}
