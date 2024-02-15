package com.kodilla.stream.sand;

import com.kodilla.stream.invoice.simple.SandStorage;

import java.math.BigDecimal;

public class Africa implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("99999999901234567890");
        return sandQuantity;
    }
}
