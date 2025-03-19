package com.reportapp.rav1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RAVController {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    //------------------TOP------------------------------------
    @FXML
    private Label datumLabel, schneidtagLabel;
    @FXML
    private ComboBox <String> schichtCBox, linieCBox;
    @FXML
    private Label ppDatumLabel, ppSchneidtagLabel, ppSchichtLabel, ppLinieLabel;

    //----------------PERSONAL----------------------------------


    public void initialize() {
        initializeDatum();
        fillPrintPreview();
    }



    private void initializeDatum () {
        String date = LocalDate.now().format(dtf);
        String dayOfYear = String.valueOf(LocalDate.now().getDayOfYear());
        datumLabel.setText(date);
        schneidtagLabel.setText(dayOfYear);
    }

    private void fillPrintPreview () {
        Platform.runLater(() ->  {
            ppDatumLabel.textProperty().bind(datumLabel.textProperty());
            ppSchneidtagLabel.textProperty().bind(schneidtagLabel.textProperty());
            ppSchichtLabel.textProperty().bind(schichtCBox.valueProperty());
            ppLinieLabel.textProperty().bind(linieCBox.valueProperty());
        });

    }

}