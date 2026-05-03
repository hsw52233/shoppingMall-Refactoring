package com.example.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Cart;

@Mapper
public interface CartMapper {
	
	int removeCart(String customerMail);
	
	// Author : 이동윤
	public List<Map<String,Object>> selectcartList(String customerMail);
	
	public int insertCart(Cart cart);
	
	// 장바구니 테이블 데이터 삭제
	public int deleteCartByCartNo(int cartNo);
	// 장바구니 테이블 데이터 전체 삭제
	public int deleteCartAll(String customerMail);
	
}
