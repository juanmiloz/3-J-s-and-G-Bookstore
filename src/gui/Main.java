package gui;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
		fxmlLoader.setController(bookstoreGUI);
		primaryStage.getIcons().add(new Image(new FileInputStream("data/icon/icon2.png")));
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root,1366,700);
		bookstoreGUI.showMainScreen();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bookstore");
		
		primaryStage.show();
	}
}
