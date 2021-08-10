package com.company.data;

import java.io.*;
import java.util.ArrayList;

public class CatalogManager {

    //region Fields

    private int currentId;
    private ArrayList<Phone> phones;
    //endregion

    //region Constructor

    public CatalogManager() {

        currentId = 0;
        phones = new ArrayList<>();
    }

    //endregion

    //region Private Methods

    private int findIndexById(int id) {
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getId() == id) {
                return i;
            }

        }
        return -1;
    }

    private int getMaxId() {
        int maxId = 0;
        for (int i = 0; i < phones.size(); i++) {

            int currentId = phones.get(i).getId();

            if (currentId > maxId) {
                maxId = currentId;
            }
        }
        return maxId;
    }

    //endregion

    //region Public Methods

    public void addNewPhone(String brand,
                            String model,
                            int romMemory,
                            int ramMemory,
                            String processor,
                            double price) {

        currentId++;

        Phone phone = new Phone(currentId, brand, model, romMemory, ramMemory, processor, price);

        phones.add(phone);
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void deletePhoneById(int id) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        phones.remove(index);
    }

    public void setNewPhoneBrandById(int id, String brand) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        Phone findPhone = phones.get(index);


        findPhone.setBrand(brand);
    }

    public void setNewPhoneModelById(int id, String model) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        Phone findPhone = phones.get(index);


        findPhone.setModel(model);
    }

    public void setNewPhoneRomMemoryById(int id, int romMemory) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        Phone findPhone = phones.get(index);


        findPhone.setRomMemory(romMemory);
    }

    public void setNewPhoneRamMemoryById(int id, int ramMemory) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        Phone findPhone = phones.get(index);


        findPhone.setRomMemory(ramMemory);
    }

    public void setNewPhoneCPUById(int id, String cpu) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        Phone findPhone = phones.get(index);


        findPhone.setProcessor(cpu);
    }

    public void setNewPhonePriceById(int id, double price) throws Exception {
        int index = findIndexById(id);

        if (index == -1) {
            throw new Exception("Телефон с таким ID не найден");
        }

        Phone findPhone = phones.get(index);

        if (price < 0) {
            throw new Exception("Некорректная цена");
        }

        findPhone.setPrice(price);
    }

    public void fillCatalogWithPhones() {
        currentId = 0;
        phones = new ArrayList<>();

        addNewPhone("Samsung", "Galaxy S10", 128, 8, "Exynos 9820", 59900);
        addNewPhone("Xiaomi", "Mi 10T Pro", 256, 8, "Snapdragon 865", 45950);
        addNewPhone("Iphone", "11", 128, 4, "A13 Bionic", 51000);
    }

    public void saveToDataFile(String fileName) throws Exception {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(phones);
        } catch (Exception e) {
            throw e;

        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void loadFromDataFile(String fileName) throws Exception {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));

            phones = (ArrayList<Phone>) inputStream.readObject();

            currentId = getMaxId();

        } catch (Exception e) {
            throw e;

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
    //endregion
}

