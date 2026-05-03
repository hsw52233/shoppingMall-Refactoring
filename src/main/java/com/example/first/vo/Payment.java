package com.example.first.vo;

import lombok.Data;

@Data
public class Payment {
	private Integer paymentNo; // PK
	private Integer addressNo; // FK
	private Integer paymentPrice;
	private String paymentMethod;
	private String paymentState;
}
