package util;

import controller.TelefonbuchController3;
import controller.TelefonbuchController4;
import controller.TelefonbuchController5_1;
import controller.TelefonbuchController2;
import controller.TelefonbuchController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch2.fxml"));
//        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch3.fxml"));
//      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch4.fxml"));
//      FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch5_1.fxml"));
        loader.setController(new TelefonbuchController());
//        loader.setController(new TelefonbuchController2());
//        loader.setController(new TelefonbuchController3());
//    loader.setController(new TelefonbuchController4());
//    loader.setController(TelefonbuchController5_1.INSTANCE);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Telefonbuch");
        stage.getIcons().add(new Image(getClass().getClassLoader().getResource("telefon.png").toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

}
