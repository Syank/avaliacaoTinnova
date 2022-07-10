package tinnova.carsCrud.controllersTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tinnova.carsCrud.model.entities.Vehicle;
import tinnova.carsCrud.model.enumerations.VehicleBrand;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllVehicles() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/veiculos")
            ).
            andReturn().
            getResponse();

        int responseStatus = response.getStatus();

        assertEquals(responseStatus, HttpStatus.OK.value());

        String responseJson = response.getContentAsString();

        List<Vehicle> resultList = new ObjectMapper().readValue(responseJson, List.class);

        assertFalse(resultList.isEmpty());

    }

    @Test
    public void testGetAllVehiclesByFilter() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                MockMvcRequestBuilders.get("/veiculos").
                        param("brand", VehicleBrand.FERRARI.getValue())
            ).
            andReturn().
            getResponse();

        int responseStatus = response.getStatus();

        assertEquals(responseStatus, 200);

        assertEquals(responseStatus, HttpStatus.OK.value());

        String responseJson = response.getContentAsString();

        List<Vehicle> resultList = new ObjectMapper().readValue(responseJson, List.class);

        assertFalse(resultList.isEmpty());

    }

    @Test
    public void testGetVehicleById() throws Exception {
        String sampleVehicleId = getSampleVehicleIdFromDatabase();

        MockHttpServletResponse response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/veiculos/" + sampleVehicleId)
                ).
                andReturn().
                getResponse();

        int responseStatus = response.getStatus();

        assertEquals(responseStatus, HttpStatus.OK.value());

        String responseJson = response.getContentAsString();

        Map<String, Object> rawRequestedVehicle = new ObjectMapper().readValue(responseJson, Map.class);

        assertEquals(rawRequestedVehicle.get("id"), sampleVehicleId);

    }

    @Test
    public void testCreateVehicle() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Corsa");
        vehicle.setBrand(VehicleBrand.FORD);
        vehicle.setSold(false);
        vehicle.setCarYear(1998);
        vehicle.setDescription("Já está bem velho");

        String requestBody = new ObjectMapper().writeValueAsString(vehicle);

        MockHttpServletResponse response = mockMvc.perform(
                    MockMvcRequestBuilders.
                        post("/veiculos").
                        content(requestBody).
                        header("Content-Type", "application/json")
                ).
                andReturn().
                getResponse();

        int responseStatus = response.getStatus();

        assertEquals(responseStatus, HttpStatus.NO_CONTENT.value());

    }

    @Test
    public void testUpdatePartial() throws Exception {
        String sampleVehicleId = getSampleVehicleIdFromDatabase();

        Vehicle vehicle = new Vehicle();
        vehicle.setDescription("Estou aceitando trocas");
        vehicle.setId(sampleVehicleId);

        String requestBody = new ObjectMapper().writeValueAsString(vehicle);

        MockHttpServletResponse response = mockMvc.perform(
                        MockMvcRequestBuilders.
                                patch("/veiculos/" + sampleVehicleId).
                                content(requestBody).
                                header("Content-Type", "application/json")
                ).
                andReturn().
                getResponse();

        int responseStatus = response.getStatus();

        assertEquals(responseStatus, HttpStatus.NO_CONTENT.value());

    }

    @Test
    public void testDeleteVehicle() throws Exception {
        String sampleVehicleId = getSampleVehicleIdFromDatabase();

        MockHttpServletResponse response = mockMvc.perform(
                        MockMvcRequestBuilders.
                                delete("/veiculos/" + sampleVehicleId)
                ).
                andReturn().
                getResponse();

        int responseStatus = response.getStatus();

        assertEquals(responseStatus, HttpStatus.NO_CONTENT.value());

    }

    private String getSampleVehicleIdFromDatabase() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(
                        MockMvcRequestBuilders.get("/veiculos")
                ).
                andReturn().
                getResponse();

        String responseJson = response.getContentAsString();

        List<Vehicle> resultList = new ObjectMapper().readValue(responseJson, List.class);

        Map<String, Object> rawVehicleData = (Map<String, Object>) resultList.get(0);

        return (String) rawVehicleData.get("id");
    }

}

