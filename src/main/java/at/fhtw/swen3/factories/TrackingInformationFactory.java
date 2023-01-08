package at.fhtw.swen3.factories;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.extern.slf4j.Slf4j;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class TrackingInformationFactory {
    public static TrackingInformation getTrackingInformation() throws BadAddressException {
        List<HopArrival> futureHops;
        try{
            futureHops= getFutureHops();
        }catch (BadAddressException e){
            log.error("Received Invalid Address. Exception: " + e.getMessage());
            throw e;
        }


        LinkedList<HopArrival> visitedHops= new LinkedList<HopArrival>();
        return new TrackingInformation().futureHops(futureHops).visitedHops(visitedHops).state(TrackingInformation.StateEnum.PICKUP);
    }

    private static List<HopArrival> getFutureHops() throws BadAddressException{
        LinkedList<HopArrival> futureHops= new LinkedList<HopArrival>();
        futureHops.add(new HopArrival().code("WTTA01").description("futurehop").dateTime(OffsetDateTime.MAX));
        return futureHops;
    }
}
