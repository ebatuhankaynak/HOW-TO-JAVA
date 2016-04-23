package com.mocha.client.controllers;

import javafx.scene.control.TreeItem;

/**
 * Created by E.Batuhan Kaynak on 8.4.2016.
 */

public class BreadCrumbSetting {

    TreeItem<String> mainMenu;
    TreeItem<String> practiceLeaf;
    TreeItem<String> profileLeaf;
    TreeItem<String> diagnosticTestLeaf;
    TreeItem<String> shopLeaf;
    TreeItem<String> OptionsLeaf;
    TreeItem<String> dataTypesLeaf;
    TreeItem<String> methodsLeaf;

    public BreadCrumbSetting(){
        mainMenu = new TreeItem<String>("mainMenu");
        practiceLeaf = new TreeItem<String>("Practice");
        profileLeaf = new TreeItem<String>("Profile");
        diagnosticTestLeaf = new TreeItem<String>("DiagnosticTest");
        shopLeaf = new TreeItem<String>("Shop");
        OptionsLeaf = new TreeItem<String>("Options");

        //Topic Menu Leafs
        dataTypesLeaf = new TreeItem<String>("DataTypes");
        methodsLeaf = new TreeItem<String>("Methods");

        practiceLeaf.getChildren().addAll(dataTypesLeaf, methodsLeaf);
    }
}
