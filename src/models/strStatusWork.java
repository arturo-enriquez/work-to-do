package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strStatusWork {
    
    private int id;
    private String status;

    public strStatusWork(int id, String status) throws expEmptyString {
        new Validations().emptyString(status);
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) throws expEmptyString {
        new Validations().emptyString(status);
        this.status = status;
    }

}
