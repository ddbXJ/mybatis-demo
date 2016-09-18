package com.lxj.dao.manager;

import com.lxj.dao.dto.TestDTO;
import com.sfebiz.common.dao.BaseDao;
import com.sfebiz.common.dao.helper.DaoHelper;
import com.sfebiz.common.dao.manager.BaseManager;

/**
 * Created by lixuejiao on 16/8/10.
 */
public class TestManager extends BaseManager<TestDTO> {
    public BaseDao<TestDTO> getDao() {
        return null;
    }

    public static void main(String[] args) {
        DaoHelper.genXMLWithFeature(
                "/Users/lixuejiao/Codes/mybatis-demo/src/main/resources/com.lxj.dao.sqlmap/testMap.xml",
                TestManager.class, TestDTO.class, "test");
    }
}
