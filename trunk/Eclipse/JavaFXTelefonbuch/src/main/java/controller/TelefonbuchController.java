package controller;

import java.net.URL;
import java.util.ResourceBundle;
import entity.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.PersonViewModel;

public class TelefonbuchController implements Initializable {

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
    
    public void initialize(URL location, ResourceBundle resources) {
        columnName.setCellValueFactory(p -> p.getValue().fullnameProperty());
        columnAge.setCellValueFactory(p -> p.getValue().ageProperty());
        columnPhonenumber.setCellValueFactory(p -> p.getValue().phonenumberProperty());
        columnPhonetype.setCellValueFactory(p -> p.getValue().phonetypeProperty());
        columnAdvertisment.setCellValueFactory(p -> p.getValue().allowAdvertismentStringProperty());
        
        addTestData();
    }

    private void addTestData() {
        tablePhonebook.getItems().clear();
        for (int i = 0; i < 5; i++) {
            tablePhonebook.getItems().add(new PersonViewModel(new Person("Vorname " + i, "Nachname " + i, "071 222 33 4" + i)));
        }
    }
}