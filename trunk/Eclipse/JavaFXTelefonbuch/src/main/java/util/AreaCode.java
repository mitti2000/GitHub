package util;

public enum AreaCode {

    SWITZERLAND("+41", "Schweiz"),
    GERMANY("+49", "Deutschland"),
    AZERBAIJAN("+994", "Aserbaidschan"),
    AUSTRIA("+43", "Österreich"),
    IVORYCOAST("+225", "Elfenbeinküste"),
    BURKINAFASO("+226", "Burkina Faso");
    
    private String areaCode;
    private String name;
    
    private AreaCode(String areaCode, String name) {
        this.areaCode = areaCode;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.areaCode + " (" + this.name  +")";
    }
    
    public String getAreaCode() {
        return areaCode;
    }
}
