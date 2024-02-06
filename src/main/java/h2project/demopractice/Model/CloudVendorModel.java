package h2project.demopractice.Model;

import jakarta.persistence.*;

@Entity
@Table(name="vendor_details")
public class CloudVendorModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long vendorId;
	String vendorName;
	String vendorAddress;
	String vendorNumber;



	public CloudVendorModel() {
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}


	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getVendorNumber() {
		return vendorNumber;
	}
	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}
	public CloudVendorModel(String vendorName, String vendorAddress, String vendorNumber) {
		super();
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorNumber = vendorNumber;
	}

	public CloudVendorModel(long vendorId, String vendorName, String vendorAddress, String vendorNumber) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorNumber = vendorNumber;
	}

	@Override
	public String toString() {
		return "CloudVendorModel [vendorId=" + vendorId + ", vendorName=" + vendorName + ", vendorAddress="
				+ vendorAddress + ", vendorNumber=" + vendorNumber + "]";
	}
	


}
