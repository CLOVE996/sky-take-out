package com.sky.mapper;


import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {



    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    void insertBatch(List<SetmealDish> setmealDishes);

    void deleteBySetmealIds(List<Long> ids);

    @Select("select * from setmeal where id = #{id}")
    List<SetmealDish> getBySetmealId(Long id);

    @Select("select dish.* from setmeal_dish sd left join dish on sd.dish_id = dish.id where sd.setmeal_id = #{id}")
    List<Dish> getDishBySetmealId(Long id);
}
