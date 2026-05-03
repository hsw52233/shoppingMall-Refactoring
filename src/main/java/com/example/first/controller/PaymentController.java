package com.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.service.CustomerService;
import com.example.first.service.PaymentService;
import com.example.first.vo.Customer;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private CustomerService customerService;

	// 결제 추가트랜잭션
	@PostMapping("/customer/payment")
	public String payment(HttpSession session, int paymentPrice, int addressNo, String paymentMethod) {
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		paymentService.getInsertPayment(addressNo, paymentPrice, paymentMethod, customerMail);
		return "customer/paymentComplete";
	}

	@GetMapping("/customer/paymentComplete")
	public String paymentComplete(HttpSession session, @RequestParam int paymentNo) {
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		String paymentState = "배송중";
		if (paymentNo != 0) {
			paymentState = "배송완료";
		}
		int row = paymentService.getUpdatePaymentSate(paymentNo, paymentState);
		if (row == 1) {
			log.debug("결제상태 변경 성공");
			return "redirect:/customer/ordersList?customerMail="+customerMail;
		}
		return "customer/orderList";
	}
}
