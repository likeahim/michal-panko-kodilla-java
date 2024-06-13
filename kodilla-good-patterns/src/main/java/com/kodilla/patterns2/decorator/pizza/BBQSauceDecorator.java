package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BBQSauceDecorator extends AbstractPizzaOrderDecorator {
    public BBQSauceDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", BBQ sauce";
    }
}
