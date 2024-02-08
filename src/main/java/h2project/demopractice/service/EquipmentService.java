package h2project.demopractice.service;

import h2project.demopractice.Model.Equipment;

import java.util.List;

public interface EquipmentService {


    public String createEquipment(Equipment equipment, Long vendorId);

    public String updateEquipment(Equipment equipment, Integer equipmentId);

    public List<Equipment> getAllEquipment();

    public Equipment getEquipmentById(Integer equipmentId);

    public String deleteEquipmentById(Integer equipmentId);


}
