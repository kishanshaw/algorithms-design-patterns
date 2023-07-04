package DesignPatterns.statedesign.impl;

import DesignPatterns.statedesign.Coin;
import DesignPatterns.statedesign.Item;
import DesignPatterns.statedesign.State;
import DesignPatterns.statedesign.VendingMachine;

import java.util.List;

public class CollectMoneyState implements State {

    public CollectMoneyState() {
        System.out.println("Vending Machine is in CollectMoneyState now!");
    }

    @Override
    public void clickInsertCoinButton(VendingMachine machine) throws Exception {
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        machine.getCoins().add(coin);
    }

    @Override
    public void clickSelectProductsButton(VendingMachine machine) {
        machine.setVendingMachineState(new SelectProductsState());
    }

    @Override
    public void selectProducts(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Can't select products now!");
    }

    @Override
    public Item dispenseProducts(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Can't dispense products now!");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) {
        machine.setVendingMachineState(new IdleState());
        return machine.getCoins();
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("invalid method when machine is in Collect money state");
    }
}
