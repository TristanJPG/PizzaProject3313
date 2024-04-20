package com.example.pizzasystemv001;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Drinks {
    private int quantity;
    private double price;
    private String brand;
    private int size;


    /*Basic class instantiators / creators*/
    public Drinks() {
    }

    public Drinks(int quantity, String brand, int size) {
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        this.size = size;
    }

    /*------------------ Getters and Setters ----------------------------------------------- */
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /*public void setPrice(price){this.price = price;} <----- Not sure if needed*/

    /*Get type of drink --- returns String*/
    public String getBrand() {
        if (Objects.equals(this.brand, "Coke")) {
            return "Coke";
        }
        if (Objects.equals(this.brand, "Sprite")) {
            return "Sprite";
        }
        if (Objects.equals(this.brand, "Water")) {
            return "Water";
        }
        if (Objects.equals(this.brand, "RC Cola")) {
            return "RC Cola";
        }
        if (Objects.equals(this.brand, "Fanta")) {
            return "Fanta";
        } else {
            return "Error: please choose a drink.";
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*Get Size of drink --- returns String*/
    public String getSize() {
        if (this.size == 0) {
            return "Small";
        }
        if (this.size == 1) {
            return "Medium";
        }
        if (this.size == 2) {
            return "Large";
        } else {
            return "Error: Please choose a size.";
        }
    }

    public void setSize(int size) {
        this.size = size;
    }
    public double getPrice() {
        Price price = new Price();
        return price.drinkPrice(this);
    }
}


/*------------------ Main Functions ---------------------------------------------------- */