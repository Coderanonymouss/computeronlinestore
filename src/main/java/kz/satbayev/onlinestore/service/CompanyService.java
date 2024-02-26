package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.Company;
import kz.satbayev.onlinestore.model.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Transactional
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: "+id));
    }

}
