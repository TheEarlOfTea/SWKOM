package at.fhtw.swen3.integration;

import at.fhtw.swen3.services.EmailNotificationService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static at.fhtw.swen3.services.dto.TrackingInformation.StateEnum.PICKUP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
public class TestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailNotificationService emailNotificationService;

    @Test
    @SneakyThrows
    void importWarehouseIntegrationTest() {


        String s = IOUtils.toString(new FileInputStream("src/main/resources/tests/kleines_testwarehouse.json"));

        mockMvc.perform(post("/warehouse")
                .content(s)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @SneakyThrows
    void submitParcelIntegrationTest() {
        String s = IOUtils.toString(new FileInputStream("src/main/resources/tests/kleines_testwarehouse.json"));

        mockMvc.perform(post("/warehouse")
                        .content(s)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        Parcel parcel = new Parcel();
        parcel.setWeight(1.8f);
        Recipient recipient = new Recipient();
        recipient.setName("August");
        recipient.setCountry("Austria");
        recipient.setCity("Wien");
        recipient.setStreet("Molkereistrasse");
        recipient.setPostalCode("1020");
        Recipient sender = new Recipient();
        sender.setName("Tim");
        sender.setCountry("Austria");
        sender.setCity("Wien");
        sender.setStreet("Molkereistrasse");
        sender.setPostalCode("1020");
        parcel.setRecipient(recipient);
        parcel.setSender(sender);

        Gson gson = new Gson();
        String jsonParcel = gson.toJson(parcel);
        MvcResult parcelSubmitResult = mockMvc.perform(post("/parcel")
                        .content(jsonParcel)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Accept", "application/json"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

        String contentAsString = parcelSubmitResult.getResponse().getContentAsString();
        NewParcelInfo parcelInfo = gson.fromJson(contentAsString, NewParcelInfo.class);
        assertNotNull(parcelInfo);
        String parcelId = parcelInfo.getTrackingId();
        System.out.println(parcelId);

        MvcResult trackingInfo = mockMvc.perform(get(String.format("/parcel/%s", parcelId))
                        .header("Accept", "application/json"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

//        TrackingInformation trackingInformation = gson.fromJson(trackingInfo.getResponse().getContentAsString(), TrackingInformation.class);
//
//        assertEquals(PICKUP, trackingInformation.getState());

        mockMvc.perform(post(String.format("/parcel/%s/reportHop/%s", parcelId, "WTTA01"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Accept", "application/json"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());

        MvcResult newTrackingInfo = mockMvc.perform(get(String.format("/parcel/%s", parcelId))
                        .header("Accept", "application/json"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();

        mockMvc.perform(post(String.format("/parcel/%s/reportDelivery/", parcelId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Accept", "application/json"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());

        MvcResult finalTrackingInfo = mockMvc.perform(get(String.format("/parcel/%s", parcelId))
                        .header("Accept", "application/json"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andReturn();
    }
}
