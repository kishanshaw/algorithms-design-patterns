package DesignPatterns.statedesign;

import java.util.List;

public interface State {
    void clickInsertCoinButton(VendingMachine machine) throws Exception;

    void insertCoin(VendingMachine machine, Coin coin) throws Exception;

    void clickSelectProductsButton(VendingMachine machine) throws Exception;

    void selectProducts(VendingMachine machine, int codeNumber) throws Exception;

    Item dispenseProducts(VendingMachine machine, int codeNumber) throws Exception;

    List<Coin> refundMoney(VendingMachine machine) throws Exception;

    int getChange(int returnMoney) throws Exception;
}
