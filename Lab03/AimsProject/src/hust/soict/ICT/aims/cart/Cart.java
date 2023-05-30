package hust.soict.ICT.aims.cart;

import hust.soict.ICT.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered == 20) {
            System.out.println("The cart is almost full");
        }
        else {
            this.itemsOrdered[this.qtyOrdered] = disc;
            System.out.println("The disc has been added");
            this.qtyOrdered++;
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] discs) {
        if(this.qtyOrdered == 20) {
            System.out.println("The cart is almost full");
        }
        else {
            for(DigitalVideoDisc disc: discs) {
                this.itemsOrdered[this.qtyOrdered] = disc;
                this.qtyOrdered++;
            }
            System.out.println("The disc has been added");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int indexRemove = 0;
        if(this.qtyOrdered == 0) {
            System.out.println("The cart is empty");
        }
        else {
            for(int i=0; i<this.qtyOrdered; i++) {
                if(this.itemsOrdered[i] == disc) {
                    indexRemove = i;
                }
            }
            this.qtyOrdered --;
            DigitalVideoDisc newArr[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
            for(int i=0, k=0; i<this.qtyOrdered; i++) {
                if(i == indexRemove) continue;
                newArr[k++] = this.itemsOrdered[i];
            }
            this.itemsOrdered = newArr;
            System.out.println("The disc has been removed.");
        }
   }
    public float totalCost() {
        float sum = 0f;
        if(this.qtyOrdered == 0) {
            return 0f;
        }
        for(int i=0; i<this.qtyOrdered; i++) {
            DigitalVideoDisc disc = this.itemsOrdered[i];
            sum+= disc.getCost();
        }
        return sum;
   }

    public void print() {
        if(this.itemsOrdered.length == 0) {
            System.out.println("No item has been ordered");
            return;
        }
        System.out.println("***********************CART***********************\n" +
                "Ordered Items:");
        for(DigitalVideoDisc item: this.itemsOrdered) {
            if(item == null) break;
            System.out.println(item.toString());
        }
        System.out.println("Total cost:" + this.totalCost() + "\n***************************************************");
    }
    public void searchByTitle(String title) {
        int count = 0;
        System.out.println("***********************CART***********************\n" +
                "Items with Title:");
        for(DigitalVideoDisc item: this.itemsOrdered) {
            if(item == null) break;
            if(item.isMatchTitle(title)) {
                count++;
                System.out.println(item.toString());
            }
        }
        if(count == 0) System.out.println("No item has that title");
        System.out.println("***************************************************");
    }
    public void searchById(int id) {
        int count = 0;
        System.out.println("***********************CART***********************\n" +
                "Items with ID:");
        for(DigitalVideoDisc item: this.itemsOrdered) {
            if(item == null) break;
            if(item.isMatchId(id)) {
                count++;
                System.out.println(item.toString());
                break;
            }
        }
        if(count == 0) System.out.println("No item has that id");
        System.out.println("***************************************************");
    }
}