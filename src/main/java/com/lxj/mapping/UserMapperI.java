package com.lxj.mapping;

import com.lxj.domain.User;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by lxj on 2016/7/15.
 */
public interface UserMapperI {

    @Insert("insert into users(name,age) values (#{name},#{age})")
    public int add(User user);
}
