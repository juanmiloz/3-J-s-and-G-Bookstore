package gui;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;
import model.Bookstore;

public class BookstoreGUI {
	
	private Bookstore bookstore;
	
	//Attributes mainPane.fxml
	@FXML
	private BorderPane mainPane;
	
	public BookstoreGUI(Bookstore bookstore) {
		this.bookstore = bookstore;
	}
	
	public void showMainScreen() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prueba.fxml"));
		fxmlLoader.setController(this);
		
		Parent mainScreen = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.setCenter(mainScreen);
	}
	
	//Alerts
	
	public void alertLoadProgram() {
		Alert alert = new Alert(AlertType.ERROR);
		
		alert.setHeaderText("Imposible load the program");
		alert.setContentText("Its imposible load the program, please contact your supplier");
		alert.show();
	}

}
