package com.samis.biometrics.Controllers.Admin;

import com.samis.biometrics.Models.Model;
import com.samis.biometrics.Views.AdminMenuOption;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    @FXML
    public Button create_user_btn;

    @FXML
    public Button edit_btn;

    @FXML
    public Button view_user_btn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    public void addListeners(){
        create_user_btn.setOnAction(event -> onCreateUser());
        view_user_btn.setOnAction(event -> onViewUser());
        edit_btn.setOnAction(event -> onEdit());
    }

    public void onCreateUser(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOption.CREATE_USER);
    }
    public void onViewUser(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOption.VIEW_USERS);
    }
    public void onEdit(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOption.EDIT);
    }
}
