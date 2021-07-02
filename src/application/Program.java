package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("inform the number of room:");
		Integer room = sc.nextInt();
		System.out.print("inform the date of checkin (dd/MM/yyyy):");
		Date checkin = sdf.parse(sc.next());
		System.out.println("inform the date of checkout (dd/MM/yyyy):");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Date of checkout after of checkin! Invalid");
		}else {
		Reservation rese = new Reservation(room, checkin, checkout);
		System.out.println("Reservation: " + rese);
		System.out.println();
		System.out.println("Enter date to update the reservation (checkin):");
		checkin = sdf.parse(sc.next());
		System.out.println("Enter date to update the reservation (checkout):");
		checkout = sdf.parse(sc.next());
		
		rese.updateDates(checkin, checkout);
		System.out.println();
		System.out.println("Update: " + rese.toString());
		
		}
		sc.close();

	}

}
