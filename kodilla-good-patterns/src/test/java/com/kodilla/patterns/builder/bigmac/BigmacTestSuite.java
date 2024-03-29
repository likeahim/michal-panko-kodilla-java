package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testNewBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("bun with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .ingredient("extra ketchup")
                .ingredient("mushrooms")
                .build();
        System.out.println(bigmac);
        //When
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        int size = bigmac.getIngredients().size();
        //Then
        assertEquals("bun with sesame", bun);
        assertEquals(2, burgers);
        assertEquals(5, size);
    }
}
