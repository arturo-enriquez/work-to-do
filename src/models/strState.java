package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strState {
    
    private int id;
    private String name;
    private int idCountry;

    public strState(int id, String name, int idCountry) throws expEmptyString {
        new Validations().emptyString(name);
        this.id = id;
        this.name = name;
        this.idCountry = idCountry;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) throws expEmptyString {
        new Validations().emptyString(name);
        this.name = name;
    }

    public int getIdCountry() {
        return idCountry;
    }
    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }
    
}
