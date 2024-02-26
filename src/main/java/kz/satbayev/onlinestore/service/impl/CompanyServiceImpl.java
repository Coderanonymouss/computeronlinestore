package kz.satbayev.onlinestore.service.impl;

import kz.satbayev.onlinestore.model.entity.Company;
import kz.satbayev.onlinestore.model.repository.CompanyRepository;
import kz.satbayev.onlinestore.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid element id: "+id));
    }

}
