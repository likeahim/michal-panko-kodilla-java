package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import com.kodilla.patterns.strategy.social.user.Millenials;
import com.kodilla.patterns.strategy.social.user.User;
import com.kodilla.patterns.strategy.social.user.YGeneration;
import com.kodilla.patterns.strategy.social.user.ZGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    User john = new Millenials("John", new FacebookPublisher());
    User mendy = new YGeneration("Mendy", new SnapchatPublisher());
    User andy = new ZGeneration("Andy", new TwitterPublisher());

    @Test
    void testDefaultSharingStrategies() {
        //Given
        //When
        String johnsSocial = john.getSocialPublisher().getName();

        //Then
        assertEquals(johnsSocial, "Facebook");
        assertEquals(mendy.getSocialPublisher().getName(), "Snapchat");
        assertEquals(andy.getSocialPublisher().getName(), "Twitter");
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        //When
        john.setSocialPublisher(new SnapchatPublisher());
        String johnsSocial = john.getSocialPublisher().getName();

        //Then
        assertEquals(johnsSocial, "Snapchat");
    }
}
