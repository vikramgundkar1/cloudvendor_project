package h2project.demopractice.controller;


import h2project.demopractice.Model.Equipment;
import h2project.demopractice.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @PostMapping("/create")

    public String createEquipmentDeatils(@RequestBody Equipment equipment) {
        equipmentService.createEquipment(equipment);
        return "Equipment created";

    }


    @GetMapping("/getall")
    public ResponseEntity<List<Equipment>> getAllEquipmentDetails() {

        List<Equipment> all_equipments = equipmentService.getAllEquipment();
        return new ResponseEntity<>(all_equipments, HttpStatus.OK);

    }

    @GetMapping("/getall/{equipmentId}")
    public ResponseEntity<Equipment> getVendorDetails(@PathVariable int equipmentId) {
        Equipment equipmentDetails = equipmentService.getEquipmentById(equipmentId);

        return new ResponseEntity<Equipment>(equipmentDetails, HttpStatus.OK);
    }

    @PutMapping("/update/{equipmentId}")
    public String updateVendorDetails(@PathVariable int equipmentId, @RequestBody Equipment equipment) {
        equipmentService.updateEquipment(equipment, equipmentId);

        return "Cloud Vendor Updated!!!";
    }

    @DeleteMapping("/delete/{equipmentId}")
    public String deleteVendorDetailsById(@PathVariable int equipmentId) {
        equipmentService.deleteEquipmentById(equipmentId);
        return "Cloud Vendor Deleted Successfully";
    }


}
