package com.kodilla.good.patterns.challenges.order.contact;

public class Address {
    private String country;
    private String city;
    private String street;
    private String numberBuilding;
    private String numberHome;

    public Address(String country, String city, String street, String numberBuilding, String numberHome) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberBuilding = numberBuilding;
        this.numberHome = numberHome;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberBuilding() {
        return numberBuilding;
    }

    public void setNumberBuilding(String numberBuilding) {
        this.numberBuilding = numberBuilding;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }
}
