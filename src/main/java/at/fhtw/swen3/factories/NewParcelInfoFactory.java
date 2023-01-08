package at.fhtw.swen3.factories;

import at.fhtw.swen3.services.dto.NewParcelInfo;

import java.util.Random;
import java.util.UUID;

public class NewParcelInfoFactory {
    public static NewParcelInfo getNewParcelInfo(){
        return new NewParcelInfo().trackingId(generateId());
    }

    public static String generateId(){
        Random random= new Random();
        String s= "";
        int j;
        for(int i=0; i<9; i++){
            j= random.nextInt(36);
            if(j>25){
                s+= (j-26);
            }
            else {
                s+= (char)(j+65);
            }
        }
        return s;

    }
}
