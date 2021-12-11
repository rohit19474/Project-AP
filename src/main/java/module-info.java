module com.example.willherofxfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.willherofxfinal to javafx.fxml;
    exports com.example.willherofxfinal;
}