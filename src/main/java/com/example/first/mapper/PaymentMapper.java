package com.example.first.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.Payment;

@Mapper
public interface PaymentMapper {
	
	int paymentModifyActive(Payment payment);
	
	// 결제 추가
	public int insertPayment(Payment payment);
	// 결제 상태 변경
	public int updatePaymentState(Payment payment);
}
