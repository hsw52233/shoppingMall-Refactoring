package com.example.first.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.first.mapper.GoodsCategoryMapper;
import com.example.first.mapper.GoodsFileMapper;
import com.example.first.mapper.GoodsMapper;
import com.example.first.vo.Goods;
import com.example.first.vo.GoodsCategory;
import com.example.first.vo.GoodsFile;
import com.example.first.vo.GoodsForm;
import com.example.first.vo.Page;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class GoodsService {
 
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private GoodsFileMapper goodsFileMapper;
	
	
	
	public void removeGoods(int goodsNo) {
        goodsMapper.removeGoodsFile(goodsNo); 
        goodsMapper.removeGoods(goodsNo); 
    }
	// 하상우) 재고 활성화

	public int goodsModifyActive(Goods goods) {
		return goodsMapper.goodsModifyActive(goods);
	}

	// 하상우) 관리자 상품 수정

	public Goods getGoodsNo(int goodsNo) {
		return goodsMapper.getGoodsNo(goodsNo);
	}

	public int goodsModify(Goods goods) {
		return goodsMapper.goodsModify(goods);
	}

	// 하상우 ) 관리자 상품 추가

	public void goodsAdd(GoodsForm goodsForm, String path) {
		// goodsForm 데이터 -> goods 로 이동
		Goods goods = new Goods();
		goods.setCategoryNo(goodsForm.getCategoryNo());
		goods.setGoodsTitle(goodsForm.getGoodsTitle());
		goods.setGoodsMemo(goodsForm.getGoodsMemo());
		goods.setGoodsPrice(goodsForm.getGoodsPrice());
		goods.setGoodsState(goodsForm.getGoodsState());
		int goodsRow = goodsMapper.goodsAdd(goods);
		int goodsNo = goods.getGoodsNo();
		log.debug("goodsNo : " + goodsNo);
		if (goodsRow == 1 && goodsForm.getGoodsFile() != null) {
			List<MultipartFile> list = goodsForm.getGoodsFile();
			for (MultipartFile file : list) {
				GoodsFile goodsFile = new GoodsFile();
				goodsFile.setGoodsNo(goodsNo);
				goodsFile.setGoodsFileType(file.getContentType());
				goodsFile.setGoodsFileSize(file.getSize());
				String fileName = UUID.randomUUID().toString().replace("-", "");
				goodsFile.setGoodsFileName(fileName);
				int dotIndex = file.getOriginalFilename().lastIndexOf(".");
				String originName = file.getOriginalFilename().substring(0, dotIndex);
				String ext = file.getOriginalFilename().substring(dotIndex + 1);
				goodsFile.setGoodsFileOrigin(originName);
				goodsFile.setGoodsFileExt(ext);

				int goodsFileRow = goodsFileMapper.insertGoodsFile(goodsFile);
				if (goodsFileRow == 1) {
					try {
						file.transferTo(new File(path + fileName + "." + ext));
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
						throw new RuntimeException();
					}
				}
			}
		}

	}

	// 하상우) 관리자 페이지에서 상품 리스트 조회
	public List<Map<String,Object>> getGoodsList() {
		return goodsMapper.getGoodsList();
	}

	// Author : 이동윤 상품상세정보
	public Map<String, Object> getGoodsOne(int goodsNo) {
		return goodsMapper.selectGoodsOne(goodsNo);
	}

	// Author : 이동윤 카테고리 별 상품리스트
	public List<Map<String, Object>> getSelectGoodsList(int categoryNo, Page page, String searchTitle) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("categoryNo", categoryNo);
		paramMap.put("searchTitle", searchTitle);
		paramMap.put("beginRow", page.getBeginRow());
		paramMap.put("rowPerPage", page.getRowPerPage());

		return goodsMapper.selectGoodsList(paramMap);
	}

	// Author : 이동윤 상품 라스트페이지
	public int getLastPage(int categoryNo, Page page) {
		int totalRow = goodsMapper.goodsLastPage(categoryNo);
		System.out.println("totalRow : "+ totalRow);
		int lastpage = page.getLastPage(totalRow);
		return lastpage;
	}

}
