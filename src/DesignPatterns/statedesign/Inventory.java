package DesignPatterns.statedesign;

public class Inventory {
    private ItemSelf[] itemSelves;

    public Inventory(int numberOfItems) {
        itemSelves = new ItemSelf[numberOfItems];
        initiateEmptyInventory();
    }

    public ItemSelf[] getItemSelves() {
        return itemSelves;
    }

    public void setItemSelves(ItemSelf[] itemSelves) {
        this.itemSelves = itemSelves;
    }

    private void initiateEmptyInventory() {
        int noOfItems = itemSelves.length;
        int startCode = 100;
        for (int i = 0; i < noOfItems; i++) {
            ItemSelf itemSelf = new ItemSelf();
            Item item = new Item();
            if (i < 3) {
                item.setItemType(ItemType.COKE);
                item.setPrice(20);
            } else if (i < 6) {
                item.setItemType(ItemType.PEPSI);
                item.setPrice(20);
            } else if (i < 9) {
                item.setItemType(ItemType.SODA);
                item.setPrice(10);
            } else {
                item.setItemType(ItemType.WATER);
                item.setPrice(30);
            }
            itemSelf.setItem(item);
            itemSelf.setOccupied(true);
            itemSelf.setCodeNumber(startCode++);
            itemSelves[i] = itemSelf;
        }

    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for (ItemSelf itemSelf : itemSelves) {
            if (itemSelf.getCodeNumber() == codeNumber) {
                if (itemSelf.isOccupied()) {
                    throw new Exception("Item already present!");
                }
                itemSelf.setItem(item);
                itemSelf.setOccupied(true);
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for (ItemSelf itemSelf : itemSelves) {
            if (itemSelf.getCodeNumber() == codeNumber) {
                if (!itemSelf.isOccupied()) {
                    throw new Exception("Item is not available!");
                }
                return itemSelf.getItem();
            }
        }
        throw new Exception("Invalid code!");
    }

    public void updateSoldOutItem(int codeNumber) {
        for (ItemSelf itemSelf : itemSelves) {
            if (itemSelf.getCodeNumber() == codeNumber) {
                itemSelf.setOccupied(false);
                break;
            }
        }
    }

    public void displayItems() {
        for (ItemSelf itemSelf : itemSelves) {
            System.out.println("Code: " + itemSelf.getCodeNumber() + " " + itemSelf.getItem().getItemType().name() + " price: " + itemSelf.getItem().getPrice() + " is available: " + itemSelf.isOccupied());
        }
    }

}
