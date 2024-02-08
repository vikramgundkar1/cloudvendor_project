package h2project.demopractice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int equipmentId;
    String equipmentName;
    String equipmentType;
    Long price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    private CloudVendorModel cloudVendorModel;

    public Equipment() {
    }

    public Equipment(String equipmentName, String equipmentType, Long price) {
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.price = price;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", price=" + price +
                ", cloudVendorModel=" + cloudVendorModel +
                '}';
    }
}

