package com.samis.biometrics.Controllers.Users;

import com.samis.biometrics.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {

    @FXML
    public Button attendance_btn;

    @FXML
    public Button addstdnt_btn;
    @FXML
    public Button checkin_btn;
    @FXML
    public Button dashboard_btn;
    @FXML
    public Button logout_btn;
    @FXML
    public Button checkout_btn;
    @FXML
    public Button report_btn;
    @FXML
    public Button userprofile_btn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    public void addListeners(){
        dashboard_btn.setOnAction(event -> onDashboard());
        attendance_btn.setOnAction(event -> onAttendance());
        addstdnt_btn.setOnAction(event -> onAddStudent());
        checkin_btn.setOnAction(event ->  onCheckIn());
        checkout_btn.setOnAction(event ->  onCheckOut());
    }
    public void onDashboard(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("Dashboard");
    }
    public void onAttendance(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("Attendance");
    }

    public void onAddStudent(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("AddStudent");
    }
    public void onCheckIn(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("CheckIn");
    }
    public void onCheckOut(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("CheckOut");
    }
}
