package h2project.demopractice.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vendor_details")
public class CloudVendorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String vendorName;
    String vendorAddress;
    String vendorNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cloudVendorModel", cascade = CascadeType.ALL)
    private List<Equipment> equipment;

    public CloudVendorModel() {
    }

    public CloudVendorModel(String vendorName, String vendorAddress, String vendorNumber) {
        super();
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorNumber = vendorNumber;
    }

    public CloudVendorModel(long id, String vendorName, String vendorAddress, String vendorNumber) {
        this.id = id;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorNumber = vendorNumber;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public long getVendorId() {
        return id;
    }

    public void setVendorId(long vendorId) {
        this.id = vendorId;
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

    @Override
    public String toString() {
        return "CloudVendorModel [id=" + id + ", vendorName=" + vendorName + ", vendorAddress="
                + vendorAddress + ", vendorNumber=" + vendorNumber + "]";
    }

}
