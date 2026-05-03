package com.example.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first.mapper.StaffMapper;
import com.example.first.vo.Staff;

@Service
@Transactional
public class StaffService {
	
	@Autowired StaffMapper staffMapper;
	
	
	public Staff getStaffNo(String staffId) {
		return staffMapper.getStaffNo(staffId);
	}
	
	public List<Staff> profile(String loginStaffId){
		return staffMapper.profile(loginStaffId);
	}
	
	public int staffAdd(Staff staff) {
		return staffMapper.staffAdd(staff);
	}
	
	// 스태프 조회
	
	public List<Staff> getStaffList(){
		return staffMapper.getStaffList();
	}
	
	public Staff login(Staff staff) {
		return staffMapper.login(staff);
	}
	

}
