package com.example.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first.vo.GoodsFile;

@Mapper
public interface GoodsFileMapper {

	int insertGoodsFile(GoodsFile goodsFile);

	List<GoodsFile> selectGoodsFileListByGoods(int goodsNo);

}
