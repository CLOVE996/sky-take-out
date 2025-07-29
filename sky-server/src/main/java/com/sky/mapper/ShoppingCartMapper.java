package com.sky.mapper;
import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface ShoppingCartMapper {



    List<ShoppingCart> get(ShoppingCart shoppingCart);


    void update(ShoppingCart shoppingCart);


    @Insert("insert into shopping_cart (name, image, dish_id, setmeal_id, dish_flavor, number, amount, create_time, user_id) values (#{name}, #{image}, #{dishId}, #{setmealId}, #{dishFlavor}, #{number}, #{amount}, #{createTime}, #{userId})")
    void insert(ShoppingCart shoppingCart);

    @Select("select * from shopping_cart where user_id = #{currentId}")
    List<ShoppingCart> list(Long currentId);


    void delete(ShoppingCart shoppingCart);

    @Update("delete from shopping_cart where user_id = #{currentId}")
    void deleteByUserId(Long currentId);
}
