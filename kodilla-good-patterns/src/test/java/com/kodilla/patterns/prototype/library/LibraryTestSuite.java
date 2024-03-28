package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Hemingway's Library");
        Library shallowCopiedlibrary = null;
        Library deepCopiedLibrary = null;
        Book book1 = new Book("The old man and the sea", "Ernest Hemingway", LocalDate.of(1952, 1, 1));
        Book book2 = new Book("The wild years", "Ernest Hemingway", LocalDate.of(1962, 1, 1));
        Book book3 = new Book("The sun also rises", "Ernest Hemingway", LocalDate.of(1926, 1, 1));
        Book book4 = new Book("A farewell to arms", "Ernest Hemingway", LocalDate.of(1929, 1, 1));
        Book book5 = new Book("For whom the bell tolls", "Ernest Hemingway", LocalDate.of(1940, 1, 1));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);
        try {
            shallowCopiedlibrary = library.shallowCopy();
            deepCopiedLibrary = library.deepCopy();
            shallowCopiedlibrary.setName("shallow copied Hemingway's Library");
            deepCopiedLibrary.setName("deep copied Hemingway's Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        library.getBooks().remove(book3);

        //Then
        System.out.println(library.getBooks());
        System.out.println(deepCopiedLibrary.getBooks());
        assertEquals(4, library.getBooks().size());
        assertEquals(shallowCopiedlibrary.getBooks().size(), library.getBooks().size());
        assertFalse(deepCopiedLibrary.getBooks().isEmpty());
        assertEquals(5, deepCopiedLibrary.getBooks().size());
    }
}
