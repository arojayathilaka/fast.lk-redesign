package com.example.fastlk;

public class Ad {
    int image;
    String name;
    String description;
    String price;

    public Ad(int image, String name, String description, String price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
