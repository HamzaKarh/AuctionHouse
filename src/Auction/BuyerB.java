package Auction;

import java.util.Random;

public class BuyerB extends Buyer{


    public BuyerB(String n, int f) {
        super(n, f);
    }

    @Override
    public void Strategy() {
        while (getFunds() > 100){
            if (Seller.getInstances().size() == 0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            synchronized (Seller.getInstances()){
                Random rItem = new Random();
                Item targetBid = null;
                if(currentBids.isEmpty()){
                    targetBid = Seller.getInstances().get(rItem.nextInt(Seller.getInstances().size())).getItem();
                }else if(!currentBids.isEmpty()){
                    targetBid = currentBids.get(rItem.nextInt(currentBids.size()));
                }
                if(targetBid!= null && targetBid.getHighest_bidder() != this && this.getFunds()>=targetBid.getHighest_bid() && targetBid.getHighest_bid() != 0 && !targetBid.getStatus()){
                    if(this.getFunds()>=targetBid.getHighest_bid() + (targetBid.getHighest_bid()/10)){
                        bid(targetBid, targetBid.getHighest_bid()+ (targetBid.getHighest_bid()/10));
                    }else {
                        bid(targetBid, this.getFunds());
                    }
                }
            }
            boolean exit = false;
            for (int i = 0; i < Seller.getInstances().size(); i++){
                if ( Seller.getInstances().get(i).getItem() != null && Seller.getInstances().get(i).getItem().getHighest_bid() <= this.getFunds()){
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
