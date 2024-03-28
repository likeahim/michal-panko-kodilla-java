package com.kodilla.patterns.strategy.social.user;

import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;

public final class Millenials extends User {

    public Millenials(String name, SocialPublisher socialPublisher) {
        super(name, socialPublisher);
    }
}
