package Auction;

import java.util.Random;

public class SellerB extends Seller {

    public SellerB(String n, String itemName, int price){
        super(n, itemName, price);
    }

    @Override
    public void Strategy() {
        int lastBid = 0;
        Random rand = new Random();
        int minPrice = this.getItem().getPrice() + (this.getItem().getPrice()*rand.nextInt(100)/100);
        int exit_count = 0;
        while (this.getItem().getHighest_bid() < minPrice){
            try {
                if(getItem().getHighest_bid() != lastBid){
                    lastBid = getItem().getHighest_bid();
                    exit_count = 0;
                }else {
                    exit_count++;
                }

                if(exit_count >= 20){
                    break;
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
