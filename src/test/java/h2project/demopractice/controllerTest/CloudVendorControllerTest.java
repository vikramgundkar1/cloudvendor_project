package h2project.demopractice.controllerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.controller.CloudVendorController;
import h2project.demopractice.service.CloudVendorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class CloudVendorControllerTest {

    @InjectMocks
    CloudVendorController cloudVendorController;

    @Mock
    CloudVendorService cloudVendorService;

    CloudVendorModel cloudVendorModel;
    Long vendorId;
    List<CloudVendorModel> arraylist;
    String jsonString;
    private MockMvc mockMVC;

    @BeforeEach
    void setUp() throws JsonProcessingException {

        mockMVC = MockMvcBuilders.standaloneSetup(cloudVendorController).setControllerAdvice((new Exception())).build();
        cloudVendorModel = new CloudVendorModel(1L, "Amazon", "USA", "Vendor1");

        arraylist = new ArrayList<>();
        arraylist.add(new CloudVendorModel(2L, "GCP", "USA", "Vendor2"));
        arraylist.add(new CloudVendorModel(3L, "Azure", "USA", "Vendor3"));

        ObjectMapper mapper = new ObjectMapper();
        jsonString = mapper.writeValueAsString(cloudVendorModel);


    }

    @Test
    public void createCloudvendorDeatilsTest() throws Exception {


//        String expected = "Cloud vendor created";
        when(cloudVendorService.createCloudVendor(cloudVendorModel)).thenReturn("Created successfully");
//        String response = cloudVendorController.createCloudvendorDeatils(cloudVendorModel);

//        assertEquals(expected, response);


//        this.mockMVC.perform(post("/create"))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonString)
//                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void updateVendorDetailsTest() throws Exception {

        when(cloudVendorService.updateCloudVendor(cloudVendorModel, 1L)).thenReturn("Cloud Vendor Updated!!!");

//        this.mockMVC.perform(put("/update/1"))
//                .accept(MediaType.APPLICATION_JSON)
//                .content(jsonString)
//                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getAllCloudVendorDetailsTest() throws Exception {


        when(cloudVendorService.getAllCloudVendor()).thenReturn(arraylist);

        this.mockMVC.perform(get("/cloudvendor/getall"))
                .andDo(print()).andExpect(status().isOk());


    }

    @Test
    public void getVendorDetailsTest() throws Exception {


        when(cloudVendorService.getCloudVendor(1L)).thenReturn(cloudVendorModel);

        this.mockMVC.perform(get("/cloudvendor/getall/1"))
                .andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void deleteVendorDetailsByIdTest() throws Exception {
//        String expected = "Cloud Vendor Deleted Successfully";
        when(cloudVendorService.deleteCloudVendor(1L)).thenReturn("Cloud Vendor Deleted Successfully");

        this.mockMVC.perform(delete("/cloudvendor/delete/1"))
                .andDo(print()).andExpect(status().isOk());


    }


}
