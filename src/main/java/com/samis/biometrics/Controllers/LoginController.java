package com.samis.biometrics.Controllers;

import com.samis.biometrics.Models.DatabaseConnection;
import com.samis.biometrics.Models.Model;
import com.samis.biometrics.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.Connection;

public class LoginController implements Initializable {
    @FXML
    public ChoiceBox<AccountType> acc_choice;
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
        acc_choice.setItems(FXCollections.observableArrayList(AccountType.USER, AccountType.ADMIN));
        acc_choice.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_choice.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_choice.getValue()));
        lgn_btn.setOnAction(event ->onLogin());
    }
    private void onLogin() {
        Stage stage = (Stage) err_lbl.getScene().getWindow();
        if (Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.USER) {
            if (!(lgn_username_field.getText().isBlank() && login_passw_fld.getText().isBlank())) {
                if (validateLogin()) {
                    Model.getInstance().getViewFactory().showUserWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    err_lbl.setText("Login Successful");
                } else {
                    err_lbl.setText("Wrong username or password");
                }
            } else {
                err_lbl.setText("Please enter username and password");
            }
        } else {
            Model.getInstance().getViewFactory().showAdminWidow();
        }
    }



    public boolean validateLogin() {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connection = connect.ConnectDb();

        String verifyLogin = "SELECT count(1) FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(verifyLogin);
            statement.setString(1, lgn_username_field.getText());
            statement.setString(2, login_passw_fld.getText());
            ResultSet rs = statement.executeQuery();

            if (rs.next() && rs.getInt(1) == 1) {
                err_lbl.setText("Login Successful");
                return true;
            } else {
                err_lbl.setText("Wrong username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}