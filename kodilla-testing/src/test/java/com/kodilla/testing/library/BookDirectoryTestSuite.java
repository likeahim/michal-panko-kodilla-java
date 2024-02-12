package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOf0Books = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOf15Books = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOf40Books = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0, theListOf0Books.size());
        assertEquals(15, theListOf15Books.size());
        assertEquals(0, theListOf40Books.size());
    }

    @Test
    void testListBooksWithConditionFragmentShortThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        //Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testList0BooksInHandsOf() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Travolta", "77010103773");

        //When
        List<Book> booksOfUser = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(0, booksOfUser.size());
    }

    @Test
    void testList1BookInHandsOf() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Travolta", "77010103773");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        bookLibrary.rentABook(book1, user);

        //When
        List<Book> booksOfUser = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(1, booksOfUser.size());

    }

    @Test
    void testList5BooksInHandsOf() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Travolta", "77010103773");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        Book book5 = new Book("Java and me", "Steve Narrow", 2013);
        bookLibrary.rentABook(book1, user);
        bookLibrary.rentABook(book2, user);
        bookLibrary.rentABook(book3, user);
        bookLibrary.rentABook(book4, user);
        bookLibrary.rentABook(book5, user);

        //When
        List<Book> booksOfUser = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(5, booksOfUser.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
