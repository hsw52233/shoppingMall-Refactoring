package com.example.first.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first.mapper.AddressMapper;
import com.example.first.mapper.CartMapper;
import com.example.first.mapper.CustomerMapper;
import com.example.first.vo.Customer;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	private AddressMapper addressMapper;
	
	// 하상우) 관리자 회원 상세 정보
	
	public Customer getCustomerMail(String customerMail) {
		return customerMapper.getCustomerMail(customerMail);
	}
	
	public Customer getCustomerOne(String customerMail) {
	    return customerMapper.getCustomerOne(customerMail);  
	}
	
	public int removeCustomer(String customerMail) {
		
		cartMapper.removeCart(customerMail);
		
		addressMapper.removeAddress(customerMail);
		
		return customerMapper.removeCustomer(customerMail);
	}
	
	public List<Customer> getCustomerList() {
		return customerMapper.getCustomerList();
	}
	
	// addCustomer값 안에 CustomerController에서 받아온 registerCustomer값을 넘겨줌
	// CustomerMapper/insertCustomer식안에 registerCustomer값을 넘겨줌
	public Integer addCustomer(Customer registerCustomer) {
		// customer 유효성 검사
		Customer login = customerMapper.login(registerCustomer);
		if(login != null) {
			return 0;
		}
		return customerMapper.insertCustomer(registerCustomer);
	}
	
	public Customer login(Customer paramCustomer) {
		return customerMapper.login(paramCustomer);
	}

	public Map<String, Object> getCutomerOne(String customerMail) {
		return customerMapper.selectCustomerOne(customerMail);
	}

	public int getModifyCustomer(Customer customer) {
		return customerMapper.updateCustomer(customer);
	}

}
