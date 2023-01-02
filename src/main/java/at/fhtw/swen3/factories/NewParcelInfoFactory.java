package at.fhtw.swen3.factories;

import at.fhtw.swen3.services.dto.NewParcelInfo;

import java.util.UUID;

public class NewParcelInfoFactory {
    public static NewParcelInfo getNewParcelInfo(){
        return new NewParcelInfo().trackingId(UUID.randomUUID().toString());
    }
}
