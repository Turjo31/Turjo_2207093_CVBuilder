package com.example.assignment_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class FormController
{

    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phone;
    @FXML private TextField address;

    @FXML
    private void onGenerateClick(ActionEvent event) throws IOException
    {

        String Name  = name.getText();
        String Email = email.getText();
        String Phone = phone.getText();
        String Address  = address.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cv.fxml"));
        Parent root = loader.load();

        CvController cvController = loader.getController();
        cvController.setData(Name, Email, Phone, Address);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

