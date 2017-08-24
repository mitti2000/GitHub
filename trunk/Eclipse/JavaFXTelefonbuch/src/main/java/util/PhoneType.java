package util;

public enum PhoneType {

    MOBILE("Mobil"),
    PRIVATE("Privat"),
    BUSINESS("Geschäftlich");
    
    private String name;
    
    private PhoneType(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
