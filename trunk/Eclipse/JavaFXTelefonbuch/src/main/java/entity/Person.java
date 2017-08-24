package entity;

public class Person {

    private String firstname;
    private String lastname;
    private Integer age = 0;
    private String phonenumber;
    private String phonetype;
    private Boolean allowAdvertisment = false;
    
    public Person(String firstname, String lastname, String phonenumber) {
        setFirstname(firstname);
        setLastname(lastname);
        setPhonenumber(phonenumber);
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getPhonetype() {
        return phonetype;
    }
    
    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }
    
    public boolean getAllowAdvertisment() {
        return allowAdvertisment;
    }
    
    public void setAllowAdvertisment(Boolean allowAdvertisment) {
        this.allowAdvertisment = allowAdvertisment;
    }
}