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
import models.strTool;

public class Tool {
    // Settings
    private String fileName = this.getClass().getSimpleName();
    private String path = Config.getStoragePath()+this.fileName+".dat";
    
    private int nextId;
    private ArrayList<strTool> list = new ArrayList<strTool>();
    
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
        strTool obj;
        String[] ARR;
        list.clear();
        this.nextId = 0;
        int lastId = 0;
        while ((line = b.readLine()) != null) {
            ARR = line.split("\\|");
            obj = new strTool(
                    Integer.parseInt(ARR[0].toString()),
                    Integer.parseInt(ARR[1].toString()),
                    ARR[2].toString(),
                    ARR[3].toString(),
                    ARR[4].toString()
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
        for (strTool x : list) {
            fw.write(
                    x.getId() +"|"+
                    x.getIdProvider() +"|"+
                    x.getName() +"|"+
                    x.getDescription() +"|"+
                    x.getCapacity()
            );
            fw.write("\n");
        }
        fw.close();
    }
    
    // =============== CRUD ==================
    
    public ArrayList<strTool> getList() {
        return list;
    }
    
    public int indexId(int id) {
        strTool[] arr = null;
        list.toArray(arr);
        int i = 0;
        for (strTool x : arr) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public void create(strTool data) {
        if (data == null) throw new RuntimeException("Null Object");
         
        else list.add(data);
    }
    // Read
    public strTool searchId(int id){
        for (strTool x : list){
            if (x.getId() == id) return x;
        }
        return null; 
    }
    // Update
    public void update(strTool data) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        
        int index = indexId(data.getId());
        list.set(index, data);
    }
    // Delete
    public void delete(int id) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
    }
    
}
