module com.example.fx_simplenavminusdatabinding {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fx_simplenavminusdatabinding to javafx.fxml;
    exports com.example.fx_simplenavminusdatabinding;
}