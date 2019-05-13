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
import models.strProvider;

public class Provider {
    // Config
    private String fileName = this.getClass().getSimpleName();
    private String path = Config.getStoragePath()+this.fileName+".dat";
    
    private int nextId;
    private ArrayList<strProvider> list = new ArrayList<strProvider>();
    
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
        strProvider obj;
        String[] ARR;
        list.clear();
        this.nextId = 0;
        int lastId = 0;
        
        while ((line = b.readLine()) != null) {
            ARR = line.split("\\|");
            String[] listId = ARR[1].toString().split(",");
            ArrayList<Integer> intListId = new ArrayList<Integer>();
            for (String x : listId) {
                intListId.add(Integer.parseInt(x));
            }
            obj = new strProvider(
                    Integer.parseInt(ARR[0].toString()),
                    intListId,
                    ARR[2].toString(),
                    ARR[3].toString(),
                    ARR[4].toString(),
                    Integer.parseInt(ARR[5].toString())
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
        for (strProvider x : list) {
            fw.write(
                    x.getId() +"|"+
                    x.getIdTypeProviderString() +"|"+
                    x.getName() +"|"+
                    x.getDescription() +"|"+
                    x.getPhone() +"|"+
                    x.getIdLocation()
            );
            fw.write("\n");
        }
        fw.close();
    }
    
    // =============== CRUD ==================
    
    public ArrayList<strProvider> getList() {
        return list;
    }
    
    public int indexId(int id) {
        strProvider[] arr = null;
        list.toArray(arr);
        int i = 0;
        for (strProvider x : arr) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public void create(strProvider data) {
        if (data == null) throw new RuntimeException("Null Object");
         
        else list.add(data);
    }
    // Read
    public strProvider searchId(int id){
        for (strProvider x : list){
            if (x.getId() == id) return x;
        }
        return null; 
    }
    // Update
    public void update(strProvider data) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        
        int index = indexId(data.getId());
        list.set(index, data);
    }
    // Delete
    public void delete(int id) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
    }
    
}
