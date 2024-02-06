package h2project.demopractice.controllerTest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.service.CloudVendorService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CloudVendorControllerTest {


    @Mock
    CloudVendorService cloudVendorService;

    @Mock
    CloudVendorModel cloudVendorModel;

    MockMvc mockMVC;


    @BeforeEach
    void setUp() {

        cloudVendorModel=new CloudVendorModel(1,"Amazon","US","Vendo1");

    }

    public void createCloudvendorDeatilsTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(cloudVendorModel);

        when(cloudVendorService.createCloudVendor(cloudVendorModel)).thenReturn("Created successfully");

//        this.mockMVC.perform(post("/create")).contentType(MediaType.APPLICATION_JSON)
//                .content(jsonString).andDo(print()).andExpect(status().isOk());

    }


}
