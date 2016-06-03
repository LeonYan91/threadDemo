package com.yanliang.repository;

import com.yanliang.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yanliang
 * @ClassName PersonMapper
 * @Description
 * @Date 2016/5/25
 */

@Mapper
public interface PersonMapper {

//    @Select("select * from Person where id = #{id}")
//    public Person selectPerson(@Param("id") Long id);

    public List<Person> selectAll();

}
