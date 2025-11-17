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
    @FXML private TextField skill;
    @FXML private TextField experience;
    @FXML private TextField education;
    @FXML private TextField project;

    @FXML
    private void onGenerateClick(ActionEvent event) throws IOException
    {

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

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setWidth(720);
        stage.setHeight(800);
        stage.show();
    }
}

