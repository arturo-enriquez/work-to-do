package CRUD;

import config.Config;
import exceptions.expEmptyString;
import exceptions.expIdNotExist;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import models.strMaterial;

public class Material {
    // Config
    private String fileName = this.getClass().getSimpleName();
    private String path = Config.getStoragePath()+this.fileName+".dat";
    
    private int nextId;
    private ArrayList<strMaterial> list = new ArrayList<strMaterial>();
    
    // Get next ID
    public int getNextId(){
        this.nextId++;
        return nextId;
    }
    
    // Load data from the file
    public void LoadFromFile() throws IOException, expEmptyString {
        if (!(new File(path).exists())) return;
        FileReader file = new FileReader(path);
        BufferedReader b = new BufferedReader(file);
        String line;
        strMaterial obj;
        String[] ARR;
        list.clear();
        this.nextId = 0;
        int lastId = 0;
        
        while ((line = b.readLine()) != null) {
            ARR = line.split("\\|");
            obj = new strMaterial(
                    Integer.parseInt(ARR[0].toString()),
                    Integer.parseInt(ARR[1].toString()),
                    ARR[2].toString(),
                    ARR[3].toString(),
                    ARR[4].toString(),
                    Double.parseDouble(ARR[5].toString()),
                    Double.parseDouble(ARR[6].toString())
            );
            lastId = Integer.parseInt(ARR[0].toString());
            nextId = (lastId> nextId) ? lastId : nextId;
            list.add(obj);
        }
        b.close();
    }
    // Save to file
    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter(path);
        for (strMaterial x : list) {
            fw.write(
                    x.getId() +"|"+
                    x.getIdProvider() +"|"+
                    x.getDescription() +"|"+
                    x.getMeasure() +"|"+
                    x.getUnity() +"|"+
                    x.getQuantity() +"|"+
                    x.getPrice()
            );
            fw.write("\n");
        }
        fw.close();
    }
    
    // =============== CRUD ==================
    
    public ArrayList<strMaterial> getList() {
        return list;
    }
    
    public int indexId(int id) {
        int i = 0;
        for (strMaterial x : list) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public void create(strMaterial data) {
        if (data == null) throw new RuntimeException("Null Object");
         
        else list.add(data);
    }
    // Read
    public strMaterial searchId(int id){
        for (strMaterial x : list){
            if (x.getId() == id) return x;
        }
        return null; 
    }
    // Update
    public void update(strMaterial data) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        
        int index = indexId(data.getId());
        list.set(index, data);
    }
    // Delete
    public void delete(int id) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        int index = indexId(id);
        list.remove(index);
    }
    
}

