package main.java.com.etraveli.assignment.rental;

import java.util.Map;
import java.util.HashMap;
import main.java.com.etraveli.assignment.constants.MovieType;
import main.java.com.etraveli.assignment.constants.PriceList;
import main.java.com.etraveli.assignment.customer.Customer;
import main.java.com.etraveli.assignment.customer.MovieRental;
import main.java.com.etraveli.assignment.movie.Movie;

public class RentalInfo {

  public String statement(Customer customer) {
    Map<String, Movie> movies = createMovieDatabase();

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

    for (MovieRental r : customer.getRentals()) {
      Movie movie = movies.get(r.getMovieId());
      double thisAmount = calculateRentalAmount(movie.getType(), r.getDays());

      frequentEnterPoints++;
      if (movie.getType() == MovieType.NEW_RELEASE && r.getDays() > 1) {
        frequentEnterPoints++;
      }

      result.append("\t").append(movie.getTitle()).append("\t").append(thisAmount).append("\n");
      totalAmount += thisAmount;
    }

    result.append("Amount owed is ").append(totalAmount).append("\n");
    result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");

    return result.toString();
  }

  private Map<String, Movie> createMovieDatabase() {
    Map<String, Movie> movies = new HashMap<>();
    movies.put("F001", new Movie("You've Got Mail", MovieType.REGULAR));
    movies.put("F002", new Movie("Matrix", MovieType.REGULAR));
    movies.put("F003", new Movie("Cars", MovieType.CHILDREN));
    movies.put("F004", new Movie("Fast & Furious X", MovieType.NEW_RELEASE));
    return movies;
  }

  private double calculateRentalAmount(MovieType type, int days) {
    double amount = 0;

    switch (type) {
      case REGULAR:
        amount = PriceList.REGULAR_BASE_PRICE;
        if (days > 2) {
          amount += (days - 2) * PriceList.REGULAR_EXTRA_PRICE_PER_DAY;
        }
        break;
      case NEW_RELEASE:
        amount = days * PriceList.NEW_RELEASE_PRICE_PER_DAY;
        break;
      case CHILDREN:
        amount = PriceList.CHILDREN_BASE_PRICE;
        if (days > 3) {
          amount += (days - 3) * PriceList.CHILDREN_EXTRA_PRICE_PER_DAY;
        }
        break;
    }

    return amount;
  }
}
