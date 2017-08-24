package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import entity.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.PersonViewModel;

public enum TelefonbuchController5_1 implements Initializable {
    INSTANCE;

    @FXML
    private TableView<PersonViewModel> tablePhonebook;

    @FXML
    private TableColumn<PersonViewModel, String> columnName;

    @FXML
    private TableColumn<PersonViewModel, Number> columnAge;

    @FXML
    private TableColumn<PersonViewModel, String> columnPhonenumber;

    @FXML
    private TableColumn<PersonViewModel, String> columnPhonetype;

    @FXML
    private TableColumn<PersonViewModel, String> columnAdvertisment;

    @FXML
    private Button btnAdd;
    
    Stage popupStage = new Stage();

    public void initialize(URL location, ResourceBundle resources) {
        columnName.setCellValueFactory(p -> p.getValue().fullnameProperty());
        columnAge.setCellValueFactory(p -> p.getValue().ageProperty());
        columnPhonenumber.setCellValueFactory(p -> p.getValue().phonenumberProperty());
        columnPhonetype.setCellValueFactory(p -> p.getValue().phonetypeProperty());
        columnAdvertisment.setCellValueFactory(p -> p.getValue().allowAdvertismentStringProperty());

        setOnAction();
    }

    private void setOnAction() {
        btnAdd.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Telefonbuch5_2.fxml"));
            loader.setController(new TelefonbuchController5_2());
            Parent root;
            try {
                root = loader.load();
                Scene scene = new Scene(root);
                popupStage.setResizable(false);
                popupStage.setTitle("Telefonbuch");
                popupStage.getIcons().add(new Image(getClass().getClassLoader().getResource("telefon.png").toExternalForm()));
                popupStage.setScene(scene);
                popupStage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
    
    public void save(Person person) {
        tablePhonebook.getItems().add(new PersonViewModel(person));
        popupStage.close();
    }
    
    public void cancel() {
        popupStage.close();
    }
}