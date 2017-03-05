package com.test.springboot.service;

import java.util.List;

import com.test.springboot.model.Category;
import com.test.springboot.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}

	public Category findByCategoryName(String categoryName) {
		return categoryRepository.findByCategoryName(categoryName);
	}

	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	public void updateCategory(Category category){
		saveCategory(category);
	}

	public void deleteCategoryById(Long id){
		categoryRepository.delete(id);
	}

	public void deleteAllCategories(){
		categoryRepository.deleteAll();
	}

	public List<Category> findAllCategorys(){
		return categoryRepository.findAll();
	}

	public boolean isCategoryExist(Category category) {
		return findByCategoryName(category.getCategoryName()) != null;
	}

}
