package gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Bookstore;

public class Main extends Application{

	private BookstoreGUI bookstoreGUI;
	private Bookstore bookstore;
	
	public Main() {
		bookstore = new Bookstore();
		bookstoreGUI = new BookstoreGUI(bookstore);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prueba.fxml"));
		fxmlLoader.setController(bookstoreGUI);
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root,1366,700);
		
		//bookstoreGUI.showMainScreen();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bookstore");
		primaryStage.show(); 
	}

}
