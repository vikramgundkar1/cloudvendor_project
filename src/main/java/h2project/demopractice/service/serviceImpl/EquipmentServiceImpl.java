package h2project.demopractice.service.serviceImpl;

import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.Model.Equipment;
import h2project.demopractice.exceptions.CloudVendorNotFoundException;
import h2project.demopractice.repository.CloudVendorRepository;
import h2project.demopractice.repository.EquipmentRepository;
import h2project.demopractice.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    CloudVendorRepository cloudVendorRepository;

    private Equipment equipment;

    private List<Equipment> equipments;

    @Override
    public String createEquipment(List<Equipment> equipments, Long vendorId) {

        Optional<CloudVendorModel> cloudVendorOptional = cloudVendorRepository.findById(vendorId);
        if (cloudVendorOptional.isPresent()) {

            CloudVendorModel cloudvendorModel = cloudVendorOptional.get();
            if (equipments.isEmpty()) {
                throw new CloudVendorNotFoundException("please add at least one equipment");
            } else {

                equipments.forEach(a -> {a.setCloudVendorModel(cloudvendorModel);
                            equipmentRepository.saveAll(equipments);
                }

                );

            }

        } else {
            throw new CloudVendorNotFoundException("Cloud Vendor Not found");
        }
        return "Equipment Added Successfully";
    }

    @Override
    public String updateEquipment(Equipment equipment, Integer equipmentId) {

        Optional<Equipment> checkavilablity = equipmentRepository.findById(equipmentId);
        if (checkavilablity.isPresent()) {
            Equipment existingEquipment = checkavilablity.get();

            existingEquipment.setEquipmentName(equipment.getEquipmentName());
            existingEquipment.setEquipmentType(equipment.getEquipmentType());
            existingEquipment.setPrice(equipment.getPrice());

            equipmentRepository.save(existingEquipment);
        } else {
            throw new CloudVendorNotFoundException("Eqipment not found");
        }

        return "Equipment Updated Successfully";
    }

    @Override
    public List<Equipment> getAllEquipment() {

        List<Equipment> eqipmentDeatils = equipmentRepository.findAll();

        return eqipmentDeatils;
    }

    @Override
    public Equipment getEquipmentById(Integer equipmentId) {

        Optional<Equipment> equipmentDetails = equipmentRepository.findById(equipmentId);
        if (equipmentDetails.isPresent()) {
            return equipmentDetails.get();
        } else {
            throw new CloudVendorNotFoundException("Equipments not found");
        }

    }

    @Override
    public String deleteEquipmentById(Integer equipmentId) {

        getEquipmentById(equipmentId);
        equipmentRepository.deleteById(equipmentId);

        return "Equipment deleted Successfully";
    }
}
