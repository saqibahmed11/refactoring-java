package main.java.com.etraveli.assignment;

import java.util.Arrays;
import main.java.com.etraveli.assignment.customer.Customer;
import main.java.com.etraveli.assignment.customer.MovieRental;
import main.java.com.etraveli.assignment.rental.RentalInfo;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    RentalInfo rentalInfo = new RentalInfo();
    String result = rentalInfo.statement(new Customer("C. U. Stomer", Arrays.asList(
            new MovieRental("F001", 3),
            new MovieRental("F002", 1)
    )));

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + expected + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success");
  }
}
