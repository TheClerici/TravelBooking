package com.encora.travelbooking;

import com.encora.travelbooking.domain.BusTicket;
import com.encora.travelbooking.domain.PlaneTicket;
import com.encora.travelbooking.domain.TrainTicket;
import com.encora.travelbooking.domain.TravelClass;
import com.encora.travelbooking.exceptions.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RegisterTravelTicket {

    public static void main(String[] args) throws InvalidTravelDurationException {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        while (!(option >=1 && option <=3)) {
            System.out.println("Enter the number of your choice.\n 1.- Bus ticket\n 2.- Train ticket\n 3.- Plane ticket.");
            option = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Enter the booking reference:");
        Long ref = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the origin:");
        String origin = scanner.nextLine();

        System.out.println("Enter the destination:");
        String destination = scanner.nextLine();

        System.out.println("Enter the price:");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();

        System.out.println("Enter the departure time:");
        String dTime = scanner.nextLine();
        LocalDateTime departureTime = LocalDateTime.parse(dTime);

        System.out.println("Enter the arrival time:");
        String aTime = scanner.nextLine();
        LocalDateTime arrivalTime = LocalDateTime.parse(aTime);

        switch (option) {
            case 1: //Bus
                BusTicket busTicket = new BusTicket(ref, origin, destination, price, departureTime,
                        arrivalTime, null);
                System.out.println(busTicket);
                break;
            case 2: //Train
                System.out.println("Enter the travel class:");
                String tClass = scanner.nextLine();
                TravelClass travelClass = TravelClass.valueOf(tClass.toUpperCase());

                System.out.println("Enter the carriage number: ");
                int carriageNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the seat number");
                int seatNumber = scanner.nextInt();

                TrainTicket trainTicket = new TrainTicket(ref, origin, destination, price, departureTime,
                        arrivalTime, travelClass, carriageNumber, seatNumber);
                System.out.println(trainTicket);
                break;
            case 3: //Plane
                System.out.println("Enter the travel class:");
                String tClass2 = scanner.nextLine();
                TravelClass travelClass2 = TravelClass.valueOf(tClass2.toUpperCase());

                System.out.println("Enter the number of stopovers: ");
                int stopovers = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the seat number");
                int seatNumber2 = scanner.nextInt();

               PlaneTicket planeTicket = new PlaneTicket(ref, origin, destination, price, departureTime,
                        arrivalTime, travelClass2, stopovers, seatNumber2);
                System.out.println(planeTicket.toString());
                break;
        }
    }
}
