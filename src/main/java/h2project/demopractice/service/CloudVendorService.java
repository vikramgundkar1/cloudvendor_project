package h2project.demopractice.service;

import java.util.List;


import h2project.demopractice.Model.CloudVendorModel;

public interface CloudVendorService {
	
	 String createCloudVendor(CloudVendorModel cloudVendorModel);

	 String createCloudVendorList(List<CloudVendorModel> cloudVendorlist);

	 String updateCloudVendor(CloudVendorModel cloudVendorModel, Long vendorId);

	 List<CloudVendorModel> getAllCloudVendor();

	 CloudVendorModel getCloudVendor(Long vendorId);


	 String deleteCloudVendor(Long vendorId);






}
