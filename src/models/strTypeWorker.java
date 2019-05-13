package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strTypeWorker {
    
    private int id;
    private String description;

    public strTypeWorker(int id, String description) throws expEmptyString {
        new Validations().emptyString(description);
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) throws expEmptyString {
        new Validations().emptyString(description);
        this.description = description;
    }

}
