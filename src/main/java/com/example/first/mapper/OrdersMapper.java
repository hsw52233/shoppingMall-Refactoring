package com.example.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Orders;

@Mapper
public interface OrdersMapper {
	public List<Map<String,Object>> selectOrdersList(Map<String, Object> paramMap);

	public int insertOrder(Orders orders);
	
	public List<Map<String,Object>> selectOrderListByPayment(int paymentNo);

	public int getTotalRowByCustomer(String customerMail);
}
