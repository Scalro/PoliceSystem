package com.samis.biometrics.Controllers.Admin;

import com.samis.biometrics.Models.AddUser;
import com.samis.biometrics.Models.DatabaseConnection;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewUsersCotroller implements Initializable {

    @FXML
    public TableColumn<AddUser, String> categoryColumn;

    @FXML
    public TableColumn<AddUser, String> firstNameColumn;

    @FXML
    public TableColumn<AddUser, Integer> idColumn;

    @FXML
    public TableColumn<AddUser, String> lasnameColumn;

    @FXML
    public TableColumn<AddUser, String> passwordColumn;

    @FXML
    public TableColumn<AddUser, String> userNameColumn;

    @FXML
    public TableView<AddUser> viewUserTbl;

    @FXML
    public TextField searchTextfield;

    @FXML
    public Button refreshButton;
    public void refreshData() {
        listU.clear();
        listU.addAll(DatabaseConnection.getUser());
    }
    ObservableList<AddUser> listU;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lasnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        listU = DatabaseConnection.getUser();
        viewUserTbl.setItems(listU);

        FilteredList<AddUser> filteredList = new FilteredList<>(listU, b -> true);
        searchTextfield.textProperty().addListener((observableValue, oldVal, newVal) -> {
            filteredList.setPredicate(listU ->{
                if (newVal.isEmpty() || newVal.isBlank()) {
                    return true;
                }
                String search_txtfld  = newVal.toLowerCase();
                if (listU.getFirstName().contains(search_txtfld)){
                    return true;
                } else if (listU.getLastName().toLowerCase().contains(search_txtfld)) {
                    return true;
                }else if (listU.getUserName().toLowerCase().contains(search_txtfld)) {
                    return true;
                }else if (listU.getPassword().toLowerCase().contains(search_txtfld)) {
                    return true;
                }else return listU.getCategory().toLowerCase().contains(search_txtfld);
            });
        });

        SortedList<AddUser> sortedData = new SortedList<>(filteredList);

        sortedData.comparatorProperty().bind(viewUserTbl.comparatorProperty());

        viewUserTbl.setItems(sortedData);
    }

}
