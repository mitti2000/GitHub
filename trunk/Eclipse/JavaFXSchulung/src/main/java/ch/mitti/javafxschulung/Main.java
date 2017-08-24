package ch.mitti.javafxschulung;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch.fxml"));		
		fxmlLoader.setController(new TelefonbuchController());
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false); //make resizable or not
		primaryStage.setTitle("Hello World"); // Set the window title
		primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("telefon.png").toExternalForm()));
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();
	}


}
