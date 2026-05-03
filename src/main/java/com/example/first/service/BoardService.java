package com.example.first.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.mapper.BoardMapper;
import com.example.first.vo.Board;
import com.example.first.vo.Orders;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;


	public List<Board> getReviewList(){
		return boardMapper.getReviewList();
	}
	
	public int remove(int ordersNo) {
		return boardMapper.remove(ordersNo);
	}

	// 이동윤 후기 추가
	public int getInsertReviews(Board board) {
		return boardMapper.insertReviews(board);
	}

	// 이동윤 중복 확인 로직
	public int getDuplicateReviews(int oredersNo) {
		return boardMapper.selectReviewsByOrders(oredersNo);
	}

	// 이동윤 상품별 후기 리스트
	public List<Map<String, Object>> getReviewsListByGoods(Integer goodsNo) {
		return boardMapper.selectReviewListByGoods(goodsNo);
	}

	// 이동윤 고객별 후기 리스트
	public List<Map<String,Object>> getSelectReviewsListByCustomer(String customerMail) {
		return boardMapper.selectReviewsListByCustomer(customerMail);
	}

}
