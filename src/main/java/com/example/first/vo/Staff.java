package com.example.first.vo;

import lombok.Data;

@Data
public class Staff {
	private Integer staffNo; // PK
	private String staffId;
	private String staffPw;
	private String updateDate;
	private String createDate;
}
