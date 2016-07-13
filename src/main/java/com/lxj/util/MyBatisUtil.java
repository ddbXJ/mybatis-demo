package com.lxj.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by lxj on 2016/7/13.
 */
public class MyBatisUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(MyBatisUtil.class);

    private static final String RESOURCE_PATH = "conf.xml";

    public static SqlSession getSqlSession() {
        try {
            Reader reader = Resources.getResourceAsReader(RESOURCE_PATH);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sessionFactory.openSession();
        } catch (IOException e) {
            LOGGER.error("getSqlSession has e:{}",e.getMessage());
        }
        return null;
    }
}
