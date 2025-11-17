package com.example.assignment_1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CvController {

    @FXML
    private Label Name;
    @FXML private Label Email;
    @FXML private Label Phone;
    @FXML private Label Address;

    public void setData(String name, String email, String phone, String address)
    {
        Name.setText(name);
        Email.setText(email);
        Phone.setText(phone);
        Address.setText(address);
    }
}
