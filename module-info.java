module ensem.gameACL2 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens ensem.gameACL2 to javafx.fxml;
    exports ensem.gameACL2;
}
