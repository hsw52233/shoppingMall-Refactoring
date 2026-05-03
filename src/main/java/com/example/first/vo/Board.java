package com.example.first.vo;

import lombok.Data;

@Data
public class Board {
	private Integer ordersNo; // PK
	private String boardContent; // FK
	private String updateDate;
	private String createDate;
}
