package com.example.pizzasystemv001;

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
import java.util.ResourceBundle;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    @FXML
    private RadioButton rbVegan;
    @FXML
    private RadioButton rbHawaiian;
    @FXML
    private RadioButton rbMeatLovers;
    @FXML
    private ChoiceBox<String> cbSizes = new ChoiceBox<>();
    private final String[] itemSizes = {"Small", "Medium", "Large", "By the Slice"};
    private final ObservableList<String> sizeList = FXCollections.observableArrayList(itemSizes);
    @FXML
    private TextField tfQuantity;
    @FXML
    private Button btnOrder;
    @FXML
    private Button btnReset;
    @FXML
    private TextArea taSummary;
    @FXML
    private Label lblPricePizza;

    @FXML
    public void initialize(){

        cbSizes.setItems(sizeList);
    }


    @FXML
    public void handleRBSelction(ActionEvent event){

        if(rbVegan.isSelected()){
            lblPricePizza.setText("$3.59");
        }
        if(rbHawaiian.isSelected()){
            lblPricePizza.setText("$5.59");
        }
        if(rbMeatLovers.isSelected()){
            lblPricePizza.setText("$7.59");
        }
    }
    @FXML
    public void handleOrderBtn(ActionEvent event){
        Pizza pizza = new Pizza();
        int quantity = Integer.parseInt(tfQuantity.getText());
        if (rbVegan.isSelected()) {
            handlePizzaOrder(pizza, 0, 3.59, quantity);
        }
        if (rbMeatLovers.isSelected()) {
            handlePizzaOrder(pizza, 1, 7.59, quantity);
        }
        if (rbHawaiian.isSelected()) {
            handlePizzaOrder(pizza, 2, 5.59, quantity);
        }
    }
    private void handlePizzaOrder(Pizza pizza, int type, double price, int quantity) {
        pizza.setType(type);
        pizza.setSize(this.cbSizes.getSelectionModel().getSelectedIndex());
        pizza.setPrice(price);
        taSummary.appendText("(" + quantity +" "+  pizza.getSize() + " " + pizza.getType() + " Pizza $" + (pizza.getPrice() * quantity) + ")\n");
    }
// @FXML
//    public void handleOrderBtn(ActionEvent event){
//        Pizza pizza = new Pizza();
//     //double price = 0.0;
//     //String size = this.cbSizes.getSelectionModel().getSelectedItem();
//     int quantity = Integer.parseInt(tfQuantity.getText());
//        if (rbVegan.isSelected()) {
//            pizza.setType(0);
//            pizza.setSize(this.cbSizes.getSelectionModel().getSelectedIndex());
//            pizza.setPrice(3.59);
//            taSummary.appendText("(" + quantity +" "+  pizza.getSize() + " " + pizza.getType() + " Pizza $" + (pizza.getPrice() * quantity) + ")\n");
//        }
//     if (rbMeatLovers.isSelected()) {
//         pizza.setType(1);
//         pizza.setSize(this.cbSizes.getSelectionModel().getSelectedIndex());
//         pizza.setPrice(7.59);
//         taSummary.appendText("(" + quantity +" "+  pizza.getSize() + " " + pizza.getType() + " Pizza $" + (pizza.getPrice() * quantity) + ")\n");
//     }
//     if (rbHawaiian.isSelected()) {
//         pizza.setType(2);
//         pizza.setSize(this.cbSizes.getSelectionModel().getSelectedIndex());
//         pizza.setPrice(5.59);
//         taSummary.appendText("(" + quantity +" "+  pizza.getSize() + " " + pizza.getType() + " Pizza $" + (pizza.getPrice() * quantity) + ")\n");
//     }
//    }
    @FXML
    public void handleResetBtn(ActionEvent event){
        rbMeatLovers.setSelected(false);
        rbVegan.setSelected(false);
        rbHawaiian.setSelected(false);
        tfQuantity.setText(null);
        cbSizes.setValue(null);
        lblPricePizza.setText("Pizzas Price per:");
    }
    public void switchToIntro(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pizza-Intro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pizza-Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();}

}
