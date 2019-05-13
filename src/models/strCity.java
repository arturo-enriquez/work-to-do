package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strCity {
    
    private int id;
    private String name;
    private int idState;

    public strCity(int id, String name, int idState) throws expEmptyString {
        new Validations().emptyString(name);
        this.id = id;
        this.name = name;
        this.idState = idState;
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

    public int getIdState() {
        return idState;
    }
    public void setIdState(int idState) {
        this.idState = idState;
    }
    
    

}
