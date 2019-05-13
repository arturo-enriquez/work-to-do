package models;

import CRUD.Material;
import CRUD.MaterialForWork;
import exceptions.Validations;
import exceptions.expEmptyString;
import java.io.IOException;
import java.util.ArrayList;

public class strWork {
    
    private int id;
    private int idClient;
    private int idMaterialsForWork;
    private int idToolsForWork;
    private ArrayList<Integer> idWorkers;
    private String description;
    // price
    private double materialPrice;
    private double laborPrice;
    private double grossPrice;
    private double taxPrice;
    private double netPrice;

    public strWork(int id, int idClient, int idMaterialsForWork, int idToolsForWork, ArrayList<Integer> idWorkers, String description, double laborPrice, double tax) throws expEmptyString, IOException {
        new Validations().emptyString(description);
        this.id = id;
        this.idClient = idClient;
        this.idMaterialsForWork = idMaterialsForWork;
        this.idToolsForWork = idToolsForWork;
        this.idWorkers = idWorkers;
        this.description = description;
        this.materialPrice = getTotalMaterialPrice();
        this.laborPrice = laborPrice;
        this.grossPrice = this.laborPrice+this.materialPrice;
        this.taxPrice = grossPrice*(tax*.01);
        this.netPrice = grossPrice+taxPrice;
    }
    
    public double getTotalMaterialPrice() throws IOException, expEmptyString{
        MaterialForWork mfw = new MaterialForWork();
        mfw.LoadFromFile();
        Material material = new Material();
        material.LoadFromFile();
        double price = 0;
        mfw.searchId(id);
        for (int x : mfw.searchId(id).getList()) {
            price += material.searchId(x).getPrice();
        }
        return price;
    }

    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdMaterialsForWork() {
        return idMaterialsForWork;
    }

    public void setIdMaterialsForWork(int idMaterialsForWork) {
        this.idMaterialsForWork = idMaterialsForWork;
    }

    public int getIdToolsForWork() {
        return idToolsForWork;
    }

    public void setIdToolsForWork(int idToolsForWork) {
        this.idToolsForWork = idToolsForWork;
    }

    public ArrayList<Integer> getIdWorkers() {
        return idWorkers;
    }
    public String getIdWorkersString() {
        String string="";
        for (int x : idWorkers) {
            string += x + ",";
        }
        return string;
    }

    public void setIdWorkers(ArrayList<Integer> idWorkers) {
        this.idWorkers = idWorkers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(double materialPrice) {
        this.materialPrice = materialPrice;
    }

    public double getLaborPrice() {
        return laborPrice;
    }

    public void setLaborPrice(double laborPrice) {
        this.laborPrice = laborPrice;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(double taxPrice) {
        this.taxPrice = taxPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }
    
    
    
    
    
    
}
