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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrinksController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    @FXML
    private RadioButton rbSmall;
    @FXML
    private RadioButton rbMedium;
    @FXML
    private RadioButton rbLarge;
    private ArrayList<RadioButton> drinkSizes = new ArrayList<>();
    @FXML
    private RadioButton rbRcCola;
    @FXML
    private RadioButton rbCola;
    @FXML
    private RadioButton rbSprite;
    @FXML
    private RadioButton rbFanta;
    @FXML
    private RadioButton rbWater;
    private ArrayList<RadioButton> drinkBrands = new ArrayList<>();
    @FXML
    private TextField tfDrinksQuantity;
    @FXML
    private TextArea taDrinksSummary;

    SharedData sharedData = SharedData.getInstance();
    @FXML
    public void initialize() {
        PizzaController pc = new PizzaController();
        this.taDrinksSummary.setText(sharedData.getSharedText());
        drinkSizes.addAll(Arrays.asList(rbSmall, rbMedium, rbLarge));
        drinkBrands.addAll(Arrays.asList(rbCola, rbSprite, rbFanta, rbWater, rbRcCola));
    }

    @FXML
    public void handleOrderBtn(ActionEvent event){
        Drinks drink = new Drinks();
        for (int i = 0; i < drinkSizes.size(); i++) {
            if (drinkSizes.get(i).isSelected()) {
                drink.setSize(i);
            }
        }
        for(RadioButton rb : drinkBrands){
            if(rb.isSelected()){
                drink.setBrand(rb.getText());
            }
        }
        drink.setQuantity(Integer.parseInt(tfDrinksQuantity.getText()));
        handleDrinkOrder(drink);
    }
    public void handleDrinkOrder(Drinks drinks){
        taDrinksSummary.appendText("(" + drinks.getQuantity() +" "+ drinks.getSize() + " " +  drinks.getBrand() + "(s) " + (drinks.getPrice() * drinks.getQuantity()) + ")\n");

        sharedData.setSharedText(taDrinksSummary.getText());
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pizza-Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }
}
