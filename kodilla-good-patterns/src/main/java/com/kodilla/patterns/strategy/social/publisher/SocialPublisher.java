package com.kodilla.patterns.strategy.social.publisher;

public sealed interface SocialPublisher permits SnapchatPublisher, FacebookPublisher, TwitterPublisher {

    void share();
    String getName();
}
