package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.first.service.CategoryService;
import com.example.first.vo.Category;

@Controller
public class CategoryController {
	
	
	@Autowired private CategoryService categoryService;
	
	//카테고리 리스트 수정
	@PostMapping("/staff/categoryModify")
	public String categoryModify(Category category) {
		
		int row = categoryService.categoryModify(category);
		
		return "redirect:/staff/categoryList";
	}
	
	@GetMapping("/staff/categoryModify")
	public String categoryModify(Model model, @RequestParam int categoryNo) {
		
		
	        Category category = categoryService.getCategoryNo(categoryNo);
	        model.addAttribute("category", category);
	    
	    return "staff/categoryModify";
	}
	
	
	
	
	//카테고리 리스트 삭제
	@GetMapping("/staff/removeCategory")
	public String removeCategory(@RequestParam int categoryNo) {
		int deleteRow = categoryService.remove(categoryNo);
		
		if(deleteRow == 0) {
			return "staff/categoryList";
		}
		
		return "redirect:/staff/categoryList";
	}
	
	//카테고리 리스트 추가
	@GetMapping("/staff/categoryAdd")
	public String categoryAdd() {
		return "staff/categoryAdd";
	}
	
	@PostMapping("/staff/categoryAdd")
	public String categoryAdd(Category category) {
		
		int row = categoryService.categoryAdd(category);
		if(row == 0 ) {
			return "redirect:/staff/categoryList";
		}
		
		System.out.println(category.getCategoryTitle());
		
		return "redirect:/staff/categoryList";
	}
	
	
	// 카테고리 리스트 조회
	@GetMapping("/staff/categoryList")
	public String categoryList(Model model) {
		
		List<Category> categoryList =categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		
		
		
		return "/staff/categoryList";
	}

}
