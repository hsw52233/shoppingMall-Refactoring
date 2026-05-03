package com.example.first.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.service.OrdersService;
import com.example.first.vo.Customer;
import com.example.first.vo.Page;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

		
	
	// 이동윤 : 주문내역 리스트
	@GetMapping("/customer/ordersList")
	public String ordersList(Model model, HttpSession session, Page page) {
		page.setRowPerPage(10);
		String customerMail = ((Customer)(session.getAttribute("customerMail"))).getCustomerMail();
		List<Map<String,Object>> orderList = ordersService.getSelectOrdersList(customerMail, page);
		int lastPage = ordersService.getLastPageByOrderList(customerMail, page);
		log.debug("CurrentPage : "+page.getCurrentPage());
		log.debug("startPage : "+page.getStartPage());
		log.debug("numPerPage : "+page.getEndPage());
		log.debug("endPage : "+page.getNumPerPage());
		log.debug("lastPage : "+lastPage);
		model.addAttribute("currentPage", page.getCurrentPage());
		model.addAttribute("endPage", page.getEndPage());
		model.addAttribute("startPage", page.getStartPage());
		model.addAttribute("numPerPage", page.getNumPerPage());
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("orderList", orderList);
		return "customer/ordersList";
	}
	// payment 안에 있는 리스트
	@GetMapping("/customer/deliveryList")
	public String deliveryList(Model model,@RequestParam int paymentNo) {
		List<Map<String, Object>> deliveryList = ordersService.getSelectOrderListByPayment(paymentNo);
		model.addAttribute("deliveryList",deliveryList);
		return "customer/deliveryList";
	}
}
