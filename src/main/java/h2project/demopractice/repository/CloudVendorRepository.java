package h2project.demopractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import h2project.demopractice.Model.CloudVendorModel;

public interface CloudVendorRepository  extends JpaRepository<CloudVendorModel, Long>{

}
