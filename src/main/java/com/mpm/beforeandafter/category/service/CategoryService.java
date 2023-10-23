package com.mpm.beforeandafter.category.service;

import com.mpm.beforeandafter.category.model.Category;

import java.util.List;

public interface CategoryService {

    /*
       in the future create a DTO class to handle the flow of data between the client and the
       database.
     */

    Category createCategory(Category category);

     List<Category> getCategories();

    Category getCategoryById(Long categoryId);

    Category updateCategoryName(Long categoryId, String categoryName);

    void deleteCategory(Long categoryId);
}