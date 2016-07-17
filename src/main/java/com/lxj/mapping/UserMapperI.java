package com.lxj.mapping;

import com.lxj.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by lxj on 2016/7/15.
 */
public interface UserMapperI {

    @Insert("insert into users(name,age) values (#{name},#{age})")
    public int add(User user);

    @Select("select * from users where id=#{id}")
    public User selectById(int id);

    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);

    @Delete("delete from users where id=#{id}")
    public int delete(int id);

    @Select("select * from users")
    public List<User> selectAll();
}
