package com.example.first.vo;

import lombok.Data;

@Data
public class Page {
	private Integer currentPage = 1;
	private Integer rowPerPage = 8;
	private Integer numPerPage = 10;
	
	public int getBeginRow() {
		return (this.currentPage-1)*this.rowPerPage;
	}
	public int getStartPage() {
		return (this.currentPage-1) / 10 * 10 +1;
	}
	
	public int getEndPage() {
		return this.getStartPage()+(this.numPerPage-1);
	}
	
	public int getLastPage(int totalRow) {
		int lastPage = totalRow / this.rowPerPage;
		if (totalRow % this.rowPerPage != 0) {
			lastPage++;
		}
		return lastPage;
	}
}
