package com.example.first.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.mapper.AddressMapper;
import com.example.first.vo.Address;

@Service
public class AddressService {

	@Autowired
	private AddressMapper addressMapper;
	
	public int removeAddress(String customerMail) {
		return addressMapper.removeAddress(customerMail);
	}
	
	public List<Address> getAddressOne(String customerMail) {
        return addressMapper.getAddressByCustomerMail(customerMail);
    }
	
	// 고객 주소 리스트
	public List<Map<String,Object>> getAddressList(String customerMail){
		return addressMapper.selectAddressList(customerMail);
	}
	
	// 고객 주소 추가
	
	public int getAddAddress(Address address) {
		return addressMapper.insertAddAddress(address);
	}
}
