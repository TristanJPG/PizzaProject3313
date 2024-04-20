package com.example.pizzasystemv001;

import java.util.List;

public class Pizza {
    private int size;
    private int type;
    private double price;
    private int quantity;
    private List<String> toppings;
    private int crust;



    public Pizza() {
    }

    public Pizza(int size, int type, double price, int quantity, int crust, List<String> toppings) {
        this.size = size;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.toppings = toppings;
        this.crust = crust;
    }

    public String getToppings() {
        StringBuilder sb = new StringBuilder();
        for (String topping : toppings) {
            sb.append(topping).append(", ");
        }
        return sb.toString();
    }
    public List<String> getToppingsList() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
    public String getCrust() {
        if(this.crust == 0){
            return "Stuffed Crust";
        } else if (this.crust == 1) {
            return "Thin Crust";
        } else if (this.crust == 2) {
            return "Regular Crust";
        } else {
            return "Error Please Choose a Crust";
        }
    }

    public void setCrust(int crust) {
        this.crust = crust;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType()  {
        if(this.type == 0){
            return "Vegan";
        }
        if(this.type == 1){
            return "Meat Lovers";
        }if(this.type == 2){
            return "Hawaiian";
        }
        else {
            return "Error Please Choose a Type of Pizza";
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSize(){
        if(this.size == 0){
            return "Small";
        } else if (this.size == 1) {
            return "Medium";
        } else if (this.size == 2) {
            return "Large";
        } else if (this.size == 3) {
            return "Slice(s)";
        }
        else{
            return "Error Please Choice a Size";
        }
    }
    public void setSize(int size){
        this.size = size;
    }

    public double getPrice(){
       Price price = new Price();
         return price.calculatePizzaPrice(this);
    }

}
