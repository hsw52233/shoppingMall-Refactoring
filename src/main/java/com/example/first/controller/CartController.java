package com.example.first.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.service.AddressService;
import com.example.first.service.CartService;
import com.example.first.vo.Cart;
import com.example.first.vo.Customer;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;

	// Author : 이동윤 장바구니 리스트
	@GetMapping("/customer/cartList")
	public String cartList(Model model, HttpSession session) {
		String customerMail = ((Customer)(session).getAttribute("customerMail")).getCustomerMail();
		List<Map<String, Object>> cartList = cartService.getSelectCartList(customerMail);
		List<Map<String, Object>> addressList = addressService.getAddressList(customerMail);
		model.addAttribute("addressList",addressList);
		// 결제 총액
		long paymentPrice = cartService.getCartByPayment(cartList);
		log.debug("paymentPrice :" + paymentPrice);
		model.addAttribute("cartList", cartList);
		model.addAttribute("addressList", addressList);
		model.addAttribute("paymentPrice", paymentPrice);
		return "customer/cartList";
	}

	// Author : 이동윤 장바구니 추가
	@PostMapping("/customer/addCart")
	public String addCart(HttpSession session, Cart cart) {	
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		cart.setCustomerMail(customerMail);
		log.debug("cart : "+cart);
		int row = cartService.getInsertCart(cart);
		if(row == 1) {
			return "redirect:/customer/cartList?customerMail="+cart.getCustomerMail();
		}
		log.debug("장바구니 추가 실패");
		return "common/home";
	}
	
	@GetMapping("/customer/removeCart")
	public String removeCart(HttpSession session, int cartNo) {
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		int row = cartService.getRemoveCart(cartNo);
		if(row == 1) {
			log.debug("삭제 성공");
			return "redirect:/customer/cartList?customerMail="+customerMail;
		}
		log.debug("삭제 실패");
		return "/customer/customerOne";
	}
}
