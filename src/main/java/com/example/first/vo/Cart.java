package com.example.first.vo;

import lombok.Data;

@Data
public class Cart {
	private Integer cartNo; // PK
	private String customerMail; //FK
	private Integer goodsNo; //FK
	private Integer cartAmount;
	private String updateDate;
	private String createDate;
}
