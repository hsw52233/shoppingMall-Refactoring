package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.service.GoodsCategoryService;
import com.example.first.vo.Category;
import com.example.first.vo.GoodsCategory;

@Controller
public class GoodsCategoryController {
	@Autowired
	GoodsCategoryService goodsCategoryService;
	
	
	
	@GetMapping("/staff/removeGoodsCategory")
	public String removeGoodsCategory(@RequestParam int goodsNo) {
		
		int deleteRow = goodsCategoryService.remove(goodsNo);
		
		
		return "redirect:/staff/goodsCategoryList";
		
	}
	
	@GetMapping("/staff/goodsCategoryList")
	public String goodsCategoryList(Model model) {
		
		List<Category> goodsCategoryList = goodsCategoryService.getCategoryList();
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		
		return "staff/goodsCategoryList";
	}
	
	
	
	 @GetMapping("/staff/goodsCategoryAdd")
		public String goodsCategoryAdd() {
			return "staff/goodsCategoryAdd";
		}
		
		@PostMapping("/staff/goodsCategoryAdd")
		public String goodsCategoryAdd(GoodsCategory goodsCategory) {
			
			int row = goodsCategoryService.goodsCategoryAdd(goodsCategory);
			if(row == 0 ) {
				return "redirect:/staff/goodsCategoryList";
			}
			
			return "redirect:/staff/goodsCategoryList";
		}

}
