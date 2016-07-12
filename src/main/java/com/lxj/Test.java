package com.lxj;

import com.lxj.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lxj on 2016/7/12.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "conf.xml";
        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "com.lxj.mapping.userMapper.getUserById";
        User user = session.selectOne(statement,1);
        System.out.println(user);
    }
}

