package test.java.com.etraveli.assignment.customer;

import main.java.com.etraveli.assignment.customer.Customer;
import main.java.com.etraveli.assignment.customer.MovieRental;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CustomerTest {

    @Test
    void testGetName() {
        Customer customer = new Customer("Saqib Ahmed", null);
        assertEquals("Saqib Ahmed", customer.getName());
    }

    @Test
    void testGetRentals() {
        MovieRental rental1 = new MovieRental("F001", 3);
        MovieRental rental2 = new MovieRental("F002", 1);
        MovieRental rental3 = new MovieRental("F004", 1);
        Customer customer = new Customer("Lillian", List.of(rental1, rental2, rental3));
        assertEquals(3, customer.getRentals().size());
    }
}
