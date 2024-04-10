package com.example.pizzasystemv001;

public class Pizza {
    private int size;
    private int type;
    private double price;

    public Pizza() {
    }

    public Pizza(int size, int type, double price) {
        this.size = size;
        this.type = type;
        this.price = price;
    }

    public String getType() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

}
