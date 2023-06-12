package com.samis.biometrics.Views;

import com.samis.biometrics.Controllers.Users.UsersController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private final StringProperty userSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane attendanceView;
    private AnchorPane addStudentView;
    private AnchorPane checkInView;
    private AnchorPane checkOutView;

    public ViewFactory(){
        this.userSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getUserSelectedMenuItem() {
        return userSelectedMenuItem;
    }

    public AnchorPane getDashboardView(){

        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Users/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getAttendanceViewView(){
        if (attendanceView == null) {
            try {
                attendanceView = new FXMLLoader(getClass().getResource("/Fxml/Users/Attendance.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return attendanceView;
    }

    public AnchorPane getAddStudentViewView(){
        if (addStudentView == null) {
            try {
                addStudentView = new FXMLLoader(getClass().getResource("/Fxml/Users/AddStudent.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return addStudentView;
    }

    public AnchorPane getCheckInView() {
        if (checkInView == null) {
            try {
                checkInView = new FXMLLoader(getClass().getResource("/Fxml/Users/CheckIn.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return checkInView;
    }

    public AnchorPane getCheckOutView() {
        if (checkOutView == null) {
            try {
                checkOutView = new FXMLLoader(getClass().getResource("/Fxml/Users/CheckOut.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return checkOutView;
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }
    public void showUserWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Users/Users.fxml"));
        UsersController usersController = new UsersController();
        loader.setController(usersController);

        createStage(loader);
    }

    public void createStage(FXMLLoader loader){

        Scene scene = null;

        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Samis");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}
