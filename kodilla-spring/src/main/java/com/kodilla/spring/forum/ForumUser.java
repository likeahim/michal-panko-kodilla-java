package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    private final String USERNAME;

    public ForumUser() {
        USERNAME = "John Smith";
    }

    public String getUSERNAME() {
        return USERNAME;
    }
}
