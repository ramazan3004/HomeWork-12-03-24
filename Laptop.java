import java.util.*;

class Laptop {
    private String brand;
    private int RAM;
    private int storageSize;
    private String operatingSystem;
    private String color;

    public Laptop(String brand, int RAM, int storageSize, String operatingSystem, String color) {
        this.brand = brand;
        this.RAM = RAM;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}

