package com.kodilla.patterns.strategy.social.user;

import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;

public sealed class User permits Millenials, YGeneration, ZGeneration {

    private String name;
    private SocialPublisher socialPublisher;

    public User(String name, SocialPublisher socialPublisher) {
        this.name = name;
        this.socialPublisher = socialPublisher;
    }

    public void sharePost() {
        socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public SocialPublisher getSocialPublisher() {
        return socialPublisher;
    }
}
