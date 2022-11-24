module com.example.clstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clstore to javafx.fxml;
    exports com.example.clstore;
    exports com.clocks;
    opens com.clocks to javafx.fxml;
}