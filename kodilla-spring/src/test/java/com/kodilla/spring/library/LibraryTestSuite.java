package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

@ContextConfiguration
class LibraryTestSuite {

    @Test
    void testLoadFromDb() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        //When
        library.loadFromDb();

        //Then
        //do nothing
    }

    @Test
    void testSaveToDb() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        //When
        library.saveToDb();

        //Then
        //do nothing
    }

    @Test
    void testContext() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        //When & Then
        System.out.println("==== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ==== Beans list ====");
    }
}
