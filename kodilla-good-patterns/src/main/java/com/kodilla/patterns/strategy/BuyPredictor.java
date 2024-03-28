package com.kodilla.patterns.strategy;

public sealed interface BuyPredictor
        permits AggresivePredictor, BalancedPredictor, ConservativePredictor {
    String predictWhatToBuy();
}
