package com.example.first.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Address;

@Mapper
public interface AddressMapper {
	
	int removeAddress(String customerMail);
	
	List<Address> getAddressByCustomerMail(String customerMail);
	
	
	List<Map<String,Object>> selectAddressList(String customerMail);
	
	int insertAddAddress(Address address);
}
