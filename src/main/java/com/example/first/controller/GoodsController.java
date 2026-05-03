package com.example.first.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.first.service.BoardService;
import com.example.first.service.GoodsCategoryService;
import com.example.first.service.GoodsFileService;
import com.example.first.service.GoodsService;
import com.example.first.vo.Category;
import com.example.first.vo.Goods;
import com.example.first.vo.GoodsFile;
import com.example.first.vo.GoodsForm;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class GoodsController {
	 
	@Autowired
	private GoodsCategoryService goodsCategoryService;

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private GoodsFileService goodsFileService;
	
	
	// 하상우) 상품 삭제
	@GetMapping("staff/removegoods")
	public String removeGoods(@RequestParam int goodsNo) {
		goodsService.removeGoods(goodsNo);
		
		
		return "redirect:/staff/goodsList";
	}
	
	
	
	// 하상우) 재고 활성화
	
	@GetMapping("/staff/modifyGoodsActive")
	public String modifyGoodsActive(@RequestParam("goodsNo") int goodsNo, @RequestParam("goodsState") String goodsState) {
	    Goods goods = new Goods();
	    goods.setGoodsNo(goodsNo);
	    
	    if ("재고있음".equals(goodsState)) {
	        goods.setGoodsState("재고없음");
	    } else {
	        goods.setGoodsState("재고있음");
	    }
	    
	    goodsService.goodsModifyActive(goods);
	    return "redirect:/staff/goodsList";
	}
	
	
	
	// 하상우) 상품 수정
	@PostMapping("/staff/goodsModify")
	public String goodsModify(Goods goods) {
		
		int row = goodsService.goodsModify(goods);
		
		System.out.println(row);
		
		
		return "redirect:/staff/goodsList";
	}
	
	@GetMapping("/staff/goodsModify")
	public String categoryModify(Model model, @RequestParam int goodsNo) {
		
		
	        Goods goods = goodsService.getGoodsNo(goodsNo);
	        model.addAttribute("goods", goods);
	    
	    return "staff/goodsModify";
	}
	
	// 하상우) 상품 추가

	    @GetMapping("/staff/goodsAdd")
		public String goodsAdd(Model model) {
	    	List<Category> categoryList = goodsCategoryService.getCategoryList();
			model.addAttribute("categoryList",categoryList);
	    	return "staff/goodsAdd";
		}
		
		@PostMapping("/staff/goodsAdd")
		public String goodsAdd(HttpSession session, Model model, GoodsForm goodsForm) {
			log.debug("goodsForm : "+goodsForm.toString());
			List<MultipartFile> list = goodsForm.getGoodsFile();
			if(list != null && list.size() != 0) {
				for(MultipartFile file : list) {
					if(!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
						model.addAttribute("msg","jpg , png 파일만 입력 가능");
						return "staff/goodsAdd";
					}
				}
			}
			String path = session.getServletContext().getRealPath("/upload/");
			goodsService.goodsAdd(goodsForm,path);
			return "redirect:/staff/goodsList";
		}
	
	//하상우 ) 관리자 페이지 상품 리스트
	@GetMapping("/staff/goodsList")
	public String goodsList(Model model) {

		List<Map<String,Object>> goodsList = goodsService.getGoodsList();

		model.addAttribute("goodsList", goodsList);
		
		
		return "staff/goodsList";
		
	}

	// Author : 이동윤 상품상세정보
	@GetMapping("/common/goodsOne")
	public String goodsOne(Model model, @RequestParam Integer goodsNo) {
		Map<String, Object> goods = goodsService.getGoodsOne(goodsNo);
		List<GoodsFile> goodsFileList = goodsFileService.getSelectGoodsFileListByGoods(goodsNo);
		List<Map<String, Object>> reviewsList = boardService.getReviewsListByGoods(goodsNo);
		log.debug(goods.toString());
		log.debug(goodsFileList.toString());
		log.debug(reviewsList.toString());
		model.addAttribute("goods", goods);
		model.addAttribute("goodsFileList", goodsFileList);
		model.addAttribute("reviewsList", reviewsList);
		return "common/goodsOne";
	}
	
	// Author : 이동윤 상품상세정보
	@GetMapping("/staff/goodsOne")
	public String goodsOneByStaff(Model model, @RequestParam Integer goodsNo) {
		Map<String, Object> goods = goodsService.getGoodsOne(goodsNo);
		model.addAttribute("goods", goods);
		return "staff/goodsOne";
	}

}
