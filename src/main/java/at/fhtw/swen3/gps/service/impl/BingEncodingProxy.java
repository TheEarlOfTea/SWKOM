package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.GeoEncodingService;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.*;


public class BingEncodingProxy implements GeoEncodingService {

    private final static String openstreetmapUrl = "https://nominatim.openstreetmap.org/search?addressdetails=1&q=";

    @Override
    public GeoCoordinate encodeAddress(Address address) throws BadAddressException {
        URI url = URI.create((openstreetmapUrl + getQueryFromAddress(address) +
                "&format=json").replaceAll(" ", "%20"));

        System.out.println(url);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder(url).GET().build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONArray json = new JSONArray(response.body());
            JSONObject jsonResponse = (JSONObject) json.get(0);

            String lat = jsonResponse.getString("lat");
            String lon = jsonResponse.getString("lon");

            System.out.println("lat: " + lat);
            System.out.println("lon: " + lon);

            GeoCoordinate geoCoordinate = new GeoCoordinate();
            geoCoordinate.setLon(Double.valueOf(lon));
            geoCoordinate.setLat(Double.valueOf(lat));

            return geoCoordinate;
        } catch (Exception e) {
            throw new BadAddressException(e.getMessage());
        }
    }

    private String getQueryFromAddress(Address address) {
        return address.getCountry() + "+" +
                address.getCity() + "+" +
                address.getStreet() + "+" +
                address.getPostalCode();
    }
}
