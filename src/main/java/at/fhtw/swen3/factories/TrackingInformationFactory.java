package at.fhtw.swen3.factories;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;

public class TrackingInformationFactory {
    public static TrackingInformation getTrackingInformation(){
        LinkedList<HopArrival> futureHops= new LinkedList<HopArrival>();
        LinkedList<HopArrival> visitedHops= new LinkedList<HopArrival>();
        return new TrackingInformation().futureHops(futureHops).visitedHops(visitedHops).state(TrackingInformation.StateEnum.PICKUP);
    }
}
