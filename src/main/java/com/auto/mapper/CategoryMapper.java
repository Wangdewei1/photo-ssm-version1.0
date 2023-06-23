package com.auto.mapper;

import com.auto.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository //没意义 骗idea用的
public interface CategoryMapper {
    List<Category> findAllCategory();
}
