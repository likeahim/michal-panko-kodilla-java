package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3)
            return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20)
            return bookList;
        else {
            bookList = resultList;
            return bookList;
        }
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        return libraryUser.getRentedBooks();
    }

    public void rentABook(Book book1, LibraryUser user) {
        if (book1 != null && !book1.isRented()) {
            user.setNumberBooksRented(1);
            book1.setRented(true);
            book1.setRenter(user);
            user.setRentedBooks(book1);
        }
    }
}
