package com.example.first.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.service.BoardService;
import com.example.first.vo.Board;
import com.example.first.vo.Customer;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping ("/staff/reviewList")
	public String reviewList(Model model) {
		
		List<Board> reviewList = boardService.getReviewList();
		model.addAttribute("reviewList", reviewList);
		
		
		return "staff/reviewList";
	}
	
	
	
	@GetMapping("/staff/removeReview")
	public String removeReview(@RequestParam int ordersNo) {
		
		int deleteRow = boardService.remove(ordersNo);
		
		return "redirect:/staff/reviewList";
	}
	
	@GetMapping("/customer/reviews")
	public String reviews(Model model, @RequestParam int ordersNo, @RequestParam int paymentNo) {
	
		model.addAttribute("ordersNo",ordersNo);
		model.addAttribute("paymentNo",paymentNo);
		return "customer/reviews";
	}
	
	@PostMapping("/customer/reviews")
	public String reviews(Model model, Board board, @RequestParam int paymentNo) {
		int duplicate = boardService.getDuplicateReviews(board.getOrdersNo());
		if(duplicate == 1) {
			String msg = "후기 두번 입력은 불가능 합니다.";
			try {
				msg = URLEncoder.encode(msg, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "redirect:/customer/reviews?paymentNo="+paymentNo+"&ordersNo="+board.getOrdersNo()+"&msg="+msg;
		}
		log.debug("board : "+ board);
		int row = boardService.getInsertReviews(board);
		if(row == 1) {
			log.debug("후기 입력 성공");
			return "redirect:/customer/deliveryList?paymentNo="+paymentNo;
		}
		log.debug("후기 입력 실패");
		return "customer/reviews";
	}
	@GetMapping("/customer/reviewsList")
	public String reviewsList(Model model, HttpSession session) {
		String customerMail = ((Customer)(session).getAttribute("customerMail")).getCustomerMail();
		List<Map<String,Object>> reviewsList = boardService.getSelectReviewsListByCustomer(customerMail);
		model.addAttribute("reviewsList", reviewsList);
		return "customer/reviewsList";
	}
	
	@GetMapping("/customer/deleteReviews")
	public String deleteReviews(HttpSession session,@RequestParam int ordersNo) {
		String customerMail = ((Customer) (session).getAttribute("customerMail")).getCustomerMail();
		int remove = boardService.remove(ordersNo);
		if(remove == 1) {
			log.debug("댓글 삭제 성공");
			return "redirect:/customer/reviewsList?customerMail="+customerMail;
		}
		log.debug("댓글 삭제 실패");
		return "customer/reviewList";
	}
}
