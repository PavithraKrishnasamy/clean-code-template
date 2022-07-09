package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String header = "Rental Record for " + getName() + "\n";
        return header + body() + footer();
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlBody() {
        String result = "<p>";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() + "<b>" +
                    rental.amount() + "</b><br/>";
        }
        result += "</p>";
        return result;
    }

    private String htmlFooter() {
        return "<p>Total amount "+ totalAmount() +" You earned <b> " + frequentRenterPoints() + "</b> frequent renter points</p>";
    }

    private String htmlHeader() {
       return "<h3>Rental Record for " + getName() + "</h3>";
    }

    private String body() {
        String body = "";
        for (Rental rental : rentals) {
            //show figures for this rental
            body += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return body;
    }

    private String footer() {
        String footer = "Amount owed is " + totalAmount() + "\n";
        return footer + "You earned " + frequentRenterPoints()
                + " frequent renter points";
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    private double amount(Rental rental) {
        return rental.amount();
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }


}
