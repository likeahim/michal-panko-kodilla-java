package com.kodilla.spring.reader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

@ContextConfiguration
public class ReaderTestSuite {

    @Test
    void testReader() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);

        //When & then
        reader.read();
    }

    @Test
    void testConditional() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        //When
        boolean book2Exists = context.containsBean("book2");
        //Then
        System.out.println("Bean book2 was found in the container: " + book2Exists);
        System.out.println("Today is: " + LocalDate.now().getDayOfMonth());
    }
}
