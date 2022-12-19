package at.fhtw3.swen3.factories;

import at.fhtw3.swen3.services.dto.NewParcelInfo;

public class NewParcelInfoFactory {
    public static NewParcelInfo getNewParcelInfo(){
        return new NewParcelInfo().trackingId("PYJRB4HZ6");
    }
}
