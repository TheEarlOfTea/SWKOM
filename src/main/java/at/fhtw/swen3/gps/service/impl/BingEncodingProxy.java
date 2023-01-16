package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.service.Address;
import at.fhtw.swen3.gps.service.GeoEncodingService;

import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.GPSProxyException;
import at.fhtw.swen3.services.CustomExceptions.ServiceLayerExceptions.UserInputExceptions.BadAddressException;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

@Slf4j
public class BingEncodingProxy implements GeoEncodingService {

    private final static String openstreetmapUrl = "https://nominatim.openstreetmap.org/search?addressdetails=1&q=";

    @Override
    public GeoCoordinate encodeAddress(Address address) throws BadAddressException, GPSProxyException {
        URI url = URI.create((openstreetmapUrl + getQueryFromAddress(address) +
                "&format=json").replaceAll(" ", "%20"));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(url).GET().build();
        HttpResponse<String> response;
        JSONArray jsonArray;
        JSONObject jsonObject;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e){
            log.error("Proxy failed to provide geoCoordinate Object. Nested exception: " + e.getMessage());
            throw new GPSProxyException("Proxy failed to provide geoCoordinate Object. Nested exception: " + e.getMessage());
        }

        try {
            jsonArray= new JSONArray(response.body());
            jsonObject = jsonArray.getJSONObject(0);
            String lat = jsonObject.getString("lat");
            String lon = jsonObject.getString("lon");

            GeoCoordinate geoCoordinate = new GeoCoordinate();
            geoCoordinate.setLon(Double.valueOf(lon));
            geoCoordinate.setLat(Double.valueOf(lat));

            return geoCoordinate;
        } catch (JSONException e) {
            throw new BadAddressException(e.getMessage());
        }
    }
    //"Proxy failed to provide geoCoordinate Object. Nested exception: " + e.getMessage()

    private String getQueryFromAddress(Address address) {
        return address.getCountry() + "+" +
                address.getCity() + "+" +
                address.getStreet() + "+" +
                address.getPostalCode();
    }
}
