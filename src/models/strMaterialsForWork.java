package models;

import java.util.ArrayList;

public class strMaterialsForWork {
    
    private int id;
    private ArrayList<Integer> list = new ArrayList<>();

    public strMaterialsForWork(int id, ArrayList<Integer> list) {
        this.id = id;
        this.list = list;
    }

    public int getId() {
        return id;
    }
    
    public ArrayList<Integer> getList() {
        return list;
    }
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

}