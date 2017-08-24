package model;

import entity.Person;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PersonViewModel {

    private SimpleStringProperty fullname = new SimpleStringProperty();
    private SimpleIntegerProperty age = new SimpleIntegerProperty();
    private SimpleStringProperty phonenumber = new SimpleStringProperty();
    private SimpleStringProperty phonetype = new SimpleStringProperty();
    private SimpleBooleanProperty allowAdvertisment = new SimpleBooleanProperty();
    private Person underlayingObject;

    public PersonViewModel(Person person) {
        this.underlayingObject = person;
        setFullname(checkStringProperty(underlayingObject.getFirstname() + underlayingObject.getLastname()));
        setPhonenumber(checkStringProperty(underlayingObject.getPhonenumber()));
        setAge(underlayingObject.getAge());
        setAllowAdvertisment(underlayingObject.getAllowAdvertisment());
        setPhonetype(checkStringProperty(underlayingObject.getPhonetype()));
    }
    
    private String checkStringProperty(String property) {
        if(property == null) {
            return "";
        }
        return property;
    }
    
    public String getFullname() {
        return fullname.get();
    }
    
    public SimpleStringProperty fullnameProperty() {
        return fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname.set(fullname);
    }
    
    public Integer getAge() {
        return age.get();
    }
    
    public SimpleIntegerProperty ageProperty() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age.set(age);
    }
    
    public String getPhonenumber() {
        return phonenumber.get();
    }
    
    public SimpleStringProperty phonenumberProperty() {
        return phonenumber;
    }
    
    public void setPhonenumber(String phonenumber) {
        this.phonenumber.set(phonenumber);
    }
    
    public String getPhonetype() {
        return phonetype.get();
    }
    
    public SimpleStringProperty phonetypeProperty() {
        return phonetype;
    }
    
    public void setPhonetype(String phonetype) {
        this.phonetype.set(phonetype);
    }
    
    public boolean getAllowAdvertisment() {
        return allowAdvertisment.get();
    }
    
    public SimpleBooleanProperty allowAdvertismentProperty() {
        return allowAdvertisment;
    }
    
    public void setAllowAdvertisment(Boolean allowAdvertisment) {
        this.allowAdvertisment.set(allowAdvertisment);
    }
    
    public SimpleStringProperty allowAdvertismentStringProperty() {
        if (getAllowAdvertisment()) {
            return new SimpleStringProperty("ja");
        }
        return new SimpleStringProperty("nein");
    }
}
