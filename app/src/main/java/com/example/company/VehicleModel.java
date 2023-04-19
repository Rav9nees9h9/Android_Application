package com.example.company;

public class VehicleModel {
    private String make;
    private String model;
    private String condition;
    private String engineCylinder;
    private String year;
    private String numberOfDoors;
    private String price;
    private String color;
    private String thumbnailImage;
    private String fullImage;
    private int soldDate;

    private boolean isSold;

    public VehicleModel(){}



    public VehicleModel(String make, String model, String condition, String engineCylinder, String year, String numberOfDoors, String price, String color, String thumbnailImage, String fullImage, int soldDate, boolean isSold) {
        this.make = make;
        this.model = model;
        this.condition = condition;
        this.engineCylinder = engineCylinder;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
        this.price = price;
        this.color = color;
        this.soldDate = soldDate;
        this.thumbnailImage = thumbnailImage;
        this.fullImage = fullImage;
        this.isSold = isSold;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEngineCylinder() {
        return engineCylinder;
    }

    public void setEngineCylinder(String engineCylinder) {
        this.engineCylinder = engineCylinder;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public int getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(int soldDate) {
        this.soldDate = soldDate;
    }
    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

}
