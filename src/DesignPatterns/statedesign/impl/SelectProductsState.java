package DesignPatterns.statedesign.impl;

import DesignPatterns.statedesign.*;

import java.util.List;
import java.util.Objects;

public class SelectProductsState implements State {

    public SelectProductsState() {
        System.out.println("Vending Machine is in SelectProductState now!");
    }

    @Override
    public void clickInsertCoinButton(VendingMachine machine) throws Exception {
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
        ItemSelf[] itemSelves = machine.getInventory().getItemSelves();
        Item item = null;
        for (ItemSelf itemSelf : itemSelves) {
            if (itemSelf.getCodeNumber() == codeNumber) {
                if (!itemSelf.isOccupied()) {
                    throw new Exception("Item is not available!");
                } else {
                    item = itemSelf.getItem();
                    break;
                }
            }
        }
        if (Objects.isNull(item)) {
            throw new Exception("item not found, code looks invalid");
        }
        int amountPaid = machine.getCoins().stream().mapToInt(Coin::getValue).sum();
        if (amountPaid < item.getPrice()) {
            System.out.println("Insufficient amount, please enter correct coins!");
            refundMoney(machine);
            throw new Exception("Insufficient amount!");
        } else if (amountPaid >= item.getPrice()) {
            if (amountPaid > item.getPrice()) {
                System.out.println("Returning the extra money " + (amountPaid - item.getPrice()) + " in the change tray!");
                getChange(amountPaid - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseProductsState());
        }

    }

    @Override
    public Item dispenseProducts(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Can't dispense product, invalid state!");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine machine) throws Exception {
        return machine.getCoins();
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        return returnMoney;
    }
}
