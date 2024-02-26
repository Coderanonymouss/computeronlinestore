package kz.satbayev.onlinestore.service;

import kz.satbayev.onlinestore.model.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    Company addCompany(Company company);

    Company saveCompany(Company company);

    Company getCompany(Long id);

}
