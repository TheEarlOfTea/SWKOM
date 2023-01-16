package IntegrationTests;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;

public class IntegrationTests {

    HttpClient client= HttpClient.newHttpClient();
    HttpRequest request;
    HttpResponse<String> response;
    ObjectMapper mapper= new ObjectMapper();
    String baseUrl="http://localhost:8080";


    @Test
    void integrationTest(){
        String trackingId= testSubmitParcel();
        assert (!trackingId.isEmpty());
        trackingId= stripToString(trackingId);
        System.out.println("Successfully submitted parcel. TrackingId: " + trackingId);
        List<String> originalCodes= testGetTrackingInformation(trackingId);
        assert (!originalCodes.isEmpty());
        System.out.println("TrackingInformation could be retrieved");
        System.out.println("Codes of futureHops: " + originalCodes);
        assert(testReportAllHops(trackingId, originalCodes));
        System.out.println("Sucessfully reported arrival at all Hops");
        assert(testReportParcelDelivery(trackingId));
        System.out.println("Successfully delivered parcel");

    }
    String testSubmitParcel(){
        Parcel parcel= new Parcel().weight(1f);
        Recipient dummyRecipient= new Recipient().country("Österreich").city("Wien").street("Molkereistrasse").postalCode("1020").name("testname");
        parcel.setRecipient(dummyRecipient);
        parcel.setSender(dummyRecipient);

        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(parcel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }

        request= HttpRequest.newBuilder(URI.create(baseUrl+"/parcel"))
                .header("Accept", "application/json").header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        }
        return response.body();
    }

    private String stripToString(String jsonString){
        String newString= jsonString.substring(15, jsonString.length()-2);
        return newString;
    }

    List<String> testGetTrackingInformation(String trackingId){
        request= HttpRequest.newBuilder(URI.create(baseUrl+"/parcel/"+trackingId))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        JSONObject jsonObject;
        try {
            jsonObject= new JSONObject(response.body());
             return getHopCodesFromJsonObject(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getHopCodesFromJsonObject(JSONObject jsonObject){
        JSONArray jsonArray=new JSONArray();
        try {
            jsonArray= jsonObject.getJSONArray("futureHops");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<String> codes= new LinkedList<>();
        try {
            for(int i=0; i<jsonArray.length(); i++){
                codes.add(jsonArray.getJSONObject(i).getString("code"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return codes;
    }

    private boolean testReportAllHops(String trackingId, List<String> codes){
        String code;
        List<String> newCodes;
        while(!codes.isEmpty()){
            code= codes.remove(0);
            request= HttpRequest.newBuilder(URI.create(baseUrl+"/parcel/"+trackingId+"/reportHop/" + code))
                    .header("Accept", "*/*")
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            try {
                response= client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            if(response.statusCode()!=201){
                return false;
            }
            newCodes= testGetTrackingInformation(trackingId);
            if(!newCodes.containsAll(codes)){
                return false;
            }
        }
        return true;
    }

    private boolean testReportParcelDelivery(String trackingId){
        HttpRequest fetchRequest= HttpRequest.newBuilder(URI.create(baseUrl+"/parcel/"+trackingId))
                .header("Accept", "application/json")
                .GET()
                .build();
        JSONObject jsonObject;

        try {
            response= client.send(fetchRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            jsonObject= new JSONObject(response.body());
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        String state="";
        try {
            state= jsonObject.getString("state");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(state.compareTo("Delivered")==0){
            return false;
        }

        request= HttpRequest.newBuilder(URI.create(baseUrl+"/parcel/"+trackingId+"/reportDelivery/"))
                .header("accept", "*/*")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.statusCode()==200;
    }
}
