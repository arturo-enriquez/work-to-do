package CRUD;

import exceptions.expEmptyString;
import exceptions.expIdNotExist;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import models.strClient;

public class Client {
  // Config
    private String fileName = this.getClass().getSimpleName();
    private String path = "C:\\DB_NAME\\"+this.fileName+".dat";
    
    private int nextId;
    private ArrayList<strClient> list = new ArrayList<strClient>();
    
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
        strClient obj;
        String[] ARR;
        list.clear();
        this.nextId = 0;
        int lastId = 0;
        
        while ((line = b.readLine()) != null) {
            ARR = line.split("\\|");
            obj = new strClient(
                    Integer.parseInt(ARR[0].toString()),
                    ARR[1].toString(),
                    ARR[2].toString(),
                    ARR[3].toString(),
                    ARR[4].toString(),
                    Integer.parseInt(ARR[5].toString()),
                    Integer.parseInt(ARR[6].toString())
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
        for (strClient x : list) {
            fw.write(
                    x.getId() + "|"+
                    x.getName() +"|"+
                    x.getFatherLastName() +"|"+
                    x.getMotherLastName() +"|"+
                    x.getPhone() +"|"+
                    x.getIdLocation() +"|"+
                    x.getIdTypeClient()
            );
            fw.write("\n");
        }
        fw.close();
    }
    
    // =============== CRUD ==================
    
    public ArrayList<strClient> getList() {
        return list;
    }
    
    public int indexId(int id) {
        strClient[] arr = null;
        list.toArray(arr);
        int i = 0;
        for (strClient x : arr) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public void create(strClient data) {
        if (data == null) throw new RuntimeException("Null Object");
         
        else list.add(data);
    }
    // Read
    public strClient searchId(int id){
        for (strClient x : list){
            if (x.getId() == id) return x;
        }
        return null; 
    }
    // Update
    public void update(strClient data) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        
        int index = indexId(data.getId());
        list.set(index, data);
    }
    // Delete
    public void delete(int id) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
    }
    
}

