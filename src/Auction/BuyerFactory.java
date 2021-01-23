package Auction;

import java.util.Random;

public class BuyerFactory {

    public static Buyer[] Build(int nb){
            Buyer []b = new Buyer[nb];
            Random rand = new Random();
            int nb_typeA = rand.nextInt(nb);
            int nb_typeB = rand.nextInt(nb-nb_typeA) + nb_typeA;
            for (int i = 0; i<nb_typeA ; i++){
                b[i] = new BuyerA("buyer "+ (i+1) , rand.nextInt(10000)+ 5000);
            }
            for (int i = nb_typeA; i<nb_typeB ; i++){
                b[i] = new BuyerB("buyer "+ (i+1) , rand.nextInt(10000)+ 5000);
            }
            for (int i = nb_typeB; i<nb ; i++){
                b[i] = new BuyerC("buyer "+ (i+1) , rand.nextInt(10000)+ 5000);
            }
            return b;
    }

}
