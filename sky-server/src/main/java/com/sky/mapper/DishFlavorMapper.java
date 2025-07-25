package com.sky.mapper;
import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface DishFlavorMapper {
    public void insertBatch(List<DishFlavor> flavors);

    void deleteByDishIds(List<Long> ids);

    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long id);
}
