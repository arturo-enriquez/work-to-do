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
import models.strWork;

public class Work {
    // Config
    private String fileName = this.getClass().getSimpleName();
    private String path = Config.getStoragePath()+this.fileName+".dat";
    
    private int nextId;
    private ArrayList<strWork> list = new ArrayList<strWork>();
    
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
        strWork obj;
        String[] ARR;
        list.clear();
        this.nextId = 0;
        int lastId = 0;
        
        while ((line = b.readLine()) != null) {
            ARR = line.split("\\|");
            String[] listId = ARR[4].toString().split(",");
            ArrayList<Integer> intListId = new ArrayList<Integer>();
            for (String x : listId) {
                intListId.add(Integer.parseInt(x));
            }
            obj = new strWork(
                    Integer.parseInt(ARR[0].toString()),
                    Integer.parseInt(ARR[1].toString()),
                    Integer.parseInt(ARR[2].toString()),
                    Integer.parseInt(ARR[3].toString()),
                    intListId,
                    ARR[5].toString(),
                    Double.parseDouble(ARR[7].toString()),
                    Double.parseDouble(ARR[9].toString())
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
        for (strWork x : list) {
            fw.write(
                    x.getId() +"|"+
                    x.getIdClient() +"|"+
                    x.getIdMaterialsForWork() +"|"+
                    x.getIdToolsForWork() +"|"+
                    x.getIdWorkersString() +"|"+
                    x.getDescription() +"|"+
                    x.getMaterialPrice() +"|"+
                    x.getLaborPrice() +"|"+
                    x.getGrossPrice() +"|"+
                    x.getTaxPrice() +"|"+
                    x.getNetPrice()
            );
            fw.write("\n");
        }
        fw.close();
    }
    
    // =============== CRUD ==================
    
    public ArrayList<strWork> getList() {
        return list;
    }
    
    public int indexId(int id) {
        int i = 0;
        for (strWork x : list) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public void create(strWork data) {
        if (data == null) throw new RuntimeException("Null Object");
         
        else list.add(data);
    }
    // Read
    public strWork searchId(int id){
        for (strWork x : list){
            if (x.getId() == id) return x;
        }
        return null; 
    }
    // Update
    public void update(strWork data) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
        
        int index = indexId(data.getId());
        list.set(index, data);
    }
    // Delete
    public void delete(int id) throws expIdNotExist {
        if (!exitsId(nextId)) throw new expIdNotExist();
    }
    
}

