package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strCountry {
    
    private int id;
    private String name;

    public strCountry(int id, String name) throws expEmptyString {
        new Validations().emptyString(name);
        this.id = id;
        this.name = name;
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
    
    
    
}
