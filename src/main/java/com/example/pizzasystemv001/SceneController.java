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
    private CheckBox cbPepperoni;
    @FXML
    private CheckBox cbHam;
    @FXML
    private CheckBox cbBacon;
    @FXML
    private CheckBox cbSausage;
    @FXML
    private CheckBox cbGreenPepper;
    @FXML
    private CheckBox cbMushroom;
    @FXML
    private CheckBox cbSpinach;
    @FXML
    private CheckBox cbPineapple;
    private List<CheckBox> toppings;
    @FXML
    private RadioButton rbThinCrust;
    @FXML
    private RadioButton rbStuffCrust;
    @FXML
    private RadioButton rbRegularCrust;




    @FXML
    public void initialize() {
        cbSizes.setItems(sizeList);
        cbSizes.setValue("Small");
        cbSizes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // newValue is the newly selected item
            // You can use this value to update the lblPricePizza label
            handleChangePrice(null);
        });
    }

@FXML
public void handleToppings(ActionEvent event){
    toppings = new ArrayList<>(Arrays.asList(cbPepperoni, cbHam, cbBacon, cbSausage, cbGreenPepper, cbMushroom, cbSpinach, cbPineapple));
    // Create a ChangeListener
    ChangeListener<Boolean> changeListener = (observable, oldValue, newValue) -> {
        long count = toppings.stream().filter(CheckBox::isSelected).count();
        if (count >= 4) {
            toppings.stream().filter(topping -> !topping.isSelected()).forEach(topping -> topping.setDisable(true));
        } else {
            toppings.forEach(topping -> topping.setDisable(false));
        }

    };

    // Add the ChangeListener to each CheckBox
    toppings.forEach(topping -> topping.selectedProperty().addListener(changeListener));
    handleChangePrice(event);
}
//    @FXML
//    public void handleRBSelection(ActionEvent event){
//
//        if(rbVegan.isSelected()){
//            lblPricePizza.setText("$3.59");
//        }
//        if(rbHawaiian.isSelected()){
//            lblPricePizza.setText("$5.59");
//        }
//        if(rbMeatLovers.isSelected()){
//            lblPricePizza.setText("$7.59");
//        }
//    }
    @FXML
    public void handleOrderBtn(ActionEvent event){
        int crust = -1;
        Pizza pizza = new Pizza();
        List<String> selectedToppings = new ArrayList<>();
        for (CheckBox topping : toppings) {
            if (topping.isSelected()) {
                selectedToppings.add(topping.getText());
            }
        }
        if(rbStuffCrust.isSelected()){
            crust = 0;
        }
        if (rbThinCrust.isSelected()){
            crust = 1;
        }
        else if (rbRegularCrust.isSelected()){
            crust = 2;
        }
        pizza.setQuantity(Integer.parseInt(tfQuantity.getText()));
        if (rbVegan.isSelected()) {
            handlePizzaOrder(pizza, 0, selectedToppings, crust);
        }
        if (rbMeatLovers.isSelected()) {
            handlePizzaOrder(pizza, 1, selectedToppings, crust);
        }
        if (rbHawaiian.isSelected()) {
            handlePizzaOrder(pizza, 2, selectedToppings, crust);
        }
    }
    private void handlePizzaOrder(Pizza pizza, int type,List<String> toppings, int crust) {
        pizza.setType(type);
        pizza.setSize(this.cbSizes.getSelectionModel().getSelectedIndex());
        pizza.setToppings(toppings);
        pizza.setCrust(crust);
        taSummary.appendText("(" + pizza.getQuantity() +" "+  pizza.getSize() + " " + pizza.getType() +" "+ pizza.getCrust() + " Pizza with " + pizza.getToppings() + (pizza.getPrice() * pizza.getQuantity()) + ")\n");
    }
    @FXML
    public void handleResetBtn(ActionEvent event){
        rbMeatLovers.setSelected(false);
        rbVegan.setSelected(false);
        rbHawaiian.setSelected(false);
        tfQuantity.setText(null);
        cbSizes.setValue(null);
        for (CheckBox topping : toppings) {
            topping.setSelected(false);
        }
        rbRegularCrust.setSelected(false);
        rbStuffCrust.setSelected(false);
        rbThinCrust.setSelected(false);
        lblPricePizza.setText("Price: $0.00");
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
        stage.show();
    }
    @FXML
    public void handleChangePrice(ActionEvent event){
        double price = 0.0;
        if(cbSizes.getSelectionModel().getSelectedIndex() == 0){
            price += 2.99;
        }
        if(cbSizes.getSelectionModel().getSelectedIndex() == 1){
            price += 3.99;
        }
        if(cbSizes.getSelectionModel().getSelectedIndex() == 2){
            price += 4.99;
        }
        if(cbSizes.getSelectionModel().getSelectedIndex() == 3){
            price -= 2.50;
        }
        if(rbVegan.isSelected()){
            price += 5.59;
        }
        if(rbMeatLovers.isSelected()){
            price += 7.59;
        }
        if(rbHawaiian.isSelected()){
            price += 4.59;
        }
        if(rbThinCrust.isSelected()){
            price += 1.00;
        }
        if(rbStuffCrust.isSelected()){
            price += 2.59;
        }
        if(rbRegularCrust.isSelected()){
            price += 0.00;
        }
        if(cbPepperoni.isSelected()){
            price += 0.75;
        }
        if(cbHam.isSelected()){
            price += 0.75;
        }
        if(cbBacon.isSelected()){
            price += 0.75;
        }
        if(cbSausage.isSelected()){
            price += 0.75;
        }
        if(cbGreenPepper.isSelected()){
            price += 0.75;
        }
        if(cbMushroom.isSelected()){
            price += 0.75;
        }
        if(cbSpinach.isSelected()){
            price += 0.75;
        }
        if(cbPineapple.isSelected()){
            price += 0.75;
        }
        if(price < 0){
            lblPricePizza.setText("Price: $0.00");

        }
        else {
            lblPricePizza.setText("Price: $" + price);
        }
    }

}
