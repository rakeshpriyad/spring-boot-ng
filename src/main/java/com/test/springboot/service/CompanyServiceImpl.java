package com.test.springboot.service;

import java.util.List;

import com.test.springboot.model.Company;
import com.test.springboot.repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;

	public Company findById(Long id) {
		return companyRepository.findOne(id);
	}

	public Company findByCompanyName(String companyName) {
		return companyRepository.findByCompanyName(companyName);
	}

	public void saveCompany(Company company) {
		companyRepository.save(company);
	}

	public void updateCompany(Company company){
		saveCompany(company);
	}

	public void deleteCompanyById(Long id){
		companyRepository.delete(id);
	}

	public void deleteAllCompanies(){
		companyRepository.deleteAll();
	}

	public List<Company> findAllCompanies(){
		return companyRepository.findAll();
	}

	public boolean isCompanyExist(Company company) {
		return findByCompanyName(company.getCompanyName()) != null;
	}

}
