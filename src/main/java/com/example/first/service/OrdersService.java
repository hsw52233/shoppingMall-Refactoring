package com.example.first.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.mapper.OrdersMapper;
import com.example.first.vo.Page;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersMapper ordersMapper;

	// 고객 주문 정보
	public List<Map<String, Object>> getSelectOrdersList(String customerMail, Page page) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("customerMail", customerMail);
		paramMap.put("rowPerPage", page.getRowPerPage());
		paramMap.put("beginRow", page.getBeginRow());
		
		return ordersMapper.selectOrdersList(paramMap);
	}
	
	public int getLastPageByOrderList(String customerMail, Page page) {
		int totalRow = ordersMapper.getTotalRowByCustomer(customerMail);
		int lastPage = page.getLastPage(totalRow);
		return lastPage;
	}
	
	public List<Map<String,Object>> getSelectOrderListByPayment(int paymentNo){
		return ordersMapper.selectOrderListByPayment(paymentNo);
	}
	
	
}
