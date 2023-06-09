package hust.soict.ICT.aims.store;

import hust.soict.ICT.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Collections;

public class Store {
    private final ArrayList<DigitalVideoDisc> itemInStore = new ArrayList<>();

    public void addDVD(DigitalVideoDisc... dvds) {
        Collections.addAll(itemInStore, dvds);
        System.out.println("Added " + itemInStore.size() + " items");
    }
    public void removeDVD(DigitalVideoDisc... dvds) {
        for(DigitalVideoDisc dvd: dvds) {
            for(int i=this.itemInStore.size()-1; i>=0; i--) {
                DigitalVideoDisc a = this.itemInStore.get(i);
                if(a.isMatchTitle(dvd.getTitle())) {
                    this.itemInStore.remove(i);
                    System.out.println("Remove dvd " + a.getId());
                }
            }
        }
    }
}
