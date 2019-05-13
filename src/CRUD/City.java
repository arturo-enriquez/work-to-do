package CRUD;

import exceptions.expEmptyString;
import exceptions.expIdNotExist;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import models.strCity;

public class City {
    // Config
    private String fileName = this.getClass().getSimpleName();
    private String path = "C:\\DB_NAME\\"+this.fileName+".dat";
    
    private int nextId;
    private ArrayList<strCity> list = new ArrayList<strCity>();
    
    // Get next ID
    public int getNextId(){
        this.nextId++;
        return nextId;
    }
    
    // Load data from the file
    public void LoadFromFile() throws IOException, expEmptyString {
        String line;
        FileReader file = new FileReader(path);
        BufferedReader b = new BufferedReader(file);
        strCity obj;
        String[] ARR;
        list.clear();
        this.nextId = 0;
        int lastId = 0;
        
        while ((line = b.readLine()) != null) {
            ARR = line.split("\\|");
            obj = new strCity(
                    Integer.parseInt(ARR[0].toString()),
                    ARR[1].toString(),
                    Integer.parseInt(ARR[2].toString())
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
        for (strCity x : list) {
            fw.write(
                    x.getId() + "|"+
                    x.getName() +"|"+
                    x.getIdState()
            );
            fw.write("\n");
        }
        fw.close();
    }
    
    // =============== CRUD ==================
    
    public ArrayList<strCity> getList() {
        return list;
    }
    
    public int indexId(int id) {
        strCity[] arr = null;
        list.toArray(arr);
        int i = 0;
        for (strCity x : arr) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public void create(strCity data) {
        if (data == null) throw new RuntimeException("Null Object");
         
        else list.add(data);
    }
    // Read
    public strCity searchId(int id){
        for (strCity x : list){
            if (x.getId() == id) return x;
        }
        return null; 
    }
    // Update
    public void update(strCity data) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        
        int index = indexId(data.getId());
        list.set(index, data);
    }
    // Delete
    public void delete(int id) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
    }
    
}
