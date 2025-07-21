package com.sky.mapper;


import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import com.sky.vo.DishItemVO;
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


    @Select("select sd.name,sd.copies,d.image,d.description from dish d left join setmeal_dish sd on d.id = sd.dish_id where sd.setmeal_id=#{setmealId}")
    List<DishItemVO> getDishItemById(Long setmealId);
}
