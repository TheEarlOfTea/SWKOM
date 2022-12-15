package at.fhtw3.swen3.factories;

import at.fhtw3.swen3.services.dto.HopArrival;
import at.fhtw3.swen3.services.dto.TrackingInformation;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;

public class TrackingInformationFactory {
    public static TrackingInformation getTrackingInformation(){
        LinkedList<HopArrival> futureHops= new LinkedList<HopArrival>();
        futureHops.add(new HopArrival().code("ABCD12").dateTime(OffsetDateTime.MAX).description("SA"));
        LinkedList<HopArrival> visitedHops= new LinkedList<HopArrival>();
        visitedHops.add(new HopArrival().code("DDDD12").dateTime(OffsetDateTime.MAX).description("DA"));
        return new TrackingInformation().futureHops(futureHops).visitedHops(visitedHops).state(TrackingInformation.StateEnum.PICKUP);
    }
}
