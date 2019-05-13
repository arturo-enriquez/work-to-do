package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strMaterial {
    
    private int id;
    private int idProvider;
    private String description;
    private String measure;
    private String unity;
    private double quantity;
    private double price;

    public strMaterial(int id, int idProvider, String description, String measure, String unity, double quantity, double price) throws expEmptyString {
        new Validations().emptyString(description);
        new Validations().emptyString(measure);
        new Validations().emptyString(unity);
        this.id = id;
        this.idProvider = idProvider;
        this.description = description;
        this.measure = measure;
        this.unity = unity;
        this.quantity = quantity;
        this.price = price;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) throws expEmptyString {
        new Validations().emptyString(description);
        this.description = description;
    }

    public String getMeasure() {
        return measure;
    }
    public void setMeasure(String measure) throws expEmptyString {
        new Validations().emptyString(measure);
        this.measure = measure;
    }

    public String getUnity() {
        return unity;
    }
    public void setUnity(String unity) throws expEmptyString {
        new Validations().emptyString(unity);
        this.unity = unity;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
