package com.test.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.springboot.model.Company;
import com.test.springboot.service.CompanyService;
import com.test.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/company")
public class CompanyController {

	public static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	CompanyService companyService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Companys---------------------------------------------

	@RequestMapping(value = "loadAllCompanies", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> listAllCompanies() {
		List<Company> companys = companyService.findAllCompanies();
		if (companys.isEmpty()) {
			return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Company>>(companys, HttpStatus.OK);
	}

	// -------------------Retrieve Single Company------------------------------------------

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCompany(@PathVariable("id") long id) {
		logger.info("Fetching Company with id {}", id);
		Company Company = companyService.findById(id);
		if (Company == null) {
			logger.error("Company with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Company with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Company>(Company, HttpStatus.OK);
	}

	// -------------------Create a Company-------------------------------------------

	@RequestMapping(value = "createCompany", method = RequestMethod.POST)
	public ResponseEntity<?> createCompany(@RequestBody Company company, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Company : {}", company);

		if (companyService.isCompanyExist(company)) {
			logger.error("Unable to create. A Company with name {} already exist", company.getCompanyName());
			return new ResponseEntity<Object>(new CustomErrorType("Unable to create. A Company with name " + 
			company.getCompanyName() + " already exist."),HttpStatus.CONFLICT);
		}
		companyService.saveCompany(company);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/company/{id}").buildAndExpand(company.getCompanyId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Company ------------------------------------------------

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
		logger.info("Updating Company with id {}", id);

		Company currentCompany = companyService.findById(id);

		if (currentCompany == null) {
			logger.error("Unable to update. Company with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Unable to upate. Company with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCompany.setCompanyName(company.getCompanyName());
		currentCompany.setDescription(company.getDescription());

		companyService.updateCompany(currentCompany);
		return new ResponseEntity<Company>(currentCompany, HttpStatus.OK);
	}

	// ------------------- Delete a Company-----------------------------------------

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCompany(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Company with id {}", id);

		Company Company = companyService.findById(id);
		if (Company == null) {
			logger.error("Unable to delete. Company with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Unable to delete. Company with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		companyService.deleteCompanyById(id);
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Companys-----------------------------

	@RequestMapping(value = "/deleteall/", method = RequestMethod.DELETE)
	public ResponseEntity<Company> deleteAllCompanies() {
		logger.info("Deleting All Companies");

		companyService.deleteAllCompanies();
		return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
	}

}