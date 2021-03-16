package gui;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import exceptions.InvalidValueException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.Book;
import model.Bookstore;
import model.Client;

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
    
    @FXML
    private TableView<Client> tvClients;
    
    @FXML
    private TableColumn<Client, String> tcClientName;
    
    @FXML
    private TableColumn<Client, String> tcClientIdentification;
    
    @FXML
    private TableColumn<Client, String> tcClientStatus;



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

	//methods StoreSetup
	@FXML
	void btnPressedContinue(ActionEvent event) throws IOException  {
		try {
			if(txtFieldCashiers.getText().equals("") || txtFieldShelves.getText().equals("")) {
				alertEmptyField(); 
			}else if(Integer.parseInt(txtFieldCashiers.getText())<=0 || Integer.parseInt(txtFieldShelves.getText())<=0){
				throw new InvalidValueException();
			}else {
				bookstore.initializeStore(Integer.parseInt(txtFieldCashiers.getText()), Integer.parseInt(txtFieldShelves.getText()));
				loadStoreInformation();
			}
		}catch(NumberFormatException nfe) {
			alertTypeDataIncorrect();
		}catch(InvalidValueException ive) {
			alertInvalidValueException();
		}
		txtFieldCashiers.setText("");
		txtFieldShelves.setText("");
	}
	
	public void loadStoreInformation() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreInformation.fxml"));
    	
    	fxmlLoader.setController(this);

    	Parent storeInformation = fxmlLoader.load();
    	
    	mainPane.getChildren().clear();
    	mainPane.setCenter(storeInformation);
    	txtMaxShelves.setText(txtFieldShelves.getText());
    	
    	btnAddToShelve.setDisable(true);
    	txtFieldBookTitle.setDisable(true);
    	txtFieldAuthor.setDisable(true);
    	txtFieldISBN.setDisable(true);
    	txtFieldStock.setDisable(true);
    	txtFieldPrice.setDisable(true);
	}

	//methods storeInformation
	@FXML
	void addBooks(ActionEvent event) {

		if(txtFieldShelveName.getText().equals("") || txtFieldNumBooks.getText().equals("")) {
			alertEmptyField();
		}else {
			try {
				if(txtFieldShelveName.getText().equals("") || txtFieldNumBooks.getText().equals("")) {
					alertEmptyField();
				}else {
					Integer.parseInt(txtFieldNumBooks.getText());
					txtMaxBooks.setText(txtFieldNumBooks.getText());
					btnAddBooks.setDisable(true);
					txtMaxBooks.setText(txtFieldNumBooks.getText());
					btnAddBooks.setDisable(true);
					txtFieldBookTitle.setDisable(false);
			    	txtFieldAuthor.setDisable(false);
			    	txtFieldISBN.setDisable(false);
			    	txtFieldStock.setDisable(false);
			    	txtFieldPrice.setDisable(false);
			    	btnAddToShelve.setDisable(false);
			    	txtFieldShelveName.setDisable(true);
					txtFieldNumBooks.setDisable(true);
				}
			}catch(NumberFormatException nfe) {
				alertTypeDataIncorrect();
			}
			txtFieldShelveName.setText("");
			txtFieldNumBooks.setText("");
		}
	}

	@FXML
	void addToShelve(ActionEvent event) throws IOException {
		if(txtFieldBookTitle.getText().equals("") || txtFieldAuthor.getText().equals("") || txtFieldISBN.getText().equals("") || txtFieldStock.getText().equals("") || txtFieldPrice.getText().equals("")) {
			alertEmptyField();
		} else {
			String title = txtFieldBookTitle.getText();
			double price = Double.parseDouble(txtFieldPrice.getText());
			String author = txtFieldAuthor.getText();
			String ISBN = txtFieldISBN.getText();
			int quantity = Integer.parseInt(txtFieldStock.getText());
			String sumary = "";
			Book tempBook = new Book(title, price, author, sumary, quantity);
			if(bookstore.addBook(ISBN, tempBook, Integer.parseInt(txtCompShelves.getText()) - 1)) {
				if(Integer.parseInt(txtCompBooks.getText()) == Integer.parseInt(txtMaxBooks.getText())) {
					btnAddBooks.setDisable(false);
					txtFieldShelveName.setDisable(false);
					txtFieldNumBooks.setDisable(false);
					txtFieldBookTitle.setDisable(true);
			    	txtFieldAuthor.setDisable(true);
			    	txtFieldISBN.setDisable(true);
			    	txtFieldStock.setDisable(true);
			    	txtFieldPrice.setDisable(true);
			    	btnAddToShelve.setDisable(true);
			    	if(txtCompShelves.getText().equalsIgnoreCase(txtMaxShelves.getText())) {
			    		loadClientEntering();
			    	}
			    	txtCompShelves.setText(String.valueOf(Integer.parseInt(txtCompShelves.getText())+1));
				}else {
					int newComp = Integer.parseInt(txtCompBooks.getText()) + 1;
					txtCompBooks.setText( String.valueOf(newComp) );
				}
			} else {
				alertCantAddTheBook();
			}
		}
		txtFieldBookTitle.setText("");
		txtFieldAuthor.setText("");
		txtFieldISBN.setText("");
		txtFieldStock.setText("");
		txtFieldPrice.setText("");
	}

	@FXML
	public void backToStoreSetup(ActionEvent event) throws IOException {
		showMainScreen();
	}
	
	public void loadClientEntering() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientEntering.fxml"));
		fxmlLoader.setController(this);
		
		Parent clientEntering = fxmlLoader.load();
		
		mainPane.getChildren().clear();
		mainPane.setCenter(clientEntering);
	}

	//methods ClientInformation
	
	public void loadClientInformation() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientInformation.fxml"));
		fxmlLoader.setController(this);
		
		Parent clientInformation = fxmlLoader.load();
		
		txtMaxClients.setText(txtFieldClients.getText());
		txtCompClients.setText("1");
		mainPane.getChildren().clear();
		mainPane.setCenter(clientInformation);
	}
	
	@FXML
	void btnPressedContinueClients(ActionEvent event) throws IOException {
		try {
			if(Integer.parseInt(txtFieldClients.getText())<1) {
				throw new InvalidValueException();
			}else {
				loadClientInformation();
			}
		}catch(InvalidValueException ive) {
			alertInvalidValueException();
		}catch(NumberFormatException nfe) {
			alertTypeDataIncorrect();
		}
		txtFieldClients.setText("");
	}
	
	//methods ClientInformation
	
    @FXML
    void addClient(ActionEvent event) throws IOException {
    	String name = txtFieldClientName.getText();
    	String id = txtFieldClientID.getText();
    	Client newClient = new Client(name, id);
    	bookstore.addClients(newClient);
    	if(txtCompClients.getText().equalsIgnoreCase(txtMaxClients.getText())) {
    		loadClientTable();
    	}
    	txtCompClients.setText(String.valueOf(Integer.parseInt(txtCompClients.getText())+1));
    	txtFieldClientName.setText("");
    	txtFieldClientID.setText("");
    } 
    
    @FXML
    void backToClientEntering(ActionEvent event) throws IOException {
    	loadClientEntering();
    }
    
    public void loadClientTable() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientTable.fxml"));
    	fxmlLoader.setController(this);
    	
    	Parent clientTable = fxmlLoader.load();
    	
    	mainPane.getChildren().clear();
    	mainPane.setCenter(clientTable);
    	btnPickUp.setDisable(true);
    	btnPay.setDisable(true);
    	initializateClientsTable();
    }
    
    private void initializateClientsTable() {
    	ObservableList<Client> observableList;
    	observableList = FXCollections.observableList(bookstore.getClients());
    	tvClients.setItems(observableList);
    	tcClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
    	tcClientIdentification.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
    	tcClientStatus.setCellValueFactory(new PropertyValueFactory<Client, String>("status"));
    }
    
    //method viewCatalog to ClientTable
    
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
    
    //mainPane methods
    
    @FXML
    void showAbout(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Credits");
		alert.setContentText("Juan Pablo Sanin\nJuan Camilo Zorrilla \nGiovanni Mosquera\nJuan Sebastian Rodriguez\nData Structures");
		
		alert.showAndWait();
    }

	//Alerts

	public void alertLoadProgram() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setHeaderText("Imposible load the program");
		alert.setContentText("Its imposible load the program, please contact your supplier");
		alert.show();
	}
	
	public void alertEmptyField() {
		Alert alert = new Alert(AlertType.ERROR);
		
		alert.setHeaderText("There are empty fields");
		alert.setContentText("There are empty fields that do not allow you to continue, please fill in all the fields");
		alert.show();
	}
	
	public void alertTypeDataIncorrect() {
		Alert alert = new Alert(AlertType.ERROR);
		
		alert.setHeaderText("type of data entered invalid");
		alert.setContentText("Enter a type of data that is not valid, please check all the fields");
		alert.show();
	}
	
	public void alertCantAddTheBook() {
		Alert alert = new Alert(AlertType.ERROR);
		
		alert.setHeaderText("The book can't be entered");
		alert.setContentText("There is a book with the same ISBN");
		alert.show();
	}
	
	public void alertInvalidValueException() {
		Alert alert = new Alert(AlertType.ERROR);
		
		alert.setHeaderText("The value entered is not valid");
		alert.setContentText("The value that was entered is not valid, please verify your values");
		alert.show();
	}

}
