package com.samis.biometrics.Controllers.Admin;

import com.samis.biometrics.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController  implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case VIEW_USERS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getViewUsersView());
                case EDIT -> admin_parent.setCenter(Model.getInstance().getViewFactory().getEditView());
                default -> admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateUserView());

            }
        } );
    }
}
