package com.samis.biometrics.Controllers.Users;

import com.samis.biometrics.Models.Model;
import com.samis.biometrics.Views.UserMenuOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

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
    @FXML
    public TextArea text_Field;

    @FXML
    public void sendButtonClicked() {
        String emailAddress = "rotichcaleb200@gmail.com";
        String message = text_Field.getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email Sent");
        alert.setHeaderText(null);
        alert.setContentText("Email sent successfully to " + emailAddress);
        alert.show();
    }

    @FXML
    public void setLogout_btn(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Logged out successfully!");
        alert.showAndWait();
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        stage.close();
    }
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
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOption.DASHBOARD);
    }
    public void onAttendance(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOption.ATTENDANCE);
    }

    public void onAddStudent(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOption.ADD_STUDENT);
    }
    public void onCheckIn(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOption.CHECK_IN);
    }
    public void onCheckOut(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set(UserMenuOption.CHECK_OUT);
    }
}
