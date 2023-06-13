package com.samis.biometrics.Controllers.Users;

import com.samis.biometrics.Models.Model;
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
                case ATTENDANCE -> user_parent.setCenter(Model.getInstance().getViewFactory().getAttendanceView());
                case ADD_STUDENT -> user_parent.setCenter(Model.getInstance().getViewFactory().getAddStudentView());
                case CHECK_IN -> user_parent.setCenter(Model.getInstance().getViewFactory().getCheckInView());
                case CHECK_OUT-> user_parent.setCenter(Model.getInstance().getViewFactory().getCheckOutView());
                default -> user_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        } );
    }
}
