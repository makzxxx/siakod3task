module com.example.siakod3task {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.siakod3task to javafx.fxml;
    exports com.example.siakod3task;
}