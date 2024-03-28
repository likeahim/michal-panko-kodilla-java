package com.kodilla.patterns.strategy.social.publisher;

public final class SnapchatPublisher implements SocialPublisher {

    private final String name = "Snapchat";
    @Override
    public void share() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
