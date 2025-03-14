module com.reportapp.rav1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.reportapp.rav1 to javafx.fxml;
    exports com.reportapp.rav1;
}