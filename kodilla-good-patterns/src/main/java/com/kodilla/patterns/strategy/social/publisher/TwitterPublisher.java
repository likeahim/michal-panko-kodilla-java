package com.kodilla.patterns.strategy.social.publisher;

public final class TwitterPublisher implements SocialPublisher {

    private final String name = "Twitter";
    @Override
    public void share() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
