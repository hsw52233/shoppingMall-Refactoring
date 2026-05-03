package com.example.first.service;

import com.example.first.mapper.CategoryMapper;
import com.example.first.vo.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // 스프링을 띄우지 않고 Mockito 프레임워크만 가볍게 사용합니다.
class CategoryServiceUnitTest {

    @Mock // 1. 가짜(Mock) 객체 생성: 실제 DB와 연결되지 않는 가짜 CategoryMapper를 만듭니다.
    CategoryMapper categoryMapper;

    @InjectMocks // 2. 가짜 주입: 위에서 만든 가짜 CategoryMapper를 CategoryService에 쏙 끼워 넣습니다.
    CategoryService categoryService;

    @Test
    @DisplayName("1. 단위 테스트: 카테고리 추가 로직이 매퍼를 정확히 호출하는가?")
    void categoryAddUnitTest() {
        // Given (준비)
        Category testCategory = new Category();
        testCategory.setCategoryTitle("단위테스트 카테고리");

        // 핵심!! 가짜 매퍼는 스스로 동작할 수 없으므로 '각본(Stubbing)'을 짜주어야 합니다.
        // "만약 누군가 categoryMapper.categoryAdd()에 아무 Category 객체나 넣어서 호출하면, 무조건 1을 반환해라!"
        given(categoryMapper.categoryAdd(any(Category.class))).willReturn(1);

        // When (실행)
        // 실제 서비스의 메서드를 호출합니다. (하지만 안에는 가짜 매퍼가 들어있습니다)
        int result = categoryService.categoryAdd(testCategory);

        // Then (검증)
        // 1. 우리가 각본을 짠 대로 결과가 1이 나왔는지 검증합니다.
        assertEquals(1, result);

        // 2. 서비스 로직이 내부적으로 categoryMapper.categoryAdd()를 '딱 한 번' 호출했는지 행위를 검증합니다.
        verify(categoryMapper).categoryAdd(any(Category.class));
    }

    @Test
    @DisplayName("2. 단위 테스트: 카테고리 목록 조회 시 매퍼의 결과를 잘 전달하는가?")
    void getCategoryListUnitTest() {
        // Given (준비)
        // 가짜 매퍼가 돌려줄 가짜 데이터 리스트를 미리 만듭니다.
        Category c1 = new Category(); c1.setCategoryTitle("카테고리1");
        Category c2 = new Category(); c2.setCategoryTitle("카테고리2");
        List<Category> mockList = Arrays.asList(c1, c2);

        // 각본: "categoryMapper.getCategoryList()를 호출하면, 방금 만든 가짜 리스트(mockList)를 반환해라!"
        given(categoryMapper.getCategoryList()).willReturn(mockList);

        // When (실행)
        List<Category> resultList = categoryService.getCategoryList();

        // Then (검증)
        // 1. 결과가 null이 아닌지 확인
        assertNotNull(resultList);
        // 2. 가짜로 세팅한 2개의 데이터가 그대로 잘 전달되었는지 사이즈(2)로 확인
        assertEquals(2, resultList.size());
        // 3. 첫 번째 데이터의 제목이 "카테고리1"이 맞는지 확인
        assertEquals("카테고리1", resultList.get(0).getCategoryTitle());
        
        // 4. 매퍼의 getCategoryList()가 딱 한 번 호출되었는지 확인
        verify(categoryMapper).getCategoryList();
    }
}