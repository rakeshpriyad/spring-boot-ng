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

import com.test.springboot.model.Category;
import com.test.springboot.service.CategoryService;
import com.test.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/category")
public class CategoryController {

	public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Categorys---------------------------------------------

	@RequestMapping(value = "loadAllCategories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> listAllCategories() {
		List<Category> categorys = categoryService.findAllCategorys();
		if (categorys.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Category>>(categorys, HttpStatus.OK);
	}

	// -------------------Retrieve Single Category------------------------------------------

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCategory(@PathVariable("id") long id) {
		logger.info("Fetching Category with id {}", id);
		Category Category = categoryService.findById(id);
		if (Category == null) {
			logger.error("Category with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Category with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Category>(Category, HttpStatus.OK);
	}

	// -------------------Create a Category-------------------------------------------

	@RequestMapping(value = "createCategory", method = RequestMethod.POST)
	public ResponseEntity<?> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Category : {}", category);

		if (categoryService.isCategoryExist(category)) {
			logger.error("Unable to create. A Category with name {} already exist", category.getCategoryName());
			return new ResponseEntity<Object>(new CustomErrorType("Unable to create. A Category with name " + 
			category.getCategoryName() + " already exist."),HttpStatus.CONFLICT);
		}
		categoryService.saveCategory(category);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getCategoryId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Category ------------------------------------------------

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
		logger.info("Updating Category with id {}", id);

		Category currentCategory = categoryService.findById(id);

		if (currentCategory == null) {
			logger.error("Unable to update. Category with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Unable to upate. Category with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCategory.setCategoryName(category.getCategoryName());
		currentCategory.setDescription(category.getDescription());

		categoryService.updateCategory(currentCategory);
		return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
	}

	// ------------------- Delete a Category-----------------------------------------

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Category with id {}", id);

		Category Category = categoryService.findById(id);
		if (Category == null) {
			logger.error("Unable to delete. Category with id {} not found.", id);
			return new ResponseEntity<Object>(new CustomErrorType("Unable to delete. Category with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		categoryService.deleteCategoryById(id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Categorys-----------------------------

	@RequestMapping(value = "/deleteall/", method = RequestMethod.DELETE)
	public ResponseEntity<Category> deleteAllCategories() {
		logger.info("Deleting All Categories");

		categoryService.deleteAllCategories();
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}

}