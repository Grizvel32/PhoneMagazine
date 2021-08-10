package com.company;

import com.company.data.CatalogManager;
import com.company.view.MenuManager;

public class Main {

    public static void main(String[] args) throws Exception {
        CatalogManager catalogManager = new CatalogManager();
        catalogManager.fillCatalogWithPhones();

        MenuManager menuManager = new MenuManager(catalogManager);
        menuManager.execute();
    }
}
