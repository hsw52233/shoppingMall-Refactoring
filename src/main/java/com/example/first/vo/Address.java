package com.example.first.vo;

import lombok.Data;

@Data
public class Address {
	private Integer addressNo; // PK
	private String customerMail; // FK
	private String addressDetail;
	private String updateDate;
	private String createDate;
	
}
