package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strLocation {

    private int id;
    private String street;
    private String betweenStreets;
    private String postalCode;
    private int idCity;

    public strLocation(int id, String street, String betweenStreets, String postalCode, int idCity) throws expEmptyString {
        new Validations().emptyString(street);
        new Validations().emptyString(betweenStreets);
        new Validations().emptyString(postalCode);
        this.id = id;
        this.street = street;
        this.betweenStreets = betweenStreets;
        this.postalCode = postalCode;
        this.idCity = idCity;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) throws expEmptyString {
        new Validations().emptyString(street);
        this.street = street;
    }

    public String getBetweenStreets() {
        return betweenStreets;
    }
    public void setBetweenStreets(String betweenStreets) throws expEmptyString {
        new Validations().emptyString(betweenStreets);
        this.betweenStreets = betweenStreets;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) throws expEmptyString {
        new Validations().emptyString(postalCode);
        this.postalCode = postalCode;
    }

    public int getIdCity() {
        return idCity;
    }
    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }
    
    
    
}
