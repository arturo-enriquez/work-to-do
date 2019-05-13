package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strClient {
 
    private int id;
    private String name, fatherLastName, motherLastName;
    private String phone;
    private int idLocation;
    private int idTypeClient;

    public strClient(int id, String name, String fatherLastName, String motherLastName, String phone, int idLocation, int idTypeClient) throws expEmptyString {
        new Validations().emptyString(name);
        new Validations().emptyString(fatherLastName);
        new Validations().emptyString(motherLastName);
        new Validations().emptyString(phone);
        this.id = id;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.phone = phone;
        this.idLocation = idLocation;
        this.idTypeClient = idTypeClient;
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

    public String getFatherLastName() {
        return fatherLastName;
    }
    public void setFatherLastName(String fatherLastName) throws expEmptyString {
        new Validations().emptyString(fatherLastName);
        this.fatherLastName = fatherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }
    public void setMotherLastName(String motherLastName) throws expEmptyString {
        new Validations().emptyString(motherLastName);
        this.motherLastName = motherLastName;
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

    public int getIdTypeClient() {
        return idTypeClient;
    }
    public void setIdTypeClient(int idTypeClient) {
        this.idTypeClient = idTypeClient;
    }
    
}
