package Auction;

import java.util.ArrayList;

public abstract class Buyer extends Thread {
    private int funds;
    private String name;
    protected ArrayList<Item> boughtItems, currentBids;
    private static ArrayList<Buyer> Instances = new ArrayList<Buyer>();

    public Buyer(String n, int f){
        name = n;
        funds = f;
        boughtItems = new ArrayList();
        currentBids = new ArrayList();
        Instances.add(this);
    }


    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this + " starting with " + this.funds);

        this.Strategy();

        System.out.println(this + " exiting..");
        Instances.remove(this);

    }

    void bid(Item item, int price){
        if(item.bid(this, price)){
            currentBids.add(item);
            System.out.println(this + " bids on "+ item+ " for " + price+"!");
        }
    }

    void buy(Item item){
        boughtItems.add(item);
        funds -= item.getHighest_bid();
    }

    public int getFunds() {
        return funds;
    }


    public static ArrayList<Buyer> getInstances(){
        return Instances;
    }

    public abstract void Strategy();
    /*
    * Strategy A = buyer will always double the previous bid.
    *
    * Strategy B = buyer will never bid first on an item.
    *
    * Strategy C = buyer will always try to bid minimally.
    * */
}
