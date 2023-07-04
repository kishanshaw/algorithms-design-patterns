package DesignPatterns.statedesign.impl;

import DesignPatterns.statedesign.Coin;
import DesignPatterns.statedesign.Item;
import DesignPatterns.statedesign.State;
import DesignPatterns.statedesign.VendingMachine;

import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Vending Machine is in IdleState now!");
    }

    @Override
    public void clickInsertCoinButton(VendingMachine machine) {
        machine.setVendingMachineState(new CollectMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Vending Machine is in idle state! Can't insert coin");
    }

    @Override
    public void clickSelectProductsButton(VendingMachine machine) throws Exception {
        throw new Exception("Vending Machine is in idle state! Can't select products");
    }

    @Override
    public void selectProducts(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Vending Machine is in idle state! Can't proceed to products selection");
    }

    @Override
    public Item dispenseProducts(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Vending Machine is in idle state! Can't dispense products");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        throw new Exception("Vending Machine is in idle state! Can't refund money");
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("Vending Machine is in idle state! Can't proceed");
    }
}
