package com.avaya.shopping_backend.dao;

import java.util.List;

import com.avaya.shopping_backend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
