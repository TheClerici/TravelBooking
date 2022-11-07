package com.encora.travelbooking;

import com.encora.travelbooking.bookingprocess.BookingSystem;
import com.encora.travelbooking.bookingprocess.CheapTravelBookingSystem;
import com.encora.travelbooking.bookingprocess.EnjoyableToursBookingSystem;
import com.encora.travelbooking.domain.*;
import com.encora.travelbooking.exceptions.InvalidTravelDurationException;
import com.encora.travelbooking.utilities.OriginSortComparator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidTravelDurationException {

        System.out.println("----- Prueba: -----");
        //Probando cancel
        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();

        TrainTicket trainTicket2 = null;
        try {
            trainTicket2 = new TrainTicket(123L, "London", "Edinburgh", new BigDecimal("59.00"),
                    LocalDateTime.of(2022,11,7,18,03),
                    LocalDateTime.of(2022,11,7,19,03),
                    TravelClass.FIRST, 3, 42);
            System.out.println("----- Prueba: -----");
            //Probando upgrade
            trainTicket2.upgrade();
        } catch (InvalidTravelDurationException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> providers = new ArrayList<>();
        providers.add("Tufesa");
        providers.add("Alamos");
        providers.add("Albatros");

        System.out.println(providers.size());
        System.out.println(providers);

        providers.remove("Alamos");
        System.out.println(providers);

        BusTicket busTicket = null;
        busTicket = new BusTicket(124L, "London", "Edinburgh", new BigDecimal("80.00"),
                    LocalDateTime.of(2022,11,7,16,03),
                    LocalDateTime.of(2022,11,7,19,03), providers);

        BusTicket busTicket2 = new BusTicket(125L, "New York", "Boston", new BigDecimal("60.00"),
                LocalDateTime.of(2022,11,7,16,03),
                LocalDateTime.of(2022,11,7,19,03), providers);

        BusTicket busTicket3 = new BusTicket(126L, "Paris", "London", new BigDecimal("40.00"),
                LocalDateTime.of(2022,11,7,16,03),
                LocalDateTime.of(2022,11,7,19,03), providers);

        List<TravelTicket> tickets = new ArrayList<>();

        tickets.add(busTicket);
        tickets.add(busTicket2);
        tickets.add(busTicket2);
        tickets.add(busTicket2);
        tickets.add(busTicket3);
        tickets.add(trainTicket2);


        System.out.println(tickets);

        //Collections.sort(tickets);

        //Collections.sort(tickets, new OriginSortComparator());

        //var add2numbers = (int a, int b) -> {return a+b;};

 //       var departureTimeSort = (TravelTicket a, TravelTicket b) -> {
 //           return a.getDepartureTime().compareTo(b.getDepartureTime());
  //      };

 //       Collections.sort(tickets, new Comparator<TravelTicket>() {
  //          @Override
  //          public int compare(TravelTicket o1, TravelTicket o2) {
  //              return o1.getDestination().compareTo(o2.getDestination());
   //         }
   //     });
        System.out.println("----- Prueba sort departure: -----");

        Collections.sort(tickets, (a, b) -> a.getDepartureTime().compareTo(b.getDepartureTime()) );

        for (TravelTicket b : tickets) {
            System.out.println(b);
        }

        System.out.println("----- Prueba for each en tickets: -----");

        tickets.stream().forEach(a -> System.out.println(a));

        System.out.println("----- Prueba con filto london: -----");

        tickets.stream().filter(a -> a.getOrigin().equals("London")).forEach(a -> System.out.println(a));

        List<TravelTicket> londonTickets = tickets.stream().filter(a -> a.getOrigin().equals("London")).toList();

        System.out.println("----- Prueba for each en london tickets: -----");

        londonTickets.stream().forEach(a -> System.out.println(a));

        System.out.println("----- Prueba map en tickets (añadir 20 peso): -----");

        tickets.stream().map(a -> {
            a.setPrice(a.getPrice().add(new BigDecimal("20")));
            return a;
        }).forEach(a -> System.out.println(a));

        //System.out.println("----- Prueba: -----");

        //TravelTicket foundTicket = tickets.get(2);
        //System.out.println(foundTicket);

        //if (foundTicket instanceof BusTicket) {
        //    System.out.println("This is a bus ticket");
        //    BusTicket foundBusTicket = (BusTicket) foundTicket;
        //    System.out.println(foundBusTicket.getPermittedProviders());
        //} else if (foundTicket instanceof TrainTicket) {
        //    System.out.println("This is a train ticket");
        //}
        //} else {
        //    System.out.println("This is a plane ticket");
        //}

        //System.out.println("----- Prueba: -----");
        //BusTicket busTicketX = new BusTicket(foundTicket, providers);

        //BookingSystem bookingSystem = new CheapTravelBookingSystem();

        //bookingSystem.setTravelTicket(busTicketX);
        //bookingSystem.requestBooking();
        //System.out.println("The booking status is " + bookingSystem.getStatus());
        //bookingSystem.cancel();
        //Java 17+ only
        //if (foundTicket instanceof BusTicket bt) {
        //    System.out.println(bt.getPermittedProviders());
        //}

        //List<Integer> integerList1 = new ArrayList<>();
        //integerList1.add(1);
        //integerList1.add(2);
        //integerList1.add(3);
        //integerList1.add(4);
        //integerList1.add(5);

        //List<Integer> integerList2 = List.of(1,2,3,4,5);
        //for (Integer i : integerList2) {
        //    System.out.println(i);
        //}

        //System.out.println(integerList2.getClass());

        //System.out.println(BookingSystem.getVersion());

        //BookingSystem bookingSystem2 = BookingSystem.of(trainTicket);
    }
}

