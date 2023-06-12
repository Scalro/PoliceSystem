package com.police.policesystem.Controllers.Users;

import com.police.policesystem.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {

    @FXML
    public Button accidentreport_btn;

    @FXML
    public Button casesreport_btn;
    @FXML
    public Button casesreport_btn1;
    @FXML
    public Button dashboard_btn;
    @FXML
    public Button logout_btn;
    @FXML
    public Button p3report_btn;
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
        casesreport_btn.setOnAction(event -> onCasesReportA());
        casesreport_btn1.setOnAction(event -> onCasesReportB());
        accidentreport_btn.setOnAction(event ->  onAccidentReport());
    }
    public void onDashboard(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("Dashboard");
    }
    public void onCasesReportA(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("CasesReportA");
    }

    public void onCasesReportB(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("CasesReportB");
    }
    public void onAccidentReport(){
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().set("AccidentReport");
    }
}
