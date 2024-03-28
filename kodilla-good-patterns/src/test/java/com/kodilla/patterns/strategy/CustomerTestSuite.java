package com.kodilla.patterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategy() {
        //Given
        Customer steven = new CorporateCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new IndividualCustomer("Kodilla");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        //Then
        assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of XYZ", johnShouldBuy);
        assertEquals("[Conservative predictor] Buy debentures of XYZ", kodillaShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy() {
        //Given
        Customer steven = new IndividualCustomer("Steven Links");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyPredictor(new AggresivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven should now: " + stevenShouldBuy);

        //Then
        assertEquals("[Aggressive predictor] Buy stock of XYZ", stevenShouldBuy);

    }
}
