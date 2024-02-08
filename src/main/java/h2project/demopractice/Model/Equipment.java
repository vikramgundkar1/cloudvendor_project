package h2project.demopractice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    String equipmentName;
    String equipmentNumber;
    String equipmentType;
    Long price;

    public Equipment() {
    }

    public Equipment(String equipmentName, String equipmentNumber, String equipmentType, Long price) {
        this.equipmentName = equipmentName;
        this.equipmentNumber = equipmentNumber;
        this.equipmentType = equipmentType;
        this.price = price;
    }

    public int getId() {
        return id;
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
        return "CloudVendorEquipment{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentId='" + equipmentNumber + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", price=" + price +
                '}';
    }
}
