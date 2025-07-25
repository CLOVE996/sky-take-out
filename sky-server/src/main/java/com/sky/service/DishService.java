package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    void save(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void delete(List<Long> ids);

    DishVO getByIdWithFlavors(Long id);

    void update(DishDTO dishDTO);

    void startOrStop(Integer status, Long id);

    List<DishVO> getDishByCategoryId(Long categoryId);

    List<DishVO> listWithFlavor(Dish dish);
}
