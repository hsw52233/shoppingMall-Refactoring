package com.example.first.vo;

import lombok.Data;

@Data
public class Category {
	private Integer categoryNo; // PK
	private String categoryTitle;
	private String updateDate;
	private String createDate;
}
