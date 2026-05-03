package com.example.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Category;

@Mapper
public interface CategoryMapper {
	
	List<Category> getCategoryList();
	
	int categoryAdd(Category category);
	
	int remove(Integer categoryNo);
	
	int categoryModify(Category category);
	
	Category getCategoryNo(int categoryNo);

}
