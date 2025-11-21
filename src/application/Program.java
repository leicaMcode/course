package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-In date(dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date(dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation.toString());

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-In  (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.UpdateDates(checkIn, checkOut);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservetion: " + e.getMessage());
		}

		sc.close();
	}

}
