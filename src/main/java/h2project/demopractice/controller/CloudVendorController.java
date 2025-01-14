package h2project.demopractice.controller;

import h2project.demopractice.Model.CloudVendorModel;
import h2project.demopractice.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    @Autowired
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        super();
        this.cloudVendorService = cloudVendorService;
    }

    @PostMapping("/create")

    public String createCloudvendorDeatils(@RequestBody CloudVendorModel cloudVendorModel) throws Exception {
        cloudVendorService.createCloudVendor(cloudVendorModel);
        return "Cloud vendor created";
    }

    @PostMapping("/create/list")

    public ResponseEntity<Object> createCloudvendorDeatilslist(@RequestBody List<CloudVendorModel> cloudVendorModellist) {
        cloudVendorService.createCloudVendorList(cloudVendorModellist);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CloudVendorModel>> getAllCloudVendorDetails() {

        List<CloudVendorModel> all_vendors = cloudVendorService.getAllCloudVendor();
        return new ResponseEntity<>(all_vendors, HttpStatus.OK);

    }

    @GetMapping("/getall/{vendorId}")
    public ResponseEntity<CloudVendorModel> getVendorDetails(@PathVariable long vendorId) {
        CloudVendorModel vendorDetails = cloudVendorService.getCloudVendor(vendorId);

        return new ResponseEntity<CloudVendorModel>(vendorDetails, HttpStatus.OK);
    }

    @PutMapping("/update/{vendorId}")
    public String updateVendorDetails(@PathVariable long vendorId, @RequestBody CloudVendorModel cloudVendorModel) {
        cloudVendorService.updateCloudVendor(cloudVendorModel, vendorId);

        return "Cloud Vendor Updated!!!";
    }

    @DeleteMapping("/delete/{vendorId}")
    public String deleteVendorDetailsById(@PathVariable Long vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }

    @GetMapping("/sample")
    public String sampleString() {

       return "This is sample String";
    }


}

