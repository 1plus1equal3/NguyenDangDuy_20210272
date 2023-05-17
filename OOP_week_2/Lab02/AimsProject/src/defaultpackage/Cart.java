package defaultpackage;

public class Cart {
    public static final int MAX_NUMBERS_ORDERS = 20;
    private DigitalVideoDisc itemsOrderd[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
    private int qtyOrdered = -1;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered<20){
            itemsOrderd[qtyOrdered+1] = disc;
            qtyOrdered++;
            System.out.println("Add item: " + disc.getTitle() + " successfully to your cart!");
        }
        else{
            System.out.println("Your cart is full!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered>0){
            for(int j = findItem(disc); j<itemsOrderd.length-1; j++){
                itemsOrderd[j] = itemsOrderd[j+1];
            }
            System.out.println("Remove item: " + disc.getTitle() + " successfully from your cart");
            qtyOrdered--;
        }else{
            System.out.println("Item " + disc.getTitle()+  "cannot be removed");
        }
    }

    public float totalCost(){
        float cost = 0;
        for(int i = 0; i<qtyOrdered; i++){
            cost+=itemsOrderd[i].getCost();
        }
        return cost;
    }

    public void displayItem(){
        for(int i = 0; i<qtyOrdered; i++){
            System.out.println("Item number " + (i+1) + "is: " + itemsOrderd[i].getTitle());
        }
    }

    private int findItem(DigitalVideoDisc disc){
        for(int i = 0; i<itemsOrderd.length; i++)
            if(itemsOrderd[i].equals(disc)) return i;
        return 0;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }
}
