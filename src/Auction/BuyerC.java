package Auction;

import java.util.Random;

public class BuyerC extends Buyer{


    public BuyerC(String n, int f) {
        super(n, f);
    }

    @Override
    public void Strategy() {
        while (getFunds() > 100){
            synchronized (Seller.getInstances()){
                Random rItem = new Random();
                Item targetBid = null;
                if(currentBids.isEmpty()){
                    targetBid = Seller.getInstances().get(rItem.nextInt(Seller.getInstances().size())).getItem();
                }else if(!currentBids.isEmpty()){
                    targetBid = currentBids.get(rItem.nextInt(currentBids.size()));
                }
                if(targetBid!= null && targetBid.getHighest_bidder() != this && this.getFunds()>targetBid.getHighest_bid() && !targetBid.getStatus()){
                    bid(targetBid, targetBid.getHighest_bid() + targetBid.getHighest_bid()/100);
                }
            }
            boolean exit = false;
            for (int i = 0; i < Seller.getInstances().size(); i++){
                if ( Seller.getInstances().get(i).getItem() != null && Seller.getInstances().get(i).getItem().getHighest_bid() <= this.getFunds() ){
                    exit = false;
                    break;
                }
                exit = true;
            }
            if (exit){
                break;
            }

        }
    }
}
