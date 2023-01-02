package at.fhtw.swen3.factories;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.threeten.bp.OffsetDateTime;

import java.util.LinkedList;
import java.util.List;

public class TrackingInformationFactory {
    public static TrackingInformation getTrackingInformation(){
        List<HopArrival> futureHops= getFutureHops();

        LinkedList<HopArrival> visitedHops= new LinkedList<HopArrival>();
        return new TrackingInformation().futureHops(futureHops).visitedHops(visitedHops).state(TrackingInformation.StateEnum.PICKUP);
    }

    private static List<HopArrival> getFutureHops(){
        LinkedList<HopArrival> futureHops= new LinkedList<HopArrival>();
        futureHops.add(new HopArrival().code("WTTA01").description("futurehop").dateTime(OffsetDateTime.MAX));
        return futureHops;
    }
}
