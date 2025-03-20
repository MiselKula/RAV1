package com.reportapp.rav1;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    @FXML
    private Label ppLinienfuhrerLabel, ppSchalerLabel, ppEinlegerLabel, ppAbschlichterLabel1, ppAbschlichterLabel2;
    @FXML
    private TextField linienfuhrerField, schalerField, einlegerField, absch1Field, absch2Field;

    //--------------PRODUKTIONSDOKUMENTATION----------------------------------




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

    private void bindItems (Label label, ObservableValue<?> item) {
        label.textProperty().bind(Bindings.createStringBinding(
                () -> item.getValue() != null ? item.getValue().toString() : "",
                item
        ));
    }



    private void fillPrintPreview () {
        Platform.runLater(() ->  {
            bindItems(ppDatumLabel, datumLabel.textProperty());
            bindItems(ppSchneidtagLabel, schneidtagLabel.textProperty());
            bindItems(ppSchichtLabel, schichtCBox.valueProperty());
            bindItems(ppLinieLabel, linieCBox.valueProperty());
            bindItems(ppLinienfuhrerLabel, linienfuhrerField.textProperty());
            bindItems(ppSchalerLabel, schalerField.textProperty());
            bindItems(ppEinlegerLabel, einlegerField.textProperty());
            bindItems(ppAbschlichterLabel1, absch1Field.textProperty());
            bindItems(ppAbschlichterLabel2, absch2Field.textProperty());

        });

    }

}