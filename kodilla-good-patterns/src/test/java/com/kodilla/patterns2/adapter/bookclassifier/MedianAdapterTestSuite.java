package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Book book1 = new Book("Anna Nowak", "The Lost World", 1923, "123456");
        Book book2 = new Book("Paweł Homerski", "Illiadia", 1905, "334552");
        Book book3 = new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925, "555111");
        Book book4 = new Book("George Orwell", "1984", 1949, "777888");
        Book book5 = new Book("Emily Bronte", "Wuthering Heights", 1847, "222333");
        Book book6 = new Book("Mary Shelley", "Frankenstein", 1818, "111222");
        Book book7 = new Book("George R.R. Martin", "A Game of Thrones", 1996, "888999");
        Book book8 = new Book("John Smith", "The Great Adventure", 1987, "654321");
        Book book9 = new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 1997, "444000");
        Set<Book> setWithBooks = new HashSet<>(List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9));

        //When
        int medianYear = adapter.publicationYearMedian(setWithBooks);

        //Then
        assertEquals(9, setWithBooks.size());
        assertEquals(1925, medianYear);
    }

}