package Auction;

public class SellerA extends Seller {



    public SellerA(String n, String itemName, int price) {
        super(n, itemName, price);
    }

    @Override
    public void Strategy() {
        int lastBid = 0;
        int bidsLeft = 2;
        while (bidsLeft > 0){
            try {
                if(this.getItem().getHighest_bid() != lastBid){
                    bidsLeft --;
                    lastBid = this.getItem().getHighest_bid();
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sell();
        Seller.getInstances().remove(this);
    }
}
