package com.example.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Customer;

@Mapper
public interface CustomerMapper {
	
	// 하상우) 관리자에서 회원 상세 정보
	Customer getCustomerMail(String customerMail);
	
	Customer getCustomerOne(String customerMail);
	
	//하상우 ) 관리자에서 회원 삭제
	
	int removeCustomer(String customerMail);
	
	//하상우) 관리자에서 회원 리스트 조회
	
	List<Customer> getCustomerList();
	

	Integer insertCustomer(Customer registerCustomer);

	Customer login(Customer customer);

	Map<String, Object> selectCustomerOne(String customerMail);

	int updateCustomer(Customer Customer);

}
