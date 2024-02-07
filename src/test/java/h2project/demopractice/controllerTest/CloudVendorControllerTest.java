package h2project.demopractice.controllerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.controller.CloudVendorController;
import h2project.demopractice.service.CloudVendorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@RunWith(MockitoJUnitRunner.class)
public class CloudVendorControllerTest {

    @InjectMocks
    CloudVendorController cloudVendorController;

    @Mock
    CloudVendorService cloudVendorService;

    CloudVendorModel cloudVendorModel;

    MockMvc mockMVC;
    Long vendorId;


    @BeforeEach
    void setUp() {

        cloudVendorModel=new CloudVendorModel(1,"Amazon","US","Vendo1");

    }

    @Test
    public void createCloudvendorDeatilsTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(cloudVendorModel);

        String expected="Cloud vendor created";
        when(cloudVendorService.createCloudVendor(cloudVendorModel)).thenReturn("Created successfully");
        String response = cloudVendorController.createCloudvendorDeatils(cloudVendorModel);

        assertEquals(expected, response);


//        this.mockMVC.perform(post("/create")).contentType(MediaType.APPLICATION_JSON)
//                .content(jsonString).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void getAllCloudVendorDetailsTest()
    {
        List<CloudVendorModel> arraylist=new ArrayList<>();

        when(cloudVendorService.getAllCloudVendor()).thenReturn(arraylist);
        ResponseEntity<List<CloudVendorModel>> response = cloudVendorController.getAllCloudVendorDetails();

        assertEquals(arraylist ,response);
        
    }
    
    @Test
    public void  getVendorDetailsTest()
    {
        vendorId = 1L;
        
        when (cloudVendorService.getCloudVendor(vendorId)).thenReturn(cloudVendorModel);
        ResponseEntity<CloudVendorModel> details = cloudVendorController.getVendorDetails(1L);
        assertEquals(cloudVendorModel,details);
        
    }
    @Test
    public void updateVendorDetailsTest()
    {
        String expected="Cloud Vendor Updated!!!";
        doNothing().when(cloudVendorService.updateCloudVendor(cloudVendorModel, vendorId));

        String response = cloudVendorController.updateVendorDetails(1L, cloudVendorModel);
        assertEquals(expected, response);
    }

    @Test
    public void deleteVendorDetailsByIdTest()
    {
        String expected="Cloud Vendor Deleted Successfully";
        doNothing().when(cloudVendorService.deleteCloudVendor(vendorId));

        String response = cloudVendorController.deleteVendorDetailsById(vendorId);
        assertEquals(expected,response);

    }



}
