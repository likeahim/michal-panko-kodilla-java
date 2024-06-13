package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraMushroomsDecorator extends AbstractPizzaOrderDecorator {
    public ExtraMushroomsDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", mushrooms";
    }
}
