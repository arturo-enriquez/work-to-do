package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strTool {

    private int id;
    private int idProvider;
    private String name;
    private String description;
    private String capacity;

    public strTool(int id, int idProvider, String name, String description, String capacity) throws expEmptyString {
        new Validations().emptyString(name);
        new Validations().emptyString(description);
        new Validations().emptyString(capacity);
        this.id = id;
        this.idProvider = idProvider;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getIdProvider() {
        return idProvider;
    }
    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) throws expEmptyString {
        new Validations().emptyString(name);
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) throws expEmptyString {
        new Validations().emptyString(description);
        this.description = description;
    }

    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) throws expEmptyString {
        new Validations().emptyString(capacity);
        this.capacity = capacity;
    }
    
}
