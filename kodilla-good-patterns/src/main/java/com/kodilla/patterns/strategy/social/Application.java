package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import com.kodilla.patterns.strategy.social.user.Millenials;
import com.kodilla.patterns.strategy.social.user.User;
import com.kodilla.patterns.strategy.social.user.YGeneration;
import com.kodilla.patterns.strategy.social.user.ZGeneration;

public class Application {
    public static void main(String[] args) {
        User user1 = new Millenials("John", new SnapchatPublisher());
        User user2 = new ZGeneration("Wendy", new FacebookPublisher());
        User user3 = new YGeneration("Merry", new TwitterPublisher());

        user1.sharePost();
        user2.sharePost();
        user3.sharePost();
        System.out.println("changing favourite social media....");
        user1.setSocialPublisher(new FacebookPublisher());
        user1.sharePost();
    }
}
