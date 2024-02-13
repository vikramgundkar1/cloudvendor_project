package h2project.demopractice.controllerTest;

import h2project.demopractice.Model.Equipment;
import h2project.demopractice.controller.EquipmentController;
import h2project.demopractice.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EquipmentControllerTest {

    @InjectMocks
    private EquipmentController equipmentController;

    @Mock
    private EquipmentService equipmentService;
    MockMvc mockMvc;
    Equipment equipment;
    List<Equipment> equipmentsList;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(equipmentController).setControllerAdvice((new Exception())).build();

        equipment = new Equipment(1, "Desktop", "Electronics", 50000L);

        equipmentsList = new ArrayList<>();
        equipmentsList.add(new Equipment(2, "Laptop", "Screen", 50000L));
        equipmentsList.add(new Equipment(3, "Mouse", "Plastic", 500L));

    }

    @Test
    public void Verify_getall_method() throws Exception {
        when(equipmentService.getAllEquipment()).thenReturn(equipmentsList);

        this.mockMvc.perform(get("/cloudvendor/equipment/getall"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void Verify_getbyId_method() throws Exception {
        when(equipmentService.getEquipmentById(1)).thenReturn(equipment);

        this.mockMvc.perform(get("/cloudvendor/equipment/getall/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void Verify_delete_equipment_method() throws Exception {
        when(equipmentService.deleteEquipmentById(1)).thenReturn("Equipment deleted Successfully");
        this.mockMvc.perform(delete("/cloudvendor/equipment/delete/1"))
                .andDo(print()).andExpect(status().isOk());

    }




}
