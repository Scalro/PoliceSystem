package com.police.policesystem.Controllers.Users;

import com.police.policesystem.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {
    public BorderPane user_parent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getUserSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case "CasesReportA" -> user_parent.setCenter(Model.getInstance().getViewFactory().getCasesReportAView());
                case "CasesReportB" -> user_parent.setCenter(Model.getInstance().getViewFactory().getCasesReportBView());
                default -> user_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        } );
    }
}
