package com.example.first.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsForm {
	private Integer goodsNo;
	private String goodsTitle;
	private String goodsMemo;
	private Integer goodsPrice;
	private String goodsState;
	private Integer categoryNo;
	private List<MultipartFile> goodsFile;
}
