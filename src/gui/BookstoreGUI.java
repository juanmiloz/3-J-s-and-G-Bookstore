package gui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
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
	private JFXButton btnAddToWishlist;

	@FXML
	private JFXButton btnFinishCatalog;

	@FXML
	private JFXButton prevShelve;

	@FXML
	private JFXButton nextShelve;
	
	@FXML
	private TableView<Book> tvCatalog;

	@FXML
	private TableColumn<Book, String> tcBookTitle;

	@FXML
	private TableColumn<Book, Double> tcBookPrice;

	@FXML
	private TableColumn<Book, String> tcBookAuthor;

	@FXML
	private TableColumn<Book, Integer> tcBookQuantity;
	
	@FXML
    private TableColumn<Book, String> tcBookISBN;

	//Attributes PickUp.fxml

	@FXML
	private JFXButton btnContinuePickUp;

	@FXML
	private JFXToggleButton tglSort2;

	@FXML
	private JFXToggleButton tglSort1;

	@FXML
	private JFXToggleButton tglSort3;

	@FXML
	private ToggleGroup sortSelection;

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

	private Client currentClientFillCatalog;

	private Client currentClienttoSort;

	private int currentCatalogPosition;

	@FXML
	private JFXButton btnViewSumary;

	@FXML
	private Label lblCurrentShelve;

	public BookstoreGUI(Bookstore bookstore) {
		this.bookstore = bookstore;
		setCurrentClientFillCatalog(null);
		setCurrentCatalogPosition(0);
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

	/**
	 * Name: loadStoreInformation
	 * Method to load information of store <br>
	 * @throws IOException
	 */

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

	/**
	 * Name: loadStoreInformation
	 * Method to load information of store <br>
	 * @param event - event = ActionEvent
	 */
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
					bookstore.initializateBookshelves(Integer.parseInt(txtCompShelves.getText()) - 1, Integer.parseInt(txtFieldNumBooks.getText()), txtFieldShelveName.getText());
				}
			}catch(NumberFormatException nfe) {
				alertTypeDataIncorrect();
			}

		}
	}
	/**
	 * Name: addToShelve
	 * Method to show screen of add shelve <br>
	 * @param event - event = Action event
	 * @throws IOException
	 */
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
			int shelve= Integer.parseInt(txtCompShelves.getText()) - 1;
			int posInShelve= Integer.parseInt(txtCompBooks.getText())-1;
			Book tempBook = new Book(title, price, author, quantity, ISBN,shelve, posInShelve, bookstore.getBookCount()+1);
			
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
					txtFieldShelveName.setText("");
					txtFieldNumBooks.setText("");
					if(txtCompShelves.getText().equalsIgnoreCase(txtMaxShelves.getText())) {
						loadClientEntering();
					}
					txtCompBooks.setText("1");
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
	/**
	 * Name: backToStoreSetup
	 * Method to show screen store set up<br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	public void backToStoreSetup(ActionEvent event) throws IOException {
		showMainScreen();
	}
	/**
	 * Name: loadClientEntering
	 * Method to load client .<br>
	 * @throws IOException
	 */
	public void loadClientEntering() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientEntering.fxml"));
		fxmlLoader.setController(this);

		Parent clientEntering = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(clientEntering);

	}

	//methods ClientInformation
	/**
	 * Name: loadClientInformation
	 * Method to load client information .<br>
	 * @throws IOException
	 */
	public void loadClientInformation() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClientInformation.fxml"));
		fxmlLoader.setController(this);

		Parent clientInformation = fxmlLoader.load();

		txtMaxClients.setText(txtFieldClients.getText());
		txtCompClients.setText("1");
		mainPane.getChildren().clear();
		mainPane.setCenter(clientInformation);
	}
	/**
	 * Name: btnPressedContinueClients
	 * Method to pass next screen for get client information .<br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
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
	/**
	 * Name: addClient
	 * Method to add client information .<br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void addClient(ActionEvent event) throws IOException {
		String name = txtFieldClientName.getText();
		String id = txtFieldClientID.getText();
		int time; 
		if(bookstore.getClients().isEmpty()) {
			time=1;	
		}else {
			time= bookstore.getClients().size()+1;
		}

		Client newClient = new Client(name, id, time);
		bookstore.addClients(newClient);
		if(txtCompClients.getText().equalsIgnoreCase(txtMaxClients.getText())) {
			loadClientTable();
		}

		//System.out.println(newClient.getTime());
		txtCompClients.setText(String.valueOf(Integer.parseInt(txtCompClients.getText())+1));
		txtFieldClientName.setText("");
		txtFieldClientID.setText("");
	} 
	/**
	 * Name: backToClientEntering
	 * Method to back entering client.<br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void backToClientEntering(ActionEvent event) throws IOException {
		loadClientEntering();
	}
	/**
	 * Name: loadClientTable
	 * Method to load client table.<br>
	 * @throws IOException
	 */
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
	/**
	 * Name: initializateClientsTable
	 * Method to initialize client table.<br>
	 */
	private void initializateClientsTable() {
		if(bookstore.isClientsCatalog()) {
			btnCatalog.setDisable(false);
			btnPickUp.setDisable(true);
			btnPay.setDisable(true);
		} else {
			if(bookstore.isClientsPickUp()) {
				btnCatalog.setDisable(true);
				btnPickUp.setDisable(false);
				btnPay.setDisable(true);
				setCurrentClientFillCatalog(null);
			} else {
				btnPay.setDisable(false);
				btnPickUp.setDisable(true);
				btnCatalog.setDisable(true);
			}
		}
		ObservableList<Client> observableList;
		observableList = FXCollections.observableList(bookstore.getClients());
		tvClients.setItems(observableList);
		tcClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		tcClientIdentification.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		tcClientStatus.setCellValueFactory(new PropertyValueFactory<Client, String>("status"));
	}

	//method viewCatalog to ClientTable
	/**
	 * Name: viewCatalog
	 * Method to show catalog .<br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void viewCatalog(ActionEvent event) throws IOException {
		if(!tvClients.getSelectionModel().isEmpty()) {
			setCurrentClientFillCatalog(tvClients.getSelectionModel().getSelectedItem());
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Catalog.fxml"));
			fxmlLoader.setController(this);

			Parent clientTable = fxmlLoader.load();

			mainPane.getChildren().clear();
			mainPane.setCenter(clientTable);
			setCurrentCatalogPosition(0);
			loadCatalog();
		} else {
			alertSelectetClient();
		}

	}
	/**
	 * Name: loadCatalog
	 * Method to load catalog .<br>
	 */
	private void loadCatalog() {
		ObservableList<Book> observableList;
		observableList = FXCollections.observableList(bookstore.getSpecificShelve(getCurrentCatalogPosition()));
		tvCatalog.setItems(observableList);
		tcBookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		tcBookPrice.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));
		tcBookAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		tcBookQuantity.setCellValueFactory(new PropertyValueFactory<Book, Integer>("quantity"));
		tcBookISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		lblCurrentShelve.setText("Bookshelve name: " + bookstore.getBookshelveName(getCurrentCatalogPosition()));
	}
	/**
	 * Name: showNextShelve
	 * Method to show next shelve .<br>
	 * @param event - event = ActionEvent
	 */
	@FXML
	void showNextShelve(ActionEvent event) {
		int currentPosition = getCurrentCatalogPosition() + 1;
		setCurrentCatalogPosition(currentPosition);
		//System.out.println(bookstore.getBookshelves().length);
		if(getCurrentCatalogPosition() >= bookstore.getBookshelves().length) {
			setCurrentCatalogPosition(0);
		}
		loadCatalog();
	}

	/**
	 * Name: addToWishlist
	 * Method to show screen wishlist .<br>
	 */
	@FXML
	void addToWishlist(ActionEvent event) {
		if(!tvCatalog.getSelectionModel().isEmpty()) {
			if(tvCatalog.getSelectionModel().getSelectedItem().getQuantity() > 0) {
				Book bookToAdd = tvCatalog.getSelectionModel().getSelectedItem();
				getCurrentClientFillCatalog().addBook(bookToAdd);
				getCurrentClientFillCatalog().setStatus("Pick-Up");
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Success");
				alert.setContentText("ISBN Code: " + bookToAdd.getISBN() + " has been added successfully");
				alert.showAndWait();
				tvCatalog.refresh();
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Error");
				alert.setContentText("No remaining books of this, select another");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Error");
			alert.setContentText("You must select one book from the table");
			alert.showAndWait();
		}
	}
	/**
	 * Name: finishCatalog
	 * Method to show finish catalog<br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void finishCatalog(ActionEvent event) throws IOException {
		setCurrentClientFillCatalog(null);
		loadClientTable();
	}
	/**
	 * Name: showPreviousShelve
	 * Method to show previous shelf<br>
	 * @param event
	 */
	@FXML
	void showPreviousShelve(ActionEvent event) {
		int currentPosition = getCurrentCatalogPosition() - 1;
		setCurrentCatalogPosition(currentPosition);
		if(getCurrentCatalogPosition() < 0) {
			setCurrentCatalogPosition(bookstore.getBookshelves().length - 1);
		}
		loadCatalog();
	}
	/**
	 * Name: back
	 * Method to go back<br>
	 * @param event
	 */
	@FXML
	void back(ActionEvent event) {

	}
	/**
	 * Name: viewPickUp
	 * Method to showpick up<br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewPickUp(ActionEvent event) throws IOException {
		if(!tvClients.getSelectionModel().isEmpty()) {
			setCurrentClienttoSort(tvClients.getSelectionModel().getSelectedItem());
			loadPickUp();
		}else {
			alertSelectetClient();
		}
	}

	public void loadPickUp() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PickUp.fxml"));
		fxmlLoader.setController(this);

		Parent pickUp = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(pickUp);
	}

	@FXML
	public void backToClientTable(ActionEvent event) throws IOException {
		loadClientTable();
	}

	private String bucketSort(ArrayList<Book> books)
	{
		Book[] booksToSort = new Book[books.size()];
		for(int c = 0; c < books.size(); c++) {
			booksToSort[c] = books.get(c);
		}
		System.out.println("Bucket-Sort");
		System.out.println("==============");
		System.out.println("Before");
		for(int c=0; c < booksToSort.length; c++) {
			System.out.println(booksToSort[c].getISBN());
		}
		String message = "";
		if(booksToSort.length <= 0) {
			return message;
		}
		// Create n empty buckets
		@SuppressWarnings("unchecked")
		Vector<Book>[] buckets = new Vector[booksToSort.length];
		for(int c = 0; c < booksToSort.length; c++) {
			buckets[c] = new Vector<Book>();
		}
		
		// Put array elements in different buckets
		for(int c = 0; c < booksToSort.length; c++) {
			int idx = booksToSort[c].getBookCount() * booksToSort.length;
			buckets[idx].add(booksToSort[c]);
		}
		
		//Sort individual buckets
		for(int c = 0; c < booksToSort.length; c++) {
			Collections.sort(buckets[c]);
		}
		
		// Concatenate information
		int index = 0;
		for (int c = 0; c < booksToSort.length; c++) {
            for (int j = 0; j < buckets[c].size(); j++) {
            	booksToSort[index++] = buckets[c].get(j);
            }
        }
		
		// Print information
		for(Book book : booksToSort) {
			message += book.getISBN() + "," + book.getShelve() + "," + book.getPosInShelve();
		}
		
		return message;
	}
	
	@FXML
	void continuePickUp(ActionEvent event) {

		int sort = 0;
		if(sortSelection.getSelectedToggle() != null) {
			sort = numberSort();

			switch(sort){
			case 1:
				bubbleSort(removeOutOfStock(getCurrentClienttoSort().getBooksCodes()));
				break;

			case 2:
				countingSort(removeOutOfStock(getCurrentClienttoSort().getBooksCodes()));
				break;

			case 3:
				System.out.println(bucketSort(removeOutOfStock(getCurrentClienttoSort().getBooksCodes())));
				break;
			}
		}else {
			alertSelectetToggle();
		}



	}


	public ArrayList<Book> removeOutOfStock(ArrayList<Book> booksToRemove) {
		ArrayList<Book> removedArrayList= booksToRemove;
		ArrayList<String> booksRemove = new ArrayList<>();
		for (int i = 0; i < removedArrayList.size(); i++) {
			if(removedArrayList.get(i).getQuantity()==0) {
				removedArrayList.remove(i);
				booksRemove.add(removedArrayList.get(i).getISBN());
			}
		}
		if(!booksRemove.isEmpty()) {
			alertBookDontHaveStock(booksRemove);
		}
		return removedArrayList;
	}



	public void bubbleSort( ArrayList<Book> booksToSort) {
		System.out.println("Bubble");
		System.out.println("==============");
		System.out.println("Before");
		for(int i=0; i<booksToSort.size();i++) {
			System.out.println(booksToSort.get(i).getISBN());
		}
		int n = booksToSort.size(); 
		for (int i = 0; i < n-1; i++) 
			for (int j = 0; j < n-i-1; j++) 
				if (booksToSort.get(j).getShelve()==booksToSort.get(j+1).getShelve()){ 
					if (booksToSort.get(j).getPosInShelve() > booksToSort.get(j+1).getPosInShelve()) {
						Book temp = booksToSort.get(j); 
						booksToSort.set(j, booksToSort.get(j+1));
						booksToSort.set(j+1,temp); 
					}
				}else if (booksToSort.get(j).getShelve() > booksToSort.get(j+1).getShelve()){ 
					// swap 
					Book temp = booksToSort.get(j); 
					booksToSort.set(j, booksToSort.get(j+1));
					booksToSort.set(j+1,temp); 
				} 

		System.out.println("==============");
		System.out.println("After");
		for(int i=0; i<booksToSort.size();i++) {
			System.out.println(booksToSort.get(i).getISBN()+ ","+ booksToSort.get(i).getShelve()+ ","+ booksToSort.get(i).getPosInShelve());
		}

	}

	public void countingSort(ArrayList<Book> booksToSort) {
		System.out.println("Counting");
		System.out.println("==============");
		System.out.println("Before");
		for(int i=0; i<booksToSort.size();i++) {
			System.out.println(booksToSort.get(i).getISBN());
		}

		Book booksToSortArr[]= new Book[booksToSort.size()];
		int n = booksToSortArr.length;
		
		//Swap for arraylist to array
		for(int i=0; i<n;i++) {
			booksToSortArr[i]=booksToSort.get(i);
		}
		
		Book output[] = new Book[n];

		// Create a count array to store count of individual
		// initialize count array as 0, max value is total shelves
		int max=bookstore.getBookCount()+1;
	
		//max = count del ultimo elemento de la ultima estanteria
		
		int count[] = new int[max];
		for (int i = 0; i < max; ++i)
			count[i] = 0;

		// store count of each character
		for (int i = 0; i < n; ++i)
			++count[booksToSortArr[i].getBookCount()];

		// Change count[i] so that count[i] now contains actual
		// position of this book in output array
		for (int i = 1; i <= max-1; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		// To make it stable we are operating in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			output[count[booksToSortArr[i].getBookCount()] - 1] = booksToSortArr[i];
			--count[booksToSortArr[i].getBookCount()];
		}
		
		System.out.println("==============");
		System.out.println("After");
		for(int i=0; i<output.length;i++) {
			System.out.println(output[i].getISBN()+ ","+ output[i].getShelve()+ ","+ output[i].getPosInShelve());
		}
		

	}



	public int numberSort() {
		int sort = 0;
		if(sortSelection.getSelectedToggle().equals(tglSort1)) {
			sort = 1; 
		}else if(sortSelection.getSelectedToggle().equals(tglSort2)) {
			sort = 2;
		}else if(sortSelection.getSelectedToggle().equals(tglSort3)) {
			sort = 3;
		}
		return sort;

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

	public void alertSelectetClient() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Error");
		alert.setContentText("You must select one client from the table");
		alert.showAndWait();
	}

	public void alertSelectetToggle() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Error");
		alert.setContentText("You must select one toggle");
		alert.showAndWait();
	}
	
	public void alertBookDontHaveStock(ArrayList<String> codes) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Quantity not available");
		for(int i = 0; i < codes.size(); i++) {
			alert.setContentText("The book whit " + codes.get(i) + " is out of stock\n");
		}
		alert.showAndWait();
	}

	public Client getCurrentClientFillCatalog() {
		return currentClientFillCatalog;
	}

	public void setCurrentClientFillCatalog(Client currentClientFillCatalog) {
		this.currentClientFillCatalog = currentClientFillCatalog;
	}

	public int getCurrentCatalogPosition() {
		return currentCatalogPosition;
	}

	public void setCurrentCatalogPosition(int currentCatalogPosition) {
		this.currentCatalogPosition = currentCatalogPosition;
	}

	public Client getCurrentClienttoSort() {
		return currentClienttoSort;
	}
	public void setCurrentClienttoSort(Client currentClienttoSort) {
		this.currentClienttoSort = currentClienttoSort;
	}

}
