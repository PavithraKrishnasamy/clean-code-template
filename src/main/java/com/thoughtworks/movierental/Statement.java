package com.thoughtworks.movierental;

import java.util.List;

public class Statement {
    private String customerName;
    private List<Rental> rentals;
    private double totalAmount;
    private int frequentRenterPoints;

    public Statement(String customerName, List<Rental> rentals, double totalAmount, int frequentRenterPoints) {
        this.customerName = customerName;
        this.rentals = rentals;
        this.frequentRenterPoints = frequentRenterPoints;
        this.totalAmount = totalAmount;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + customerName + "\n";
    }

    private String body() {
        String body = "";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return body;
    }

    private String footer() {
        String footer = "Amount owed is " + totalAmount + "\n";
        return footer + "You earned " + frequentRenterPoints
                + " frequent renter points";
    }
}
