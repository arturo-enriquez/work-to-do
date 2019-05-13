package models;

import exceptions.Validations;
import exceptions.expEmptyString;
import java.util.ArrayList;

public class strProvider {
    
    private int id;
    private ArrayList<Integer> idTypeProvider;
    private String name;
    private String description;
    private String phone;
    private int idLocation;

    public strProvider(int id, ArrayList<Integer> idTypeProvider, String name, String description, String phone, int idLocation) throws expEmptyString {
        new Validations().emptyString(name);
        new Validations().emptyString(description);
        new Validations().emptyString(phone);
        this.id = id;
        this.idTypeProvider = idTypeProvider;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.idLocation = idLocation;
    }

    public int getId() {
        return id;
    }
    
    public ArrayList<Integer> getIdTypeProvider() {
        return idTypeProvider;
    }
    public String getIdTypeProviderString() {
        String string="";
        for (int x : idTypeProvider) {
            string += x + ",";
        }
        return string;
    }
    public void setIdTypeProvider(ArrayList<Integer> idTypeProvider) {
        this.idTypeProvider = idTypeProvider;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) throws expEmptyString {
        new Validations().emptyString(phone);
        this.phone = phone;
    }

    public int getIdLocation() {
        return idLocation;
    }
    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }
    
}
