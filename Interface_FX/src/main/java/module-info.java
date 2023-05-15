module com.example.interface_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.interface_fx to javafx.fxml;
    exports com.example.interface_fx;
}