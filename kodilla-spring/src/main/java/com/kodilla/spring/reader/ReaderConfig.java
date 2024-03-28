package com.kodilla.spring.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class ReaderConfig {

    @Autowired
    @Qualifier("book1")
    Book book;

    @Bean
    public Reader getReader() {
        return new Reader(book);
    }


}
