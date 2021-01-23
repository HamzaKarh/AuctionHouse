package Auction;

import java.util.ArrayList;

public class Item {

    private String name;
    private Seller seller;
    private int price;
    private int highest_bid = 0;
    private Buyer highest_bidder;
    private boolean sold;
    private static ArrayList<Item> Instances = new ArrayList<>();


    Item(String n, int p, Seller s){
        name = n;
        price = p;
        seller = s;
        highest_bid = price;
        highest_bidder = null;
        sold = false;
        Instances.add(this);
    }


    public static ArrayList<Item> getInstances() {
        return Instances;
    }

    int getHighest_bid() {
        return highest_bid;
    }

    Buyer getHighest_bidder() {
        return highest_bidder;
    }

    public String toString() {
        return name;
    }

    public boolean getStatus(){
        return sold;
    }

    public Seller getSeller() {
        return seller;
    }

    public int getPrice() {
        return price;
    }

    boolean bid(Buyer bidder, int price){
        if(price>highest_bid ){
            highest_bid = price;
            this.highest_bidder = bidder;
            return true;
        }
        System.out.println(bidder+ "'s bid is unsufficient.");
        return false;
    }
}
