package com.kodilla.patterns.strategy.social.publisher;

public final class FacebookPublisher implements SocialPublisher {

    private final String name = "Facebook";
    @Override
    public void share() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
