package IntegrationTests;

import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IntegrationTests {

    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    String baseUrl="http://localhost:8080";

    void init() {
        client= HttpClient.newHttpClient();
    }

    @Test
    void testExportWarehouses(){
        init();
        request= HttpRequest.newBuilder(URI.create(baseUrl+"/warehouse"))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            response= client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert(200 == response.statusCode());


    }
}
