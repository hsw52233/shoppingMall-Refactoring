package com.example.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.mapper.GoodsFileMapper;
import com.example.first.vo.GoodsFile;

@Service
public class GoodsFileService {

	@Autowired
	private GoodsFileMapper goodsFileMapper;
	
	public List<GoodsFile> getSelectGoodsFileListByGoods(int goodsNo){
		return goodsFileMapper.selectGoodsFileListByGoods(goodsNo);
	}
}
