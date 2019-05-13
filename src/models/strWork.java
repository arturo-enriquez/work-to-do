package models;

import exceptions.Validations;
import exceptions.expEmptyString;
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

    public strWork(int id, int idClient, int idMaterialsForWork, int idToolsForWork, ArrayList<Integer> idWorkers, String description, double laborPrice) throws expEmptyString {
        new Validations().emptyString(description);
        this.id = id;
        this.idClient = idClient;
        this.idMaterialsForWork = idMaterialsForWork;
        this.idToolsForWork = idToolsForWork;
        this.idWorkers = idWorkers;
        this.description = description;
        
        this.materialPrice = 0; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        this.laborPrice = laborPrice;
        this.grossPrice = laborPrice+materialPrice;
        this.taxPrice = grossPrice*taxPrice;
        this.netPrice = grossPrice+taxPrice;
    }

    
    
    
    
}
