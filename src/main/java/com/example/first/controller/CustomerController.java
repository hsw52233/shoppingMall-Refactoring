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
import com.example.first.service.CategoryService;
import com.example.first.service.CustomerService;
import com.example.first.service.GoodsService;
import com.example.first.service.OrdersService;
import com.example.first.service.PaymentService;
import com.example.first.vo.Address;
import com.example.first.vo.Category;
import com.example.first.vo.Customer;
import com.example.first.vo.Goods;
import com.example.first.vo.Page;
import com.example.first.vo.Payment;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	OrdersService ordersService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/staff/paymentComplete")
	public String paymentComplete(@RequestParam String customerMail, @RequestParam int paymentNo) {
		String paymentState = "결제완료";
		if (paymentNo != 0) {
			paymentState = "배송중";
		}
		int row = paymentService.getUpdatePaymentSate(paymentNo, paymentState);
		if (row == 1) {
			log.debug("결제상태 변경 성공");
			return "redirect:/staff/customerOne?customerMail="+customerMail;
		}
		return "redirect:/staff/customerOne?customerMail="+customerMail;
	}
	
	
	
	//하상우 ) 관리자 회원 상세 정보 조회
	
	@GetMapping("/staff/customerOne")
	public String customerOne(@RequestParam String customerMail, Model model, Page page) {
	    Customer customer = customerService.getCustomerOne(customerMail);
	    List<Address> address = addressService.getAddressOne(customerMail); // AddressService에서 해당 메서드 구현 필요
	    
	    Customer customermail = customerService.getCustomerMail(customerMail);
	    model.addAttribute("customerMail", customermail);
	    
	    model.addAttribute("customer", customer);
	    model.addAttribute("address", address);
	    
	   
		List<Map<String,Object>> orderList = ordersService.getSelectOrdersList(customerMail, page);
		model.addAttribute("orderList", orderList);
		
		
	    
	    return "staff/customerOne";
	}
	//하상우) 관리자 페이지에서 회원 삭제
	@GetMapping("/staff/removeCustomer")
	public String removeCustomer(@RequestParam String customerMail) {
		
		int deleteCustomer = customerService.removeCustomer(customerMail);
		
		return "redirect:/staff/customerList";
	}
	
	//하상우) 관리자 페이지에서 회원 리스트 
	
	@GetMapping("/staff/customerList")
	public String customersList(Model model) {
		
	List<Customer> customerList = customerService.getCustomerList();
	model.addAttribute("customerList", customerList);
		
		return "staff/customerList";
	}

	// customer/log(로그아웃)
	@GetMapping("/common/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 현재 세션정보를 종료시킴으로써 로그아웃처리시킴
		log.debug("로그아웃 성공");

		return "redirect:/common/home"; // 로그아웃했으니 다시 로그인페이지로 리다이렉트
	}

	// customer/register(회원가입)
	@GetMapping("/common/register")
	public String register() {
		return "common/register";
	}

	// customer/register(회원가입)
	@PostMapping("/common/register")
	public String registerAddCustomer(Model model,@RequestParam String loginId,	@RequestParam String password, @RequestParam String gender, @RequestParam String birth) {

		Customer registerCustomer = new Customer();
		registerCustomer.setCustomerMail(loginId);
		registerCustomer.setCustomerPw(password);
		registerCustomer.setCustomerGender(gender);
		registerCustomer.setCustomerBirth(birth);
		log.debug("registerCustomer: "+registerCustomer);
		

		// 2. customerService/addCustomer를 호출해준다
		Integer row = customerService.addCustomer(registerCustomer);
		if(row == 1) {
			model.addAttribute("msg","회원가입 성공");
			return "common/login";
		} else {
			model.addAttribute("msg", "회원가입 실패 : 중복 아이디");
			return "common/login";
		}
		
	}

	// customer/home (메인페이지)
	@GetMapping("/common/home")
	public String home(Model model, @RequestParam(defaultValue = "0") Integer categoryNo, Page page, @RequestParam(required = false) String searchTitle) {
		List<Map<String, Object>> goodsList = goodsService.getSelectGoodsList(categoryNo, page, searchTitle);
		List<Category> categoryList = categoryService.getCategoryList();
		int lastPage = goodsService.getLastPage(categoryNo,page);
		log.debug("goodsList : " + goodsList.toString());
		log.debug("페이지 : "+page.toString());
		log.debug("lastPage : "+lastPage);
		log.debug("numPerPage : "+page.getNumPerPage());
		log.debug("beginRow : "+page.getBeginRow());
		log.debug("startPage : "+page.getStartPage());
		log.debug("endPage : "+page.getEndPage());
		model.addAttribute("categoryNo",categoryNo);
		model.addAttribute("searchTitle",searchTitle);
		model.addAttribute("currentPage",page.getCurrentPage());
		model.addAttribute("startPage",page.getStartPage());
		model.addAttribute("numPerPage",page.getNumPerPage());
		model.addAttribute("endPage",page.getEndPage());
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("goodsList",goodsList);
		return "common/home";
	}

	// customer/login (로그인페이지)
	@GetMapping("/common/login")
	public String login() {
		return "common/login";
	}

	@PostMapping("/common/login")
	public String login(Model model, HttpSession session, @RequestParam(name = "loginId") String loginId,
			@RequestParam(name = "password") String password) {

		Customer paramCustomer = new Customer();
		paramCustomer.setCustomerMail(loginId);
		paramCustomer.setCustomerPw(password);

		Customer customerMail = customerService.login(paramCustomer);
		if (customerMail == null) {
			model.addAttribute("msg", "로그인실패");
			return "common/login";
		}
		log.debug("로그인 성공");
		session.setAttribute("customerMail", customerMail);

		return "redirect:/common/home";
	}

	// customer/customerOne (마이페이지)
	@GetMapping("/customer/customerOne")
	public String customerOne(Model model, HttpSession session, Page page) {
		page.setRowPerPage(3);
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		log.debug("customerMail : " + customerMail);
		Map<String, Object> customer = customerService.getCutomerOne(customerMail);
		log.debug("customer : " + customer);
		List<Map<String,Object>> orderList = ordersService.getSelectOrdersList(customerMail, page);
		log.debug("orderList : " + orderList);
		model.addAttribute("orderList", orderList);
		model.addAttribute("customer", customer);
		model.addAttribute("customerMail", customerMail);
		return "customer/customerOne";
	}
	
	// 비밀번호 변경
	@GetMapping("/customer/modifyCustomer")
	public String modifyCustomer(Model model, HttpSession session) {
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		model.addAttribute("customerMail", customerMail);
		return "customer/modifyCustomer";
	}
	
	// 비밀번호 변경
	@PostMapping("/customer/modifyCustomer")
	public String modifyCustomer(@RequestParam String customerMail, @RequestParam String pw, @RequestParam String rePw, Model model) {
		if(!pw.equals(rePw)) {
	        model.addAttribute("msg", "새 비밀번호와 확인 비밀번호가 일치하지 않습니다.");
	        return "customer/customerModify";  // 수정 폼으로 돌아가기
	    } else {
			 Customer customer = new Customer();
			    customer.setCustomerMail(customerMail);
			    customer.setCustomerPw(pw);
			int row = customerService.getModifyCustomer(customer);
			if(row == 1) {
				log.debug("비밀번호 변경 성공");
			} else {
				log.debug("변경 실패");
				return "customer/customerOne";
			}
		}
		return "redirect:/customer/customerOne?customerMail="+customerMail;
	}

}
