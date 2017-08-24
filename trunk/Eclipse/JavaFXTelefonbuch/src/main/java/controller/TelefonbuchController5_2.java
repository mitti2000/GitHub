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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import util.AreaCode;
import util.PhoneType;

public class TelefonbuchController5_2 implements Initializable {

    @FXML
    private Button btnAdd;
    
    @FXML
    private Button btnCancel;

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

    @FXML
    private ListView<AreaCode> lvAreaCode;
    
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
        setUpDatePicker();
        setUpListView();
        setUpPhoneTypes();
        setBindings();
        setOnAction();
        setListener();
    }

    private void setListener() {
        lvAreaCode.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
            if (newvalue != null) {
                txtPhonenumber.setText(newvalue.getAreaCode());
            }
        });
        
    }

    private void setUpListView() {
        lvAreaCode.getItems().setAll(AreaCode.values());
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
        
        btnCancel.setOnAction(e -> {
            clearFields();
            TelefonbuchController5_1.INSTANCE.cancel();
        });
    }

    private void clearFields() {
        txtFirstname.clear();
        txtLastname.clear();
        txtPhonenumber.clear();
        cbAllowAdvertisment.selectedProperty().set(false);
        cobPhonetype.getSelectionModel().clearSelection();
        dpAge.setValue(null);
        lvAreaCode.getSelectionModel().clearSelection();
    }

    private void addPerson() {
        Person person = new Person(txtFirstname.getText(), txtLastname.getText(), txtPhonenumber.getText());
        if (cobPhonetype.getValue() != null) {
            person.setPhonetype(cobPhonetype.getValue().toString());
        }
        if (dpAge.getValue() != null) {
            Long age = ChronoUnit.YEARS.between(dpAge.getValue(), LocalDate.now());
            person.setAge(age.intValue());
        }
        person.setAllowAdvertisment(cbAllowAdvertisment.selectedProperty().getValue());
        TelefonbuchController5_1.INSTANCE.save(person);
        
    }

    private void setBindings() {
        btnAdd.disableProperty().bind(txtFirstname.textProperty().isEmpty()
            .or(txtLastname.textProperty().isEmpty()
                .or(txtPhonenumber.textProperty().isEmpty())));
    }
}