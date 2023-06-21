package com.samis.biometrics.Controllers.Users;

import com.samis.biometrics.Models.DatabaseConnection;
import com.samis.biometrics.Models.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;


public class AddStudentController implements Initializable {

    @FXML
    public TextField adm_lbl;

    @FXML
    public  TextField adm_year;

    @FXML
    public TextField form_lbl;

    @FXML
    public TextField gender_lbl;

    @FXML
    public TextField name_lbl;
    @FXML
    public Button add_btn;

    Connection connection = null;
    PreparedStatement pst = null;
    public void Add_user(){
        connection = DatabaseConnection.ConnectDb();
        String sql = "insert into students(name,adm,form,gender,adm_year) values(?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,name_lbl.getText());
            pst.setString(2,adm_lbl.getText());
            pst.setString(3,form_lbl.getText());
            pst.setString(4,gender_lbl.getText());
            pst.setString(5, adm_year.getText());
            pst.execute();

            System.out.println("Added Successfully");
        }catch (Exception e){
            throw new RuntimeException("Cannot Add", e);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_btn.setOnAction(event -> Add_user());
    }
}
