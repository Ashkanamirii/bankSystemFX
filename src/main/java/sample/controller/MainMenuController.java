package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-28
 * Time:  18:42
 * Project: bankSystemFX
 * Copyright: MIT
 */
public class MainMenuController {
    public JFXButton buttonAccount;
    public JFXButton buttonBalance;
    public JFXButton buttonToggle;
    public TabPane mainTabPane;
    public Tab tabHome;
    public JFXButton buttonSend;
    public JFXButton buttonMobileRecharge;
    public JFXButton buttonCashOut;
    public JFXButton buttonPayBill;
    public JFXButton buttonAddMoney;
    public JFXButton buttonDonate;
    public Tab tabTransactions;
    public ListView listTransaction;
    public JFXButton buttonTransactionAll;
    public JFXButton buttonTransactionIn;
    public JFXButton buttonTransactionOut;
    public JFXButton buttonTransactionMore;
    public Tab tabNotification;
    public JFXListView listNotification;
    public JFXDrawer optionDrawer;
    public Pane drawerContainer;

    public void showProfile(ActionEvent event) {
    }

    public void showBalance(ActionEvent event) {
    }

    public void toggleDrawer(ActionEvent event) {
    }

    public void sendMoney(ActionEvent event) {
    }

    public void mobileRecharge(ActionEvent event) {
    }

    public void cashOut(ActionEvent event) {
    }

    public void payBill(ActionEvent event) {
    }

    public void bankTransfer(ActionEvent event) {
    }

    public void donateMoney(ActionEvent event) {
    }

    public void showTransactionAll(ActionEvent event) {
    }

    public void showTransactionIn(ActionEvent event) {
    }

    public void showTransactionOut(ActionEvent event) {
    }

    public void loadMoreTransaction(ActionEvent event) {
    }

    public void logOut(ActionEvent event) {
    }

    public void exitAkash(ActionEvent event) {
    }
}
