package com.example.first.vo;

import lombok.Data;

@Data
public class Goods {
	private Integer	goodsNo;  // PK
	private String goodsTitle;
	private String goodsMemo;
	private Integer goodsPrice;
	private String goodsState; // enum 일단 String으로 받음
	private String updateDate;
	private String createDate;
	private Integer categoryNo;
}
