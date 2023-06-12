package com.police.policesystem.Views;

import com.police.policesystem.Controllers.Users.UsersController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private final StringProperty userSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane casesReportAView;
    private AnchorPane casesReportBView;
    private AnchorPane accidentReportView;

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

    public AnchorPane getCasesReportAView(){
        if (casesReportAView == null) {
            try {
                casesReportAView = new FXMLLoader(getClass().getResource("/Fxml/Users/CasesReportA.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return casesReportAView;
    }

    public AnchorPane getCasesReportBView(){
        if (casesReportBView == null) {
            try {
                casesReportBView = new FXMLLoader(getClass().getResource("/Fxml/Users/CasesReportB.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return casesReportBView;
    }

    public AnchorPane getAccidentReportView() {
        if (accidentReportView == null) {
            try {
                accidentReportView = new FXMLLoader(getClass().getResource("/Fxml/Users/AccidentReport.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return accidentReportView;
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
        stage.setTitle("Police");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}
