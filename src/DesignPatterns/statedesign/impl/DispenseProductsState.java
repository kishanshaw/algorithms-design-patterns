package DesignPatterns.statedesign.impl;

import DesignPatterns.statedesign.Coin;
import DesignPatterns.statedesign.Item;
import DesignPatterns.statedesign.State;
import DesignPatterns.statedesign.VendingMachine;

import java.util.List;

public class DispenseProductsState implements State {

    public DispenseProductsState() {
        System.out.println("Vending Machine is in DispenseProductState now!");
    }

    @Override
    public void clickInsertCoinButton(VendingMachine machine) {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Can't insert coin, invalid state!");
    }

    @Override
    public void clickSelectProductsButton(VendingMachine machine) throws Exception {
    }

    @Override
    public void selectProducts(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Can't select products, invalid state!");
    }

    @Override
    public Item dispenseProducts(VendingMachine machine, int codeNumber) throws Exception {
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        throw new Exception("Can't refund money, invalid state!");
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("Can't return money, invalid state!");
    }
}
