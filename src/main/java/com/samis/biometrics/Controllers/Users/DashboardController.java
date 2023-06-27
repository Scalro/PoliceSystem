package com.samis.biometrics.Controllers.Users;

import com.samis.biometrics.Controllers.LoginController;
import com.samis.biometrics.Models.DatabaseConnection;
import com.samis.biometrics.Session.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.util.Map;
import java.util.ResourceBundle;

import static com.samis.biometrics.Models.DatabaseConnection.countStudentsByForm;

public class DashboardController implements Initializable {
    @FXML
    public Label username_lbl;

    @FXML
    public Label dateLabel;
    @FXML
    public Label form1AbsentLabel;

    @FXML
    public Label form1Label;

    @FXML
    public Label form2AbsentLabel;

    @FXML
    public Label form2Label;

    @FXML
    public Label form3AbsentLabel;

    @FXML
    public Label form3Label;

    @FXML
    public Label form4AbsentLabel;

    @FXML
    public Label form4Label;

    @FXML
    public PieChart piechart;

    public void setLoggedUsername(String username) {
        username_lbl.setText(username);
    }

    public void getForm1Label(String Form1) {
        form1Label.setText(Form1);
    }

    public void setDateLabel() {
        dateLabel.setText(LocalDate.now().toString());
    }

    public void hello() {
        System.out.println("Working");

        // Retrieve a preference
        String username = Session.getPreference("username", "");
        setLoggedUsername(username);

        String Form1 = Session.getPreference("Form1", "");
        getForm1Label(Form1);

        // Remove a preference
        Session.removePreference("username");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hello();
        setDateLabel();
        Map<String, Integer> formCounts = countStudentsByForm();

        // Display form counts on the labels
        form1Label.setText(String.valueOf(formCounts.getOrDefault("1", 0)));
        form2Label.setText(String.valueOf(formCounts.getOrDefault("2", 0)));
        form3Label.setText(String.valueOf(formCounts.getOrDefault("3", 0)));
        form4Label.setText(String.valueOf(formCounts.getOrDefault("4", 0)));

        // Update the pie chart
        piechart.getData().clear();
        for (Map.Entry<String, Integer> entry : formCounts.entrySet()) {
            String form = entry.getKey();
            int count = entry.getValue();
            piechart.getData().add(new PieChart.Data(form, count));
        }

        // You can also set absent labels if needed
        // form1AbsentLabel.setText(...);
        // form2AbsentLabel.setText(...);
        // form3AbsentLabel.setText(...);
        // form4AbsentLabel.setText(...);
    }
}
