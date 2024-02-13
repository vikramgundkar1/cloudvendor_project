package h2project.demopractice.serviceTest;


import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.exceptions.CloudVendorNotFoundException;
import h2project.demopractice.repository.CloudVendorRepository;
import h2project.demopractice.service.CloudVendorService;
import h2project.demopractice.service.serviceImpl.CloudVendorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CloudVendorServiceImplTest {

    @Mock
    CloudVendorRepository cloudVendorRepository;
    @InjectMocks
    CloudVendorService cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
    @Mock
    CloudVendorModel cloudVendorModelTest;
    List<CloudVendorModel> vendorlist;

    @BeforeEach
    void setUp() {
        cloudVendorModelTest = new CloudVendorModel(1L, "Amazon", "USA", "Vendor1");

        vendorlist = new ArrayList<>();
        vendorlist.add(new CloudVendorModel(2L, "GCP", "USA", "Vendor2"));
        vendorlist.add(new CloudVendorModel(3L, "Azure", "USA", "Vendor3"));

    }

    @Test
    public void verify_user_should_be_able_to_save_cloudvendor() {

        when(cloudVendorRepository.save(cloudVendorModelTest)).thenReturn(cloudVendorModelTest);
        assertEquals("Created successfully", cloudVendorService.createCloudVendor(cloudVendorModelTest));

    }

    @Test
    public void verify_user_should_be_able_to_save_list_of_cloud_vendor() {
        // Optional<List<CloudVendorModel>> check = Optional.of(vendorlist);
        when(cloudVendorRepository.saveAll(anyList())).thenReturn(vendorlist);
        String response = cloudVendorService.createCloudVendorList(vendorlist);
        assertEquals("List added successfully", response);


    }


    @Test
    public void verify_user_should_be_able_to_get_cloudvendor() {

        when(cloudVendorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(cloudVendorModelTest));
        CloudVendorModel vendordetails = cloudVendorService.getCloudVendor(1L);

        assertNotNull(vendordetails);

        assertEquals(vendordetails.getVendorName(), cloudVendorModelTest.getVendorName());
        assertEquals(vendordetails.getVendorAddress(), cloudVendorModelTest.getVendorAddress());
        assertEquals(vendordetails.getVendorNumber(), cloudVendorModelTest.getVendorNumber());

    }

    @Test
    public void verify_user_should_be_able_to_throw_exception_if_vendor_does_not_exist() {

        when(cloudVendorRepository.findById(anyLong())).thenThrow(new CloudVendorNotFoundException("Vendor details not found"));

        CloudVendorNotFoundException ceException = assertThrows(CloudVendorNotFoundException.class, () -> cloudVendorService.getCloudVendor(7L));
        assertEquals("Vendor details not found", ceException.getMessage());

    }

    @Test
    public void verify_user_should_be_able_to_get_list_of_cloud_vendors() {

        when(cloudVendorRepository.findAll()).thenReturn(vendorlist);
        List<CloudVendorModel> vendorlistofcloud = cloudVendorService.getAllCloudVendor();
        assertEquals(vendorlistofcloud.stream().count(), vendorlist.stream().count());

    }

    @Test
    public void verify_user_should_be_able_to_update_the_vendor_details() {
        when(cloudVendorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(cloudVendorModelTest));

       // cloudVendorModelTest.setVendorId(111L);
        cloudVendorModelTest.setVendorName("updatedName");
        cloudVendorModelTest.setVendorAddress("updated address");
        cloudVendorModelTest.setVendorNumber("updated number");

        String op = cloudVendorService.updateCloudVendor(cloudVendorModelTest, 11L);
        assertEquals("Successfully updated vendor details", op);

    }

    @Test
    public void verify_user_should_be_able_to_delete_vendor_details_by_id() {
        when(cloudVendorRepository.findById(anyLong())).thenReturn(Optional.of(cloudVendorModelTest));
        String result = cloudVendorService.deleteCloudVendor(5L);
        assertEquals("deleted successfully", result);

    }
}



