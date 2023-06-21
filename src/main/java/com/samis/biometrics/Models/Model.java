package com.samis.biometrics.Models;

import com.samis.biometrics.Controllers.LoginController;
import com.samis.biometrics.Views.AccountType;
import com.samis.biometrics.Views.ViewFactory;
import com.sun.javafx.charts.Legend;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    private final LoginController loginController;
    private AccountType loginAccountType = AccountType.USER;
    private boolean userLoginSuccessFlag;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.loginController = new LoginController();
        this.userLoginSuccessFlag = false;
    }
    public static synchronized Model getInstance(){

        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {return viewFactory;}

    public AccountType getLoginAccountType() {return loginAccountType;}

    public void setLoginAccountType(AccountType loginaccountType) {this.loginAccountType = loginaccountType;}

    public LoginController getLoginController() {return loginController;}

    public boolean getUserLoginSuccessFlag() {return userLoginSuccessFlag;}

    public void setUserLoginSuccessFlag(boolean flag) {this.userLoginSuccessFlag = flag;}

    
}
