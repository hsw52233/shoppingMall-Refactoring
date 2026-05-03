package com.example.first.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first.mapper.CartMapper;
import com.example.first.mapper.OrdersMapper;
import com.example.first.mapper.PaymentMapper;
import com.example.first.vo.Orders;
import com.example.first.vo.Payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class PaymentService {

	@Autowired
	private PaymentMapper paymentMapper;
	
	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	
	public int paymentModifyActive(Payment payment) {
		return paymentMapper.paymentModifyActive(payment);
	}
	
	
	
	public void getInsertPayment(int addressNo, int paymentPrice, String paymentMethod, String CustomerMail) {
		Payment payment = new Payment();
		payment.setAddressNo(addressNo);
		payment.setPaymentPrice(paymentPrice);
		payment.setPaymentMethod(paymentMethod);
		// 결제 테이블 행 추가
		int PaymentRow = paymentMapper.insertPayment(payment);
		if(PaymentRow == 0) {
			log.debug("paymentInsert 실패");
			return;
		}
		List<Map<String, Object>> cartList = cartMapper.selectcartList(CustomerMail);
		log.debug("cartList : "+cartList);
		log.debug("paymentNo :"+payment.getPaymentNo());
		// 주문목록에 그대로 추가
		for(Map cart : cartList) {
			Orders orders = new Orders();
			orders.setGoodsNo((int)cart.get("goodsNo"));
			orders.setOrdersAmount((int)cart.get("cartAmount"));
			orders.setPaymentNo(payment.getPaymentNo());
			int orderRow = ordersMapper.insertOrder(orders);
			
			if(orderRow ==0) {
				log.debug("주문목록 추가 실패");
				return;
			}
		}
		// 장바구니 삭제
		int cartRow = cartMapper.deleteCartAll(CustomerMail);
		if(cartRow == 0) {
			log.debug("cartDelete 실패");
			return;
		}
	}
	// paymentState 변경
	public int getUpdatePaymentSate(int paymentNo, String paymentState) {
		Payment payment = new Payment();
		payment.setPaymentNo(paymentNo);
		payment.setPaymentState(paymentState);
		return paymentMapper.updatePaymentState(payment);
	}
}
