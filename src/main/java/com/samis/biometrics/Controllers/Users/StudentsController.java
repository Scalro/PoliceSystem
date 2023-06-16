package com.samis.biometrics.Controllers.Users;

import com.samis.biometrics.Models.Attendance;
import com.samis.biometrics.Models.Database;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {

    @FXML
    public TableColumn<Attendance, String> adm;

    @FXML
    public TableColumn<Attendance, String> adm_year;

    @FXML
    public TableView<Attendance> att_tblView;

    @FXML
    public TableColumn<Attendance, String> check_in;

    @FXML
    public TableColumn<Attendance, String> check_out;

    @FXML
    public TableColumn<Attendance, String>form;

    @FXML
    public TableColumn<Attendance, String> gender;

    @FXML
    public TableColumn<Attendance, Integer> id;

    @FXML
    public TableColumn<Attendance, String>name;

    @FXML
    public TableColumn<Attendance, String> status;

    @FXML
    public TextField search_txtfld;

    ObservableList<Attendance> listM;

    int index = -1;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement pst = null;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        adm.setCellValueFactory(new PropertyValueFactory<>("adm"));
        form.setCellValueFactory(new PropertyValueFactory<>("form"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        adm_year.setCellValueFactory(new PropertyValueFactory<>("adm_year"));

        listM = Database.getData();
        att_tblView.setItems(listM);

        FilteredList<Attendance> filteredList = new FilteredList<>(listM, b -> true);
        search_txtfld.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredList.setPredicate(listM ->{
                if (newVal.isEmpty() || newVal.isBlank()) {
                    return true;
                }
                String search_txtfld  = newVal.toLowerCase();
                if (listM.getAdm().contains(search_txtfld)){
                    return true;
                } else if (listM.getName().toLowerCase().contains(search_txtfld)) {
                    return true;
                }else if (listM.getForm().contains(search_txtfld)) {
                    return true;
                }else if (listM.getAdm_year().contains(search_txtfld)) {
                    return true;
                }else return listM.getGender().toLowerCase().contains(search_txtfld);
            });
        });

        SortedList<Attendance> sortedData = new SortedList<>(filteredList);

        sortedData.comparatorProperty().bind(att_tblView.comparatorProperty());

        att_tblView.setItems(sortedData);

    }
}
