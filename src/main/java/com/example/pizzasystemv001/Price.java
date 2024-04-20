package com.example.pizzasystemv001;

import java.util.Objects;

public class Price {
    public Price(){}
    public double calculatePizzaPrice(Pizza pizza){
        double price = 0;
        if(Objects.equals(pizza.getSize(), "Small")){
            price += 2.99;
        } else if (Objects.equals(pizza.getSize(), "Medium")) {
            price += 3.99;
        } else if (Objects.equals(pizza.getSize(), "Large")) {
            price += 4.99;
        } else if (Objects.equals(pizza.getSize(), "Slice(s)")) {
            price -= 2.50;

        }
        if(Objects.equals(pizza.getType(), "Vegan")){
            price += 5.59;

        } else if (Objects.equals(pizza.getType(), "Meat Lovers")) {
            price += 7.59;
        } else if (Objects.equals(pizza.getType(), "Hawaiian")) {
            price += 4.59;
        }
        if(Objects.equals(pizza.getCrust(), "Thin Crust")){
            price += 1.00;
        } else if (Objects.equals(pizza.getCrust(), "Stuffed Crust")) {
            price += 2.59;
        } else if (Objects.equals(pizza.getCrust(), "Regular Crust")) {
            price += 0.00;

        }
        for(String topping : pizza.getToppingsList()) {
            if (Objects.equals(topping, "Pepperoni")) {
                price += 0.75;
            }if (Objects.equals(topping, "Ham"))  {
                price += 0.75;
            }  if (Objects.equals(topping, "Sausage")) {
                price += 0.75;
            } if (Objects.equals(topping, "Bacon")) {
                price += 0.75;
            }  if (Objects.equals(topping, "Pineapple")) {
                price += 0.75;
            } if (Objects.equals(topping, "Mushroom")) {
                price += 0.75;
            }  if (Objects.equals(topping, "Green Pepper")) {
                price += 0.75;
            }  if (Objects.equals(topping, "Spinach")) {
                price += 0.75;
            }
        }
        return price;
    }
    public double drinkPrice(Drinks Drink){
        double price = 0;
        if(Objects.equals(Drink.getBrand(), "Coke")){
            price += 1.99;
        } else if (Objects.equals(Drink.getBrand(), "Sprite")) {
            price += 1.99;
        } else if (Objects.equals(Drink.getBrand(), "Water")) {
            price += 0.99;
        } else if (Objects.equals(Drink.getBrand(), "RC Cola")) {
            price += 1.49;
        } else if (Objects.equals(Drink.getBrand(), "Fanta")) {
            price += 1.99;
        }
        if(Objects.equals(Drink.getSize(), "Small")){
            price += 0.00;
        } else if (Objects.equals(Drink.getSize(), "Medium")) {
            price += 0.50;
        } else if (Objects.equals(Drink.getSize(), "Large")) {
            price += 1.00;
        }
        return price;
    }
}
