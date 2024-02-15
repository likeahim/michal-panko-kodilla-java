package com.kodilla.stream.world;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @BeforeAll
    static void beforeAll() {
        System.out.println("People amount test");
    }

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("85000000"));
        Country denmark = new Country("Denmark", new BigDecimal("19000000"));
        Country cameroon = new Country("Cameroon", new BigDecimal("65000000"));
        Country egypt = new Country("Egypt", new BigDecimal("93000000"));
        Country ivoryCoast = new Country("Ivory Coast", new BigDecimal("121000000"));
        Country china = new Country("China", new BigDecimal("1200000000"));
        Country japan = new Country("Japan", new BigDecimal("230000000"));
        Country southKorea = new Country("South Korea", new BigDecimal("19000000"));
        Continent europe = new Continent("Europa");
        Continent africa = new Continent("Africa");
        Continent asia = new Continent("Asia");
        europe.getCountries().add(poland);
        europe.getCountries().add(germany);
        europe.getCountries().add(denmark);
        africa.getCountries().add(cameroon);
        africa.getCountries().add(egypt);
        africa.getCountries().add(ivoryCoast);
        asia.getCountries().add(china);
        asia.getCountries().add(japan);
        asia.getCountries().add(southKorea);
        world.getContinentList().add(europe);
        world.getContinentList().add(africa);
        world.getContinentList().add(asia);

        //When
        BigDecimal worldPopulation = world.getContinentList().stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        //Then
        BigDecimal expectedPopulation = new BigDecimal("1870000000");
        assertEquals(expectedPopulation, worldPopulation);
    }
}
