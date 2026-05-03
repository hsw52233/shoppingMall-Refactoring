package com.example.first.service;

import com.example.first.vo.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional 
class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    @DisplayName("1. 카테고리 추가 테스트 (성공 케이스)")
    void categoryAddTest() {
        // Given (준비: 추가할 새로운 카테고리 객체 생성)
        Category newCategory = new Category();
        // 프로젝트 코드에 맞게 categoryName 대신 categoryTitle 사용
        newCategory.setCategoryTitle("테스트 카테고리");

        // When (실행: 서비스의 categoryAdd 메서드 호출)
        int result = categoryService.categoryAdd(newCategory);

        // Then (검증: 데이터베이스에 성공적으로 1건이 들어갔으므로 결과는 1이어야 함)
        assertEquals(1, result, "카테고리 추가 시 1이 반환되어야 합니다.");
    }

    @Test
    @DisplayName("2. 카테고리 전체 목록 조회 테스트 (성공 케이스)")
    void getCategoryListTest() {
        // Given (준비: 미리 데이터를 1건 넣어둡니다.)
        Category newCategory = new Category();
        newCategory.setCategoryTitle("테스트 카테고리2");
        categoryService.categoryAdd(newCategory);

        // When (실행: 전체 카테고리 목록을 조회합니다)
        List<Category> list = categoryService.getCategoryList();

        // Then (검증: 리스트가 널이 아니고, 방금 넣은 데이터 때문에 최소 1개 이상 존재해야 함)
        assertNotNull(list, "조회된 리스트는 null이면 안 됩니다.");
        assertTrue(list.size() > 0, "리스트의 크기는 0보다 커야 합니다.");
    }

    @Test
    @DisplayName("3. 특정 카테고리 삭제 테스트 (성공 케이스)")
    void removeCategoryTest() {
        // Given (준비: 삭제할 데이터를 먼저 하나 만듭니다)
        Category category = new Category();
        category.setCategoryTitle("삭제될 카테고리");
        categoryService.categoryAdd(category); 
        
        List<Category> list = categoryService.getCategoryList();
        int lastInsertCategoryNo = list.get(list.size() - 1).getCategoryNo();

        // When (실행: 방금 추가한 카테고리의 번호로 삭제를 요청합니다)
        int result = categoryService.remove(lastInsertCategoryNo);

        // Then (검증: 1건이 성공적으로 삭제되었으므로 결과는 1이어야 함)
        assertEquals(1, result, "카테고리 삭제 시 1이 반환되어야 합니다.");
        
        // 추가 검증: 정말로 삭제되었는지 다시 조회해서 null이 반환되는지 확인
        Category deletedCategory = categoryService.getCategoryNo(lastInsertCategoryNo);
        assertNull(deletedCategory, "삭제된 카테고리를 조회하면 null이어야 합니다.");
    }
}