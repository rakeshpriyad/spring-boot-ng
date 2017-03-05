package com.test.springboot.service;

import java.util.List;

import com.test.springboot.model.Category;

public interface CategoryService {

	Category findById(Long id);

	Category findByCategoryName(String categoryName);

	void saveCategory(Category category);

	void updateCategory(Category category);

	void deleteCategoryById(Long id);

	void deleteAllCategories();

	List<Category> findAllCategorys();

	boolean isCategoryExist(Category category);
}