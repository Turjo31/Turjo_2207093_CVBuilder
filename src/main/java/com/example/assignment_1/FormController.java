package com.example.assignment_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class FormController
{

    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phone;
    @FXML private TextField address;
    @FXML private TextField skill;
    @FXML private TextField experience;
    @FXML private TextField education;
    @FXML private TextField project;

    @FXML
    private void onGenerateClick(ActionEvent event) throws IOException
    {
        if (name.getText().isEmpty() || email.getText().isEmpty() ||
                phone.getText().isEmpty() || address.getText().isEmpty() ||
                skill.getText().isEmpty() || experience.getText().isEmpty() ||
                education.getText().isEmpty() || project.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText("All fields are required.");
            alert.setContentText("Please fill up all the fields before generating the CV.");
            alert.showAndWait();
            return;
        }
        String Name  = name.getText();
        String Email = email.getText();
        String Phone = phone.getText();
        String Address  = address.getText();
        String Skill  = skill.getText();
        String Experience = experience.getText();
        String Education = education.getText();
        String Project = project.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cv.fxml"));
        Parent root = loader.load();

        CvController cvController = loader.getController();
        cvController.setData(Name, Email, Phone, Address, Education, Skill, Experience, Project);
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Success");
        successAlert.setHeaderText("CV has been generated.");
        successAlert.setContentText("Your CV has been saved successfully.");
        successAlert.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setWidth(720);
        stage.setHeight(800);
        stage.show();
    }
}

