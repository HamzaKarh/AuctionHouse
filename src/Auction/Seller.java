package Auction;

import java.util.ArrayList;

public abstract class Seller extends Thread {
    private String name;
    private Item item;
    private static ArrayList<Seller> Instances = new ArrayList<>();

    public Seller(String n, String itemName, int price){
        name = n;
        item = new Item(itemName, price, this);
        Instances.add(this);
    }

    public void run() {
        System.out.println(this + " running");
        this.Strategy();
        Instances.remove(this);
        System.out.println(this + " exiting...");
    }


    public void sell(){
        item.getHighest_bidder().buy(item);
        System.out.println(item + " was sold to " + item.getHighest_bidder());
        Item.getInstances().remove(item);
    }

    public Item getItem() {
        return item;
    }

    public static ArrayList<Seller> getInstances(){
        return Instances;
    }

    public String toString() {
        return name;
    }


    public abstract void Strategy();
    /*
* Strategy A = seller will try to get a minimum number of bids for his product.
* If he doesn't get any bid for 10 rounds, he will quit the auction and sell the item to the highest bidder.
*
* Strategy B = seller will try to get a minimum price for his product, price will be randomly
* set by the factory between starting price + 10% and starting price + 50%. He will not quit the auction until he gets this amount.
* */


}
