package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends Exception {
    public static String ERR_SEARCH_COMPANY = "Company not found";
    public static String ERR_SEARCH_EMPLOYEE = "Employee not fount";

    public SearchingException(String message) {
        super(message);
    }
}
