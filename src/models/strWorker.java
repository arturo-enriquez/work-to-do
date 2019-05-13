package models;

import exceptions.Validations;
import exceptions.expEmptyString;

public class strWorker {

    private int id;
    private int idTypeWorker;
    private String name, fatherLastName, motherLastName;
    private String phone;
    private int idLocation;

    public strWorker(int id, int idTypeWorker, String name, String fatherLastName, String motherLastName, String phone, int idLocation) throws expEmptyString {
        new Validations().emptyString(name);
        new Validations().emptyString(fatherLastName);
        new Validations().emptyString(motherLastName);
        new Validations().emptyString(phone);
        this.id = id;
        this.idTypeWorker = idTypeWorker;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.phone = phone;
        this.idLocation = idLocation;
    }

    public int getId() {
        return id;
    }

    public int getIdTypeWorker() {
        return idTypeWorker;
    }
    public void setIdTypeWorker(int idTypeWorker) {
        this.idTypeWorker = idTypeWorker;
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

}
