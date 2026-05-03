package com.example.first.vo;

import lombok.Data;

@Data
public class GoodsCategory {
	private Integer	goodsNo;  // PK
	private Integer	categoryNo;  // PK, FK
	private String updateDate;
	private String createDate;
}
