package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import entity.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.PersonViewModel;
import util.PhoneType;

public class TelefonbuchController3 implements Initializable {

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

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtLastname;

    @FXML
    private ComboBox<PhoneType> cobPhonetype;

    @FXML
    private TextField txtPhonenumber;

    @FXML
    private CheckBox cbAllowAdvertisment;

    @FXML
    private DatePicker dpAge;
    
    @FXML
    private Label lblSliderValue;
    
    final Callback<DatePicker, DateCell> dayCellFactory = (DatePicker datePicker) -> new DateCell() {
        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            
            if (item.isAfter(LocalDate.now())) {
                setDisable(true);
            }
        }
    };

    public void initialize(URL location, ResourceBundle resources) {
        columnName.setCellValueFactory(p -> p.getValue().fullnameProperty());
        columnAge.setCellValueFactory(p -> p.getValue().ageProperty());
        columnPhonenumber.setCellValueFactory(p -> p.getValue().phonenumberProperty());
        columnPhonetype.setCellValueFactory(p -> p.getValue().phonetypeProperty());
        columnAdvertisment.setCellValueFactory(p -> p.getValue().allowAdvertismentStringProperty());

        setUpDatePicker();
        setUpPhoneTypes();
        setBindings();
        setOnAction();
    }

    private void setUpPhoneTypes() {
        cobPhonetype.getItems().setAll(PhoneType.values());
    }
    
    private void setUpDatePicker() {
        dpAge.setShowWeekNumbers(true);
        dpAge.setDayCellFactory(dayCellFactory);
    }

    private void setOnAction() {
        btnAdd.setOnAction(e -> {
            addPerson();
            clearFields();
        });
    }

    private void clearFields() {
        txtFirstname.clear();
        txtLastname.clear();
        txtPhonenumber.clear();
        cbAllowAdvertisment.selectedProperty().set(false);
        cobPhonetype.getSelectionModel().clearSelection();
        dpAge.setValue(null);
    }

    private void addPerson() {
        Person person = new Person(txtFirstname.getText(), txtLastname.getText(), txtPhonenumber.getText());
        if(cobPhonetype.getValue() != null) {
            person.setPhonetype(cobPhonetype.getValue().toString());
        }
        if(dpAge.getValue() != null) {
            Long age = ChronoUnit.YEARS.between(dpAge.getValue(), LocalDate.now());
            person.setAge(age.intValue());
        }
        person.setAllowAdvertisment(cbAllowAdvertisment.selectedProperty().getValue());
        tablePhonebook.getItems().add(new PersonViewModel(person));
    }

    private void setBindings() {
        btnAdd.disableProperty().bind(txtFirstname.textProperty().isEmpty()
            .or(txtLastname.textProperty().isEmpty()
                .or(txtPhonenumber.textProperty().isEmpty())));
    }
}