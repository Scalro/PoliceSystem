module com.police.policesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
    requires mysql.connector.j;
    requires org.json;

    opens com.samis.biometrics to javafx.fxml;
    exports com.samis.biometrics;
    exports com.samis.biometrics.Controllers;
    exports com.samis.biometrics.Controllers.Admin;
    exports com.samis.biometrics.Controllers.Users;
    exports com.samis.biometrics.Models;
    exports com.samis.biometrics.Views;
}