package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annnotation.Autofill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);


    @Autofill(OperationType.INSERT)
    void save(Dish dish);


    Page<Dish> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void delete(List<Long> ids);

    @Select("select * from dish where id = #{id}")
    Dish getByid(Long id);

    @Autofill(OperationType.UPDATE)
    void update(Dish dish);
}
