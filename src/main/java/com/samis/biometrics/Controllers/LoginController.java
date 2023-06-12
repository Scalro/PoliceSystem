package com.samis.biometrics.Controllers;

import com.samis.biometrics.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public ChoiceBox<?> acc_choice;
    @FXML
    public Label err_lbl;
    @FXML
   public Button lgn_btn;
    @FXML
    public TextField lgn_username_field;
    @FXML
    public PasswordField login_passw_fld;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lgn_btn.setOnAction(event ->onLogin());
    }
    private void onLogin(){
        Stage stage = (Stage) err_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showUserWindow();
    }
}
