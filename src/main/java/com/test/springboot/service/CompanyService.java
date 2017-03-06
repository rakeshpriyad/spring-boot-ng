package com.test.springboot.service;

import java.util.List;

import com.test.springboot.model.Company;

public interface CompanyService {

	Company findById(Long id);

	Company findByCompanyName(String companyName);

	void saveCompany(Company company);

	void updateCompany(Company company);

	void deleteCompanyById(Long id);

	void deleteAllCompanies();

	List<Company> findAllCompanies();

	boolean isCompanyExist(Company company);
}