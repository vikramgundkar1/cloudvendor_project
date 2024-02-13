package h2project.demopractice.serviceTest;


import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.Model.Equipment;
import h2project.demopractice.exceptions.CloudVendorNotFoundException;
import h2project.demopractice.repository.CloudVendorRepository;
import h2project.demopractice.repository.EquipmentRepository;
import h2project.demopractice.service.CloudVendorService;
import h2project.demopractice.service.EquipmentService;
import h2project.demopractice.service.serviceImpl.CloudVendorServiceImpl;
import h2project.demopractice.service.serviceImpl.EquipmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class EquipmentServiceImpleTest {

    @Mock
    EquipmentRepository equipmentRepository;

    @Mock
    CloudVendorRepository cloudVendorRepository;
    @InjectMocks
    EquipmentService equipmentService=new EquipmentServiceImpl();

    @InjectMocks
    CloudVendorService cloudVendorService= new CloudVendorServiceImpl(cloudVendorRepository);

    CloudVendorModel cloudVendorModel;

    Equipment equipment;
    List<Equipment> equipmentList;

    @BeforeEach
    void setUp() {
        //After adding this step why cloudvendor.this empty error resolve?
        MockitoAnnotations.initMocks(this);
        cloudVendorModel=new CloudVendorModel(1L,"Amazon", "USA", "Vendor1");

        equipment=new Equipment(1,"Desktop", "Elevtronics", 1000L);

        equipmentList=new ArrayList<>();
        equipmentList.add(new Equipment(2,"Laptop", "Screen", 50000L));
        equipmentList.add(new Equipment(3,"Mouse", "Plastic", 500L));

    }

    @Test
    public void Verify_user_should_be_able_to_save_equipments_positive()
    {
        when(cloudVendorRepository.findById(1L)).thenReturn(Optional.ofNullable(cloudVendorModel));

        assertEquals("Equipment Added Successfully", equipmentService.createEquipment(equipmentList,1L));
    }

    @Test
    public void Verify_user_should_be_able_to_save_equipments_negative()
    {
        when(cloudVendorRepository.findById(1L)).thenReturn(Optional.ofNullable(cloudVendorModel));
        List<Equipment> emptyList=new ArrayList<>();

        CloudVendorNotFoundException exception = assertThrows(CloudVendorNotFoundException.class, () -> equipmentService.createEquipment(emptyList, 1L));

        assertEquals("please add at least one equipment", exception.getMessage());
    }
    @Test
    public void Verify_user_should_not_be_able_to_save_equipments_cloudvendor_notfound()
    {
        when(cloudVendorRepository.findById(1L)).thenReturn(Optional.ofNullable(cloudVendorModel));

        CloudVendorNotFoundException exception = assertThrows(CloudVendorNotFoundException.class, () -> equipmentService.createEquipment(equipmentList, 6L));

        assertEquals("Cloud Vendor Not found", exception.getMessage());
    }

    @Test
    public void Verify_user_is_able_to_update_equipment_positive()
    {

    }
    @Test
    public void Verify_user_is_able_to_update_equipment_negative()
    {

    }

    @Test
    public void Verify_user_is_able_to_get_all_equipments()
    {
        when(equipmentRepository.findAll()).thenReturn(equipmentList);

        List<Equipment> op = equipmentService.getAllEquipment();

        assertEquals(equipmentList.size(), op.size());
        assertEquals(equipmentList.get(0).getEquipmentId(), op.get(0).getEquipmentId());
        assertEquals(equipmentList.get(0).getEquipmentType(), op.get(0).getEquipmentType());
        assertEquals(equipmentList.get(0).getEquipmentName(), op.get(0).getEquipmentName());
    }

    @Test
    public void Verify_user_should_be_able_to_get_single_equipment()
    {
        when(equipmentRepository.findById(anyInt())).thenReturn(Optional.ofNullable(equipment));

        Equipment sampleequipment = equipmentService.getEquipmentById(1);

        assertEquals(equipment.getEquipmentId(), sampleequipment.getEquipmentId());

    }
    @Test
    public void Verify_user_should_be_able_to_get_single_equipment_negative()
    {
        when(equipmentRepository.findById(4)).thenReturn(Optional.ofNullable(equipment));

        CloudVendorNotFoundException exception = assertThrows(CloudVendorNotFoundException.class, () -> equipmentService.getEquipmentById(70));

        assertEquals("Equipments not found", exception.getMessage());

    }
    @Test
    public void Verify_user_should_be_able_to_delete_equipment()
    {
        Equipment emptyEquipment = new Equipment();

        when(equipmentRepository.findById(1)).thenReturn(Optional.of(equipment));

        String message = equipmentService.deleteEquipmentById(1);
        assertEquals("Equipment deleted Successfully", message);


    }
}
