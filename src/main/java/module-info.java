module com.example.pizzasystemv001 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pizzasystemv001 to javafx.fxml;
    exports com.example.pizzasystemv001;
}