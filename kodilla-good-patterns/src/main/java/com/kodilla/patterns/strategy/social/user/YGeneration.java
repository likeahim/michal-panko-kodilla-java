package com.kodilla.patterns.strategy.social.user;

import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;

public final class YGeneration extends User {

    public YGeneration(String name, SocialPublisher socialPublisher) {
        super(name, socialPublisher);
    }
}
