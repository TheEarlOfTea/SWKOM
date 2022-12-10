package io.swagger.gps.service.impl;
import io.swagger.gps.GeoEncodingService;
import io.swagger.services.dto.GeoCoordinate;
import io.swagger.services.dto.Recipient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;


public class BingEncodingProxy implements GeoEncodingService {
    private GeoCoordinate geoCoordinate =new GeoCoordinate();

// todo try catch/exceptions

    @Override
    public GeoCoordinate encodeAddress(GeoCoordinate address) throws IOException, InterruptedException {
        URI url = URI.create(("https://nominatim.openstreetmap.org/search?addressdetails=1&q="
                +address.getLat()+" "
                +address.getLon()+"&format=json").replaceAll(" ", "%20"));

        System.out.println(url);
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder(url).GET().build();

        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        future.thenApply(HttpResponse::body).thenAccept((response) -> {

            JSONArray json = null;
            JSONObject obj = null;

            try {

                json = new JSONArray(response);
                 obj = (JSONObject) json.get(0);

            } catch (JSONException e) {
                e.printStackTrace();
            }


            String lat = null;
            try {

                assert obj != null;
                lat = obj.getString("lat");

            } catch (JSONException e) {
                e.printStackTrace();
            }


            String lon = null;
            try {
                lon = obj.getString("lon");

            } catch (JSONException e) {
                e.printStackTrace();
            }


            System.out.println("lat: "+ lat);
            System.out.println("lon: "+ lon);

                    this.geoCoordinate.setLon(Double.valueOf(lon));
                    this.geoCoordinate.setLat(Double.valueOf(lat));
        }).join();


        return geoCoordinate;



    }



}
