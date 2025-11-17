package com.example.assignment_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CvController {

    @FXML
    private Label Name;
    @FXML
    private Label Email;
    @FXML
    private Label Phone;
    @FXML
    private Label Address;
    @FXML
    private Label Skill;
    @FXML
    private Label Experience;
    @FXML
    private Label Education;
    @FXML
    private Label Project;

    public void setData(String name, String email, String phone, String address, String education, String skill, String experience, String project)
    {
        Name.setText(name);
        Email.setText(email);
        Phone.setText(phone);
        Address.setText(address);
        Education.setText(education);
        Experience.setText(experience);
        Project.setText(project);
        Skill.setText(skill);
    }
    @FXML
    private void onHomeClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-screen2.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setWidth(800);
        stage.setHeight(625);
        stage.show();
    }

}
