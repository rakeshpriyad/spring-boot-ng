package com.test.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.springboot.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByCompanyName(String companyName);
}
