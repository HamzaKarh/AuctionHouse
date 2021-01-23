package UI;

import Auction.*;

public class Auctioneer  {


    public Auctioneer(){
        int nbSellers = 5;
        int nbBuyers = 16;
        Seller[] sellers = SellerFactory.Build(nbSellers);
        Buyer[] buyers = BuyerFactory.Build(nbBuyers);
        for(int i = 0; i<sellers.length ; i++){
            sellers[i].start();
        }
        for(int i = 0; i<buyers.length; i++){
            buyers[i].start();
        }

    }

}
