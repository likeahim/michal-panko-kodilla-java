package com.kodilla.patterns.strategy.social.user;

import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;

public final class ZGeneration extends User {

    public ZGeneration(String name, SocialPublisher socialPublisher) {
        super(name, socialPublisher);
    }
}
