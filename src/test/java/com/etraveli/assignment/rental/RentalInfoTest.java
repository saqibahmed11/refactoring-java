package test.java.com.etraveli.assignment.rental;

import main.java.com.etraveli.assignment.customer.Customer;
import main.java.com.etraveli.assignment.customer.MovieRental;
import main.java.com.etraveli.assignment.rental.RentalInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RentalInfoTest {

    @Test
    void testStatement() {
        MovieRental rental1 = new MovieRental("F001", 3);
        MovieRental rental2 = new MovieRental("F002", 2);
        Customer customer = new Customer("C. U. Stomer", List.of(rental1, rental2));

        RentalInfo rentalInfo = new RentalInfo();
        String statement = rentalInfo.statement(customer);

        String expectedStatement = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";
        assertEquals(expectedStatement, statement);
    }
}
