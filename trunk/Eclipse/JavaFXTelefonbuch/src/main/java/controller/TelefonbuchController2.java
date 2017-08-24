package controller;

import java.net.URL;
import java.util.ResourceBundle;
import entity.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.PersonViewModel;

public class TelefonbuchController2 implements Initializable {

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
    private TextField txtPhonetype;

    @FXML
    private TextField txtPhonenumber;

    @FXML
    private CheckBox cbAllowAdvertisment;

    @FXML
    private Slider slAge;
    
    @FXML
    private Label lblSliderValue;

    public void initialize(URL location, ResourceBundle resources) {
        columnName.setCellValueFactory(p -> p.getValue().fullnameProperty());
        columnAge.setCellValueFactory(p -> p.getValue().ageProperty());
        columnPhonenumber.setCellValueFactory(p -> p.getValue().phonenumberProperty());
        columnPhonetype.setCellValueFactory(p -> p.getValue().phonetypeProperty());
        columnAdvertisment.setCellValueFactory(p -> p.getValue().allowAdvertismentStringProperty());

        setUpSlider();
        setBindings();
        setOnAction();
        setListener();
    }

    private void setUpSlider() {
        slAge.showTickLabelsProperty().set(true);
        slAge.showTickMarksProperty().set(true);
        slAge.setMinorTickCount(4);
        slAge.setMajorTickUnit(20);
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
        txtPhonetype.clear();
        cbAllowAdvertisment.selectedProperty().set(false);
        slAge.setValue(0.0);
    }

    private void addPerson() {
        Person person = new Person(txtFirstname.getText(), txtLastname.getText(), txtPhonenumber.getText());
        if (!txtPhonetype.getText().isEmpty()) {
            person.setPhonetype(txtPhonetype.getText());
        }
        person.setAllowAdvertisment(cbAllowAdvertisment.selectedProperty().getValue());
        person.setAge(slAge.valueProperty().intValue());
        tablePhonebook.getItems().add(new PersonViewModel(person));
    }

    private void setBindings() {
        btnAdd.disableProperty().bind(txtFirstname.textProperty().isEmpty());
        
    }
    
    private void setListener() {
        slAge.valueProperty().addListener((observable, oldvalue, newvalue) -> {
            if (newvalue != null) {
                lblSliderValue.setText(String.valueOf(newvalue.intValue()));   
            }
        });
    }
}