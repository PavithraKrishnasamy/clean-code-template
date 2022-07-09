package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void test() {
        Customer customer = new Customer("John");
        customer.addRental(new Rental(new Movie("Movie1", Movie.CHILDRENS), 1));
        customer.addRental(new Rental(new Movie("Movie1", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Movie1", Movie.REGULAR), 3));

        String expectedStatement = "Rental Record for John\n" +
                "\tMovie1\t1.5\n" +
                "\tMovie1\t6.0\n" +
                "\tMovie1\t3.5\n" +
                "Amount owed is 11.0\n" +
                "You earned 4 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void shouldGenerateHtmlStatement() {
        Customer customer = new Customer("John");
        customer.addRental(new Rental(new Movie("Movie1", Movie.CHILDRENS), 1));
        customer.addRental(new Rental(new Movie("Movie1", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Movie1", Movie.REGULAR), 3));

        String expectedStatement = "<h3>Rental Record for John</h3><p>Movie1<b>1.5</b><br/>Movie1<b>6.0</b><br/>Movie1<b>3.5</b><br/></p><p>Total amount 11.0 You earned <b> 4</b> frequent renter points</p>";
        assertEquals(expectedStatement, customer.htmlStatement());
    }
}