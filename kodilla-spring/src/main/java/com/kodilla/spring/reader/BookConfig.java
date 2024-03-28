package com.kodilla.spring.reader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean(name = "book1")
    public Book getBookOne() {
        return new Book("The book number one");
    }

    @Bean(name = "book2")
    @Conditional(IfDayIsOddCondition.class)
    public Book getBookTwo() {
        return new Book("The book number two");
    }
}
