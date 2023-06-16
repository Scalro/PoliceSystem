package com.samis.biometrics.Views;

import com.samis.biometrics.Controllers.Admin.AdminController;
import com.samis.biometrics.Controllers.Users.UsersController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    private final ObjectProperty<UserMenuOption> userSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane attendanceView;
    private AnchorPane addStudentView;
    private AnchorPane checkInView;
    private AnchorPane checkOutView;

    /* Admin */
    private final ObjectProperty<AdminMenuOption> adminSelectedMenuItem;
    private AnchorPane createUserView;
    private AnchorPane viewUsersView;
    private AnchorPane editView;
    public ViewFactory(){
        this.loginAccountType = AccountType.USER;
        this.userSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<UserMenuOption> getUserSelectedMenuItem() {
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

    public AnchorPane getAttendanceView(){
        if (attendanceView == null) {
            try {
                attendanceView = new FXMLLoader(getClass().getResource("/Fxml/Users/Students.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return attendanceView;
    }

    public AnchorPane getAddStudentView(){
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
                checkInView = new FXMLLoader(getClass().getResource("/Fxml/Users/CheckInOut.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return checkInView;
    }

    public AnchorPane getCheckOutView() {
        if (checkOutView == null) {
            try {
                checkOutView = new FXMLLoader(getClass().getResource("/Fxml/Users/AttReports.fxml")).load();
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
    /*Admin*/

    public ObjectProperty<AdminMenuOption> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public void showAdminWidow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }

    public AnchorPane getCreateUserView(){

        if (createUserView == null) {
            try {
                createUserView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateUser.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return createUserView;
    }

    public AnchorPane getViewUsersView() {
        if (viewUsersView == null) {
            try {
                viewUsersView = new FXMLLoader(getClass().getResource("/Fxml/Admin/ViewUsers.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return viewUsersView;
    }

    public AnchorPane getEditView() {
        if (editView == null) {
            try {
                editView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Edit.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return editView;
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
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/logo.png"))));
        stage.setResizable(false);
        stage.setTitle("Samis");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}
