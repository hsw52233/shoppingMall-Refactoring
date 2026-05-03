package com.example.first.vo;

import lombok.Data;

@Data
public class Orders {
	private Integer	ordersNo;  // PK
	private Integer	goodsNo;  // PK, FK
	private Integer ordersAmount;
	private Integer paymentNo; // FK
	private String updateDate;
	private String createDate;
}
