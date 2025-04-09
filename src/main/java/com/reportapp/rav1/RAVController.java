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
    private Label lfDatumLabel, lfSchneidtagLabel;
    @FXML
    private ComboBox <String> lfSchichtCBox, lfLinieCBox;
    @FXML
    private Label ppDatumLabel, ppSchneidtagLabel, ppSchichtLabel, ppLinieLabel;

    //----------------PERSONAL----------------------------------
    @FXML
    private Label ppLinienfuhrerLabel, ppSchalerLabel, ppEinlegerLabel, ppAbschlichterLabel1, ppAbschlichterLabel2;
    @FXML
    private TextField lfLinienfuhrerField, lfSchalerField, lfEinlegerField, lfAbsch1Field, lfAbsch2Field;

    //--------------PRODUKTIONSDOKUMENTATION----------------------------------

    @FXML
    private TextField lfArtikelNrField, lfBezeichnungField, mhdDatePicker, lfChargennummerField;
    @FXML
    private Label ppArtikelNrLabel, ppBezeichnungLabel;


    //----------------- ABSCHLICHTER ---------------------------------

    @FXML
    private Label abschArtikelNummer, abschBezeichnung, abschMHD, abschChargennummer;


    public void initialize() {
        initializeDatum();
        fillPrintPreview();


    }



    private void initializeDatum () {
        String date = LocalDate.now().format(dtf);
        String dayOfYear = String.valueOf(LocalDate.now().getDayOfYear());
        lfDatumLabel.setText(date);
        lfSchneidtagLabel.setText(dayOfYear);
    }

    private void bindItems (Label label, ObservableValue<?> item) {
        label.textProperty().bind(Bindings.createStringBinding(
                () -> item.getValue() != null ? item.getValue().toString() : "",
                item
        ));
    }



    private void fillPrintPreview () {
        Platform.runLater(() ->  {
            bindItems(ppDatumLabel, lfDatumLabel.textProperty());
            bindItems(ppSchneidtagLabel, lfSchneidtagLabel.textProperty());
            bindItems(ppSchichtLabel, lfSchichtCBox.valueProperty());
            bindItems(ppLinieLabel, lfLinieCBox.valueProperty());

            bindItems(ppLinienfuhrerLabel, lfLinienfuhrerField.textProperty());
            bindItems(ppSchalerLabel, lfSchalerField.textProperty());
            bindItems(ppEinlegerLabel, lfEinlegerField.textProperty());
            bindItems(ppAbschlichterLabel1, lfAbsch1Field.textProperty());
            bindItems(ppAbschlichterLabel2, lfAbsch2Field.textProperty());

            bindItems(ppArtikelNrLabel, lfArtikelNrField.textProperty());
            bindItems(ppBezeichnungLabel, lfBezeichnungField.textProperty());

            bindItems(abschArtikelNummer, lfArtikelNrField.textProperty());
            bindItems(abschBezeichnung, lfBezeichnungField.textProperty());
            bindItems(abschMHD, mhdDatePicker.textProperty());
            bindItems(abschChargennummer, lfChargennummerField.textProperty());

        });

    }

}