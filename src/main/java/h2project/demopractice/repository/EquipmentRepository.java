package h2project.demopractice.repository;


import h2project.demopractice.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {


}
