package gui;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

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

	

	
	

	//Attributes  ClientEnetering.fxml
	@FXML
	private JFXTextField txtFieldClients;

	@FXML
	private JFXButton btnContinueClients;
	
	
	
	//Attributes  ClientInformation.fxml
	@FXML
    private JFXTextField txtFieldClientID;

    @FXML
    private JFXTextField txtFieldClientName;

    @FXML
    private JFXButton btnNextClient;

    @FXML
    private Text txtCompClients;

    @FXML
    private Text txtMaxClients;

    
    //Attributes ClientTable.fxml
    

    @FXML
    private JFXButton btnCatalog;

    @FXML
    private JFXButton btnPickUp;

    @FXML
    private JFXButton btnPay;
    
    
    //Attributes Catalog.fxml
    
    @FXML
    private JFXButton btnAddToBasket;

    @FXML
    private JFXButton btnFinishCatalog;

    @FXML
    private JFXButton prevShelve;

    @FXML
    private JFXButton nextShelve;

    
    //Attributes PickUp.fxml
    
    @FXML
    private JFXButton btnContinuePickUp;

    @FXML
    private JFXToggleButton tglSort2;

    @FXML
    private JFXToggleButton tglSort1;

    @FXML
    private JFXToggleButton tglSort3;
    
    //Summary Attributes
    @FXML
    private JFXButton endButton;

    
    //Generic attributes
    @FXML
    private JFXButton backButton;



	public BookstoreGUI(Bookstore bookstore) {
		this.bookstore = bookstore;
	}

	public void showMainScreen() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreSetupV1.fxml"));
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

	@FXML
	void btnPressedContinueClients(ActionEvent event) {

	}
	
    @FXML
    void addClient(ActionEvent event) {

    } 
    
    
    @FXML
    void viewCatalog(ActionEvent event) {

    }
    
    
    @FXML
    void addToBasket(ActionEvent event) {

    }

    @FXML
    void finishCatalog(ActionEvent event) {

    }

    @FXML
    void showNextShelve(ActionEvent event) {

    }

    @FXML
    void showPreviousShelve(ActionEvent event) {

    }

    @FXML
    void viewPickUp(ActionEvent event) {

    }
    
    @FXML
    void continuePickUp(ActionEvent event) {

    }
    
    @FXML
    void viewPay(ActionEvent event) {

    }

    @FXML
    void endProgram(ActionEvent event) {

    }

	//Alerts

	public void alertLoadProgram() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setHeaderText("Imposible load the program");
		alert.setContentText("Its imposible load the program, please contact your supplier");
		alert.show();
	}

}
