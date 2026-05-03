package com.example.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first.mapper.CategoryMapper;

import com.example.first.vo.Category;

@Service
@Transactional
public class CategoryService {
	
	
	@Autowired CategoryMapper categoryMapper;
	
	public Category getCategoryNo(int categoryNo) {
		return categoryMapper.getCategoryNo(categoryNo);
	}
	
	public int categoryModify(Category category) {
		return categoryMapper.categoryModify(category);
	}
	
	public int remove(Integer categoryNo) {
		return categoryMapper.remove(categoryNo);
	}
	
	public List<Category> getCategoryList(){
		return categoryMapper.getCategoryList();
	}
	
	public int categoryAdd(Category category) {
		return categoryMapper.categoryAdd(category);
	}

}
