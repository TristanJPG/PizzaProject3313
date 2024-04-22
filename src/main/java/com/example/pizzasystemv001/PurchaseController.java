package com.example.pizzasystemv001;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Arrays;

public class PurchaseController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    @FXML
    private TextArea taPurchaseSummary;
    @FXML
    private Label lblTotalPrice;

    @FXML
    public void initialize() {
        Purchase.addOrder(Order.getOrders());
        double price = 0.00;
        for(int i = 1; i<=Order.getOrders().size(); i++){
            if(Purchase.getOrder(i).getPizza() == null && Purchase.getOrder(i).getDrink() != null){
                taPurchaseSummary.appendText("- Order Number: " + Purchase.getOrder(i).getOrderId() +  " Drink: " + Purchase.getOrder(i).getDrink().getBrand() + " Size: " + Purchase.getOrder(i).getDrink().getSize() + " Quantity: " + Purchase.getOrder(i).getDrink().getQuantity() + " Price: " + Purchase.getOrder(i).getDrink().getPrice() + "\n\n");
                price+= Purchase.getOrder(i).getDrink().getPrice() * Purchase.getOrder(i).getDrink().getQuantity();
            } else if(Purchase.getOrder(i).getDrink() == null && Purchase.getOrder(i).getPizza() != null){
                taPurchaseSummary.appendText("- Order Number: " + Purchase.getOrder(i).getOrderId()  + " Pizza: " + Purchase.getOrder(i).getPizza().getType() + " With " + Purchase.getOrder(i).getPizza().getToppings()+" Size: " + Purchase.getOrder(i).getPizza().getSize() + " Quantity: " + Purchase.getOrder(i).getPizza().getQuantity() + " Price: " + Purchase.getOrder(i).getPizza().getPrice() + "\n\n");
                price+= Purchase.getOrder(i).getPizza().getPrice() * Purchase.getOrder(i).getPizza().getQuantity();
            } else {
                taPurchaseSummary.appendText("Please Create an Order First!");
            }
        }
        lblTotalPrice.setText("Total Price: $" + price);
    }

}
