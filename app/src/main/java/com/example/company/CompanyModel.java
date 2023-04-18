package com.example.company;

public class CompanyModel {
    private String companyName;
    private String address;

    private String image;

    public CompanyModel(){}
    public CompanyModel(String companyName, String address, String image) {
        this.companyName = companyName;
        this.address = address;
        this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Company{" +

                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                "image='" + image + '\'' +
                '}';
    }

    protected String writeToFile(){

        return String.format("%s,%s,%s", companyName, address, image );
    }
}

