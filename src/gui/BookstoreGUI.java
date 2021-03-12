package gui;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import model.Bookstore;

public class BookstoreGUI {

	private Bookstore bookstore;

	//Attributes mainPane.fxml
	@FXML
	private BorderPane mainPane;


	//Attributes StoreSetup.fxml

	@FXML
	private JFXTextField txtFieldCashiers;

	@FXML
	private JFXTextField txtFieldShelves;

	@FXML
	private JFXButton btnContinue;
	
	
	//Attributes StoreInformation.fxml

	@FXML
	private JFXButton btnAddBooks;

	@FXML
	private JFXTextField txtFieldShelveName;

	@FXML
	private JFXTextField txtFieldNumBooks;

	@FXML
	private JFXButton btnAddToShelve;

	@FXML
	private JFXTextField txtFieldBookTitle;

	@FXML
	private JFXTextField txtFieldAuthor;

	@FXML
	private JFXTextField txtFieldStock;

	@FXML
	private JFXTextField txtFieldISBN;

	@FXML
	private JFXTextField txtFieldPrice;

	@FXML
	private Text txtCompShelves;

	@FXML
	private Text txtMaxShelves;

	@FXML
	private Text txtCompBooks;

	@FXML
	private Text txtMaxBooks;

	@FXML
	private JFXButton backButton;


	public BookstoreGUI(Bookstore bookstore) {
		this.bookstore = bookstore;
	}

	public void showMainScreen() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreSetup.fxml"));
		fxmlLoader.setController(this);

		Parent mainScreen = fxmlLoader.load();

		mainPane.getStyleClass().addAll(mainScreen.getStylesheets());
		mainPane.getChildren().clear();
		mainPane.setCenter(mainScreen);
	}
	
	

	@FXML
	void btnPressedContinue(ActionEvent event) {

	}
	
	@FXML
    void addBooks(ActionEvent event) {

    }

    @FXML
    void addToShelve(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {

    }

	//Alerts

	public void alertLoadProgram() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setHeaderText("Imposible load the program");
		alert.setContentText("Its imposible load the program, please contact your supplier");
		alert.show();
	}

}
