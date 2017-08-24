package ch.mitti.javafxschulung;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PersonViewModel {
	private SimpleStringProperty fullname = new SimpleStringProperty();
	private SimpleIntegerProperty age = new SimpleIntegerProperty();
	private SimpleStringProperty phonenumber = new SimpleStringProperty();
	private SimpleStringProperty phonetype = new SimpleStringProperty();
	private SimpleBooleanProperty allowAdvertisement = new SimpleBooleanProperty();
	private Person underlayingObject;
	
	public PersonViewModel(Person person){
		this.underlayingObject = person;
		setFullname(checkStringProperty(underlayingObject.getFirstname() + underlayingObject.getLastname()));
	}
	
	private String checkStringProperty(String property){
		if(property == null){
			return "";
		}
		return property;
	}

	public SimpleStringProperty getFullnameProperty() {
		return fullname;
	}
	
	public String getFullname(){
		return fullname.get();
	}
	
	public void setFullname(String fullname){
		this.fullname.set(fullname);
	}

	public SimpleIntegerProperty getAgeProperty() {
		return age;
	}
	
	public int getAge(){
		return age.get();
	}
	
	public void setAge(int age){
		this.age.set(age);
	}

	public SimpleStringProperty getPhonenumberProperty() {
		return phonenumber;
	}
	
	public String getPhonenumber(){
		return phonenumber.get();
	}
	
	public void setPhonenumber(){
		this.phonenumber.set(phonenumber);
	}

	public SimpleStringProperty getPhonetypeProperty() {
		return phonetype;
	}
	
	public String getPhonetype(){
		return phonetype.get();
	}
	
	public SimpleBooleanProperty getAllowAdvertisementProperty() {
		return allowAdvertisement;
	}
	
	public SimpleStringProperty getAllowAdvertisementStringProperty() {
		if(getAllowedAdvertisement()){
			return new SimpleStringProperty("ja");
		}
		return new SimpleStringProperty("nein");
	}
	
	public boolean getAllowedAdvertisement(){
		return allowAdvertisement.get();
	}
	
	
	
	
	
	
}
