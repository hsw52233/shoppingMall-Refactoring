package com.example.first.vo;

import lombok.Data;

@Data
public class Customer {
	private String customerMail; // PK
	private String customerPw;
	private String customerBirth;
	private String customerGender; // enum 일단 String으로 받음
	private String updateDate;
	private String createDate;
}
