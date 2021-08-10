package com.company.view;

import com.company.data.CatalogManager;
import com.company.data.Phone;
import com.company.utils.ConsoleHelper;

import java.util.ArrayList;

public class MenuManager {

    //region Fields

    private CatalogManager catalogManager;

    //endregion

    //region Constructor

    public MenuManager(CatalogManager catalogManager) {
        this.catalogManager = catalogManager;
    }
    //endregion

    //region Private Methods

    private void printPhones() {
        ArrayList<Phone> phones = catalogManager.getPhones();
        if (phones.size() == 0) {
            ConsoleHelper.printlnMessage("Список пуст");
            ConsoleHelper.printlnMessage("=====");
            return;
        }

        String tableHeader = String.format("%-5s%-10s%-10s%-15s%-14s%-10s%-7s", "ИД", "Бренд", "Модель", "Объём памяти(Гб)", "Объём ОЗУ (Гб)", "Процессор","Цена");

        ConsoleHelper.printlnMessage(tableHeader);

        for (int i = 0; i < phones.size(); i++) {

            Phone currentPhone = phones.get(i);

            String tableCurrentRow = String.format("%-5d%-10d%-10d%--5s%-5s%-10s-9f", currentPhone.getId(), currentPhone.getBrand(),
                    currentPhone.getModel(), currentPhone.getRomMemory(), currentPhone.getRamMemory(), currentPhone.getPrice());

            ConsoleHelper.printlnMessage(tableCurrentRow);
        }

        ConsoleHelper.printlnMessage("=====");
    }

    //endregion

    //region Public Methods

    public void execute() throws Exception {
        int action = -1;
        boolean isRun = true;

        while (isRun) {

            printPhones();

            ConsoleHelper.printlnMessage("Меню:");
            ConsoleHelper.printlnMessage("1. Добавить новый телефон в каталог");
            ConsoleHelper.printlnMessage("2. Удалить телефон по ИД");
            ConsoleHelper.printlnMessage("3. Загрузить каталог телефонов из файла");
            ConsoleHelper.printlnMessage("4. Сохранить каталог телефонов в файл");
            ConsoleHelper.printlnMessage("5. Изменить цену телефона по ИД");
            ConsoleHelper.printlnMessage("6. Изменить бренд телефона по ИД");
            ConsoleHelper.printlnMessage("7. Изменить модель телефона по ИД");
            ConsoleHelper.printlnMessage("8. Изменить кол-во внутренней памяти телефона по ИД");
            ConsoleHelper.printlnMessage("9. Изменить кол-во оперативной памяти телефона по ИД");
            ConsoleHelper.printlnMessage("10. Изменить процессор телефона по ИД");
            ConsoleHelper.printlnMessage("0. Выход");

            action = ConsoleHelper.inputInt("Введите номер пункта меню: ", 0, 7);

            switch (action) {
                case 1: {
                    String brand = ConsoleHelper.inputString("введите бренд телефона: ");
                    String model = ConsoleHelper.inputString("введите модель телефона: ");
                    int romMemory = ConsoleHelper.inputInt("Введите количество внутренней памяти: ");
                    int ramMemory = ConsoleHelper.inputInt("Введите количество оперативной памяти: ");
                    String cpu = ConsoleHelper.inputString("Введите наименование процессора в телефоне: ");
                    double price = ConsoleHelper.inputDouble("Введите стоимость телефона(руб): ");


                    catalogManager.addNewPhone(brand, model, romMemory, ramMemory, cpu, price);
                }
                break;

                case 2: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для удаления: ");
                        catalogManager.deletePhoneById(id);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 3: {
                    try {
                        String fileName = ConsoleHelper.inputString("Введите имя файла для загрузки данных: ");
                        catalogManager.loadFromDataFile(fileName);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 4: {
                    try {
                        String fileName = ConsoleHelper.inputString("Введите имя файла для сохранения данных: ");
                        catalogManager.saveToDataFile(fileName);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 5: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для изменения цены: ");
                        double price = ConsoleHelper.inputDouble("Введите цену(руб): ");

                        catalogManager.setNewPhonePriceById(id, price);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 6: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для изменения бренда: ");
                        String brand = ConsoleHelper.inputString("Введите наименование бренда: ");

                        catalogManager.setNewPhoneBrandById(id, brand);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 7: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для изменения модели: ");
                        String model = ConsoleHelper.inputString("Введите модель телефона: ");

                        catalogManager.setNewPhoneModelById(id, model);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 8: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для изменения модели: ");
                        int romMemory = ConsoleHelper.inputInt("Введите внутреннюю память телефона: ");

                        catalogManager.setNewPhoneRomMemoryById(id, romMemory);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 9: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для изменения модели: ");
                        int ramMemory = ConsoleHelper.inputInt("Введите оперативную память телефона: ");

                        catalogManager.setNewPhoneRamMemoryById(id, ramMemory);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;

                case 10: {
                    try {
                        int id = ConsoleHelper.inputInt("Введите ИД телефона для изменения модели: ");
                        String cpu = ConsoleHelper.inputString("Введите процессор телефона: ");

                        catalogManager.setNewPhoneCPUById(id, cpu);
                    } catch (Exception e) {
                        ConsoleHelper.printlnMessage(e.getMessage());
                    }
                }
                break;
                case 0: {
                    isRun = false;
                }
                break;
            }
        }
    }

    //endregion
}


