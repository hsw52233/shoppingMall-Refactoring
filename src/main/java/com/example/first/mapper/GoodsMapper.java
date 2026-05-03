package com.example.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Goods;

@Mapper
public interface GoodsMapper {
	 
	
	int removeGoodsFile(int goodsNo);
	
	int removeGoods(int goodsNo);
	
	int selectStaffCount();
	
	int goodsModifyActive(Goods goods);
	
	//관리자 상품 수정
	
	int goodsModify(Goods goods);
	
	Goods getGoodsNo(int goodsNo);
	
	
	//관리자 상품 추가
	
	int goodsAdd(Goods goods);
	
	// 관리자 상품 리스트 조회
	
	List<Map<String,Object>> getGoodsList();
	
	// 굿즈 상세정보
	public Map<String,Object> selectGoodsOne(int goodsNo);
	
	public List<Map<String, Object>> selectGoodsList(Map<String,Object> paramMap);
	
	public int goodsLastPage(int categoryNo);
}
