package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annnotation.Autofill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    @Autofill(OperationType.UPDATE)
    void update(Setmeal setmeal);

    @Insert("insert into setmeal (category_id, name, price, status,description,image) " +
            "values (#{categoryId}, #{name}, #{price}, #{status}, #{description}, #{image})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Autofill(OperationType.INSERT)
    void insert(Setmeal setmeal);

    Page<SetmealVO> getByPage(SetmealPageQueryDTO setmealPageQueryDTO);

    void delete(List<Long> ids);

    @Select("select * from setmeal where id = #{id}")
    Setmeal getByid(Long id);


    List<Setmeal> list(Setmeal setmeal);
}
