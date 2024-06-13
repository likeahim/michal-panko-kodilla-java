package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    private PizzaOrder pizzaOrder;
    @BeforeEach
    public void setUp() {
        pizzaOrder = new BasicPizzaOrder();
    }
    @Test
    public void testBasicPizzaOrderGetPrice() {
        //Given
        //When
        BigDecimal price = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal(15), price);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("pizza dough, cheese, tomato sauce", description);
    }

    @Test
    public void testChilliSauceDecoratorGetPrice() {
        //Given
        pizzaOrder = new ChilliSauceDecorator(pizzaOrder);
        //When
        BigDecimal price = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal(17), price);
    }

    @Test
    public void testChilliSauceDecoratorGetDescription() {
        //Given
        pizzaOrder = new ChilliSauceDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("pizza dough, cheese, tomato sauce, chilli sauce", description);
    }

    @Test
    public void testFatDoughDecoratorGetPrice() {
        //Given
        pizzaOrder = new FatDoughDecorator(pizzaOrder);
        //When
        BigDecimal price = pizzaOrder.getPrice();
        //Then
        assertEquals(new BigDecimal(18), price);
    }

    @Test
    public void testFatDoughDecoratorGetDescription() {
        //Given
        pizzaOrder = new FatDoughDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("fat pizza dough, cheese, tomato sauce", description);
    }

    @Test
    public void testFatPizzaWithMushroomsSalamiBBQSauceDecoratorGetPrice() {
        //Given
        pizzaOrder = new ExtraMushroomsDecorator(pizzaOrder);
        pizzaOrder = new ExtraSalamiDecorator(pizzaOrder);
        pizzaOrder = new FatDoughDecorator(pizzaOrder);
        pizzaOrder = new BBQSauceDecorator(pizzaOrder);

        //When
        BigDecimal price = pizzaOrder.getPrice();

        //Then
        assertEquals(new BigDecimal(30), price);
    }

    @Test
    public void testFatPizzaWithMushroomsSalamiBBQSauceDecoratorGetDescription() {
        //Given
        pizzaOrder = new BBQSauceDecorator(pizzaOrder);
        pizzaOrder = new ExtraMushroomsDecorator(pizzaOrder);
        pizzaOrder = new FatDoughDecorator(pizzaOrder);
        pizzaOrder = new ExtraSalamiDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("fat pizza dough, cheese, tomato sauce, BBQ sauce, mushrooms, salami", description);
    }
}
