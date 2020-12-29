/**
 * Created by Ashkan Amiri
 * Date:  2020-12-25
 * Time:  21:02
 * Project: bankSystemFX
 * Copyright: MIT
 */module bankSystemFX {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;

    opens sample;
    opens sample.controller;
    opens sample.account;
    opens sample.customer;
    opens sample.bankFacade;
    opens sample.database;
    opens sample.util;

}