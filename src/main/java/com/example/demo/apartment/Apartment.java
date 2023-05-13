package com.example.demo.apartment;


public class Apartment {

    private  String webAddress;
    private  String address;
    private  String price;
    private  String pricePerSquareMeter;
    private  String numOfRooms;
    private  String squareMeters;
    private  int id;

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public void setPricePerSquareMeter(String pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public String getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(String numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(String squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Apartment(int id, String webAddress, String address, String price, String pricePerSquareMeter, String numOfRooms, String squareMeters) {
        this.id = id;
        this.webAddress = webAddress;
        this.address = address;
        this.price = price;
        this.pricePerSquareMeter = pricePerSquareMeter;
        this.numOfRooms = numOfRooms;
        this.squareMeters = squareMeters;
    }



}