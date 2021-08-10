package com.company.data;

public class Phone {

    //region Variables

    private int id;
    private String brand;
    private String model;
    private int romMemory;
    private int ramMemory;
    private String processor;
    private double price;

    //endregion

    //region Constructors

    public Phone(int id, String brand,
                 String model,
                 int romMemory,
                 int ramMemory,
                 String processor,
                 double price) {

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.romMemory = romMemory;
        this.ramMemory = ramMemory;
        this.processor = processor;
        this.price = price;
    }

    //endregion

    //region Setters

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRomMemory(int romMemory) throws Exception {
        if(romMemory <=16 || romMemory > 512){
            throw new Exception("rom memory must be grater 16gb and less 512gb");
        }
        this.romMemory = romMemory;
    }

    public void setRamMemory(int ramMemory) throws Exception {
        if(ramMemory <=1 || ramMemory > 12){
            throw new Exception("ram memory must be grater 1gb and less 12gb");
        }
        this.ramMemory = ramMemory;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //endregion

    //region Getters


    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRomMemory() {
        return romMemory;
    }

    public int getRamMemory() {
        return ramMemory;
    }

    public String getProcessor() {
        return processor;
    }

    public double getPrice() {
        return price;
    }
    //endregion
}
