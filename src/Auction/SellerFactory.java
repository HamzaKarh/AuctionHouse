package Auction;

import java.util.Random;

public class SellerFactory {

    public SellerFactory(){
    }

    public static Seller[]  Build(int nb) {
        Seller []s = new Seller[nb];
        Random rand = new Random();
        int nb_typeA = nb - rand.nextInt(nb);
        for (int i = 0; i<nb_typeA; i++){
            s[i] = new SellerA("Seller "+(i+1), "Item "+(i+1) , rand.nextInt(401)+ 100);
        }
        for(int i = nb_typeA; i < nb; i++){
            s[i] = new SellerB("Seller "+(i+1), "Item "+(i+1) , rand.nextInt(401)+ 100);
        }
        return s;
    }

}
