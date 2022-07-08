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
}