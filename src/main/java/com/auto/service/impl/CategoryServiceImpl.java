package com.auto.service.impl;

import com.auto.mapper.CategoryMapper;
import com.auto.pojo.Category;
import com.auto.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层 相册分类
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> findAllCategory() {
        return categoryMapper.findAllCategory();
    }
}
