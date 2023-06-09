module com.police.policesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.xerial.sqlitejdbc;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                    
    opens com.police.policesystem to javafx.fxml;
    exports com.police.policesystem;
    exports com.police.policesystem.Controllers;
    exports com.police.policesystem.Controllers.Admin;
    exports com.police.policesystem.Controllers.Users;
    exports com.police.policesystem.Models;
    exports com.police.policesystem.Views;
}