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
    private List<String> selectdToppings;
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
        int crust = 0;
        Pizza pizza = new Pizza();
        selectdToppings = new ArrayList<>();
        for (CheckBox topping : toppings) {
            if (topping.isSelected()) {
                selectdToppings.add(topping.getText());
            }
        }
        if(rbThinCrust.isSelected()){
            crust = 0;
        }
        if (rbStuffCrust.isSelected()){
            crust = 1;
        }
        else if (rbRegularCrust.isSelected()){
            crust = 2;
        }
        pizza.setQuantity(Integer.parseInt(tfQuantity.getText()));
        if (rbVegan.isSelected()) {
            handlePizzaOrder(pizza, 0, 3.59, selectdToppings, crust);
        }
        if (rbMeatLovers.isSelected()) {
            handlePizzaOrder(pizza, 1, 7.59, selectdToppings, crust);
        }
        if (rbHawaiian.isSelected()) {
            handlePizzaOrder(pizza, 2, 5.59, selectdToppings, crust);
        }
    }
    private void handlePizzaOrder(Pizza pizza, int type, double price, List<String> toppings, int crust) {
        pizza.setType(type);
        pizza.setSize(this.cbSizes.getSelectionModel().getSelectedIndex());
        pizza.setPrice(price);
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
