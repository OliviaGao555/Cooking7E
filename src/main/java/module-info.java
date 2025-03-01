module com.example.cooking7e {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.cooking7e to javafx.fxml;
    exports com.example.cooking7e;
}