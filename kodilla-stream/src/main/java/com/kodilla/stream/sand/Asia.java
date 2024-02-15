package com.kodilla.stream.sand;

import com.kodilla.stream.invoice.simple.SandStorage;

import java.math.BigDecimal;

public class Asia implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("98765432101234567890");
        return sandQuantity;
    }
}
