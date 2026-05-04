package com.example.first.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void getCategoryList() {

            // [Given] 준비 단계: "어떤 상황이 주어졌을 때"
            // (목록 조회 테스트는 특별히 준비할 데이터가 없으므로 생략하거나 주석만 둡니다)

            // [When] 실행 단계: "무엇을 실행하면"
            // 실제 서비스의 메서드를 호출해서 결과를 받습니다.
            // List<Category> list = categoryService.getCategoryList();

            // [Then] 검증 단계: "결과가 어때야 하는가?"
            // 받아온 결과(list)가 null이 아닌지, 데이터가 제대로 들어있는지 확인합니다.
            // assertNotNull(list, "카테고리 리스트는 null이면 안 됩니다.");
            // assertTrue(list.size() > 0, "카테고리가 1개 이상은 있어야 합니다.");

    }
}