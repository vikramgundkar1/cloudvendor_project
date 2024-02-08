package h2project.demopractice.service.serviceImpl;

import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.exceptions.CloudVendorDetailsEmptyListAdded;
import h2project.demopractice.exceptions.CloudVendorNotFoundException;
import h2project.demopractice.repository.CloudVendorRepository;
import h2project.demopractice.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    @Autowired
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        super();
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendorModel cloudVendorModel) {

        cloudVendorRepository.save(cloudVendorModel);

        return "Created successfully";


    }

    @Override
    public String createCloudVendorList(List<CloudVendorModel> cloudVendorlist) {
        // Optional<List<CloudVendorModel>> check = Optional.of(cloudVendorlist);
        if (!cloudVendorlist.isEmpty()) {
            cloudVendorRepository.saveAll(cloudVendorlist);

        } else {
            throw new CloudVendorDetailsEmptyListAdded("Please add at least one cloud vendor and then submit");
        }

        return "List added successfully";
    }


    @Override
    public String updateCloudVendor(CloudVendorModel cloudVendorModel, Long vendorId) {

        CloudVendorModel vendorModel = getCloudVendor(vendorId);

        vendorModel.setVendorName(cloudVendorModel.getVendorName());
        vendorModel.setVendorAddress(cloudVendorModel.getVendorAddress());
        vendorModel.setVendorNumber(cloudVendorModel.getVendorNumber());
        cloudVendorRepository.save(vendorModel);

        return "Successfully updated vendor details";
    }

    @Override
    public CloudVendorModel getCloudVendor(Long vendorId) {
        CloudVendorModel cloudVModel;

        Optional<CloudVendorModel> check = cloudVendorRepository.findById(vendorId);

        if (check.isPresent()) {
            cloudVModel = check.get();
        } else {
            throw new CloudVendorNotFoundException("Vendor details not found");

        }
        return cloudVModel;

    }

    @Override
    public String deleteCloudVendor(Long vendorId) {

        getCloudVendor(vendorId);
        cloudVendorRepository.deleteById(vendorId);
        return "deleted successfully";
    }

    @Override
    public List<CloudVendorModel> getAllCloudVendor() {

        return cloudVendorRepository.findAll();

    }
}
