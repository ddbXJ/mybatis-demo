import com.lxj.domain.User;
import com.lxj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lxj on 2016/7/12.
 */
public class SimpleTest {

    public static void main(String[] args) throws IOException{
        String resource = "conf.xml";
        InputStream is = SimpleTest.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "com.lxj.mapping.userMapper.getUserById";
        User user = session.selectOne(statement,1);
        session.close();
        System.out.println(user);
    }

    @Test
    public void testMyBatisUtil() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String statement = "com.lxj.mapping.userMapper.getUserById";
        User user = session.selectOne(statement,2);
        session.close();
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String statement = "com.lxj.mapping.userMapper.addUser";
        //User user = new User("xxx",25);
        User user = new User();
        user.setName("xxx");
        user.setAge(25);
        int retValue = session.insert(statement,user);
        session.close();
        System.out.println(retValue);
    }
}
