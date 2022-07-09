package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {
    private String customerName;
    private List<Rental> rentals;
    private double totalAmount;
    private int frequentRenterPoints;

    public HtmlStatement(String customerName, List<Rental> rentals, double totalAmount, int frequentRenterPoints) {
        this.customerName = customerName;
        this.rentals = rentals;
        this.frequentRenterPoints = frequentRenterPoints;
        this.totalAmount = totalAmount;
    }

    public String generate() {
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
        return "<p>Total amount "+ totalAmount +" You earned <b> " + frequentRenterPoints + "</b> frequent renter points</p>";
    }

    private String htmlHeader() {
        return "<h3>Rental Record for " + customerName+ "</h3>";
    }
}
