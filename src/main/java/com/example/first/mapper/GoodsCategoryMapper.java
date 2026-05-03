package com.example.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Category;
import com.example.first.vo.GoodsCategory;

@Mapper
public interface GoodsCategoryMapper {
	
	int remove(int goodsNo);
	
	List<Category> getCategoryList();
	
	
	int insertGoodsCategory(GoodsCategory goodsCategory);
	
	int deleteGoodsCategory(GoodsCategory goodsCategory);
}
