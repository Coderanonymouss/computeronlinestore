package kz.satbayev.onlinestore.model.repository;

import kz.satbayev.onlinestore.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
