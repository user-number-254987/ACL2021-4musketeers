package ensem.gameACL2;

import java.io.IOException;

import javafx.fxml.FXML;

public class LabyrinthController {
	@FXML
    private void quitGame() throws IOException {
        App.setRoot("secondary");
    }
	
	@FXML
	private void printHello() throws IOException {
        System.out.println("Hello");
    }
}
