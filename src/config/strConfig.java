package config;

public class strConfig {
    
    private String workshopName;
    private String storagePath;
    private double IVA;

    public strConfig(String workshopName, String storagePath, double IVA) {
        this.workshopName = workshopName;
        this.storagePath = storagePath;
        this.IVA = IVA;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    
    
}
