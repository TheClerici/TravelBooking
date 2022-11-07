package com.encora.travelbooking.bookingprocess;

import com.encora.travelbooking.domain.TravelTicket;

public class EnjoyableToursBookingSystem implements BookingSystem {
    @Override
    public void setTravelTicket(TravelTicket ticket) {
        System.out.println("Enjoyable Tours has received " + ticket);
    }

    @Override
    public void requestBooking() {
        System.out.println("Enjoyable Tours has received a booking request");
    }

    @Override
    public boolean getStatus() {
        System.out.println("Enjoyable Tours has received a booking status");
        return false;
    }

    @Override
    public boolean cancel() {
        System.out.println("Enjoyable Tours has received a cancelation");
        return false;
    }
}
