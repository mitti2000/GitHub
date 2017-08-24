package ch.mitti.javafxschulung;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TelefonbuchController implements Initializable{
	
	@FXML
	private Button btn_TestButton;
	
	@FXML
	private TextField txt_TestTextField;
	
	@FXML
	private TextField txt_TestTextField2;
	
	@FXML
	private Label lab_TestLabel;
	
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
	private TableColumn<PersonViewModel, String> columnAdvertisement;

	public void initialize(URL location, ResourceBundle resources) {
		
		columnName.setCellValueFactory(p -> p.getValue().getFullnameProperty());
		columnAge.setCellValueFactory(p -> p.getValue().getAgeProperty());
		columnPhonenumber.setCellValueFactory(p -> p.getValue().getPhonenumberProperty());
		columnPhonetype.setCellValueFactory(p -> p.getValue().getPhonetypeProperty());
		columnAdvertisement.setCellValueFactory(p -> p.getValue().getAllowAdvertisementStringProperty());
		
		btn_TestButton.disableProperty().bind(txt_TestTextField.textProperty().isEmpty().and(txt_TestTextField2.textProperty().greaterThan("test")));
		txt_TestTextField.textProperty().bindBidirectional(txt_TestTextField2.textProperty());
		
		btn_TestButton.pressedProperty().addListener(e -> txt_TestTextField2.setText("blabla"));
		btn_TestButton.setOnAction(e -> btn_TestButton.setStyle("-fx-background-color: green"));
	}
	
	/*
	 * Tabelle abfüllen: 
	 */
	
}
