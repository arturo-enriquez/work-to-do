package models;

import java.util.ArrayList;

public class strMaterialForWork {
    
    private int id;
    private ArrayList<Integer> list = new ArrayList<>();

    public strMaterialForWork(int id, ArrayList<Integer> list) {
        this.id = id;
        this.list = list;
    }

    public int getId() {
        return id;
    }
    
    public ArrayList<Integer> getList() {
        return list;
    }
    public String getListString() {
        String string="";
        for (int x : list) {
            string += x + ",";
        }
        return string;
    }
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

}
