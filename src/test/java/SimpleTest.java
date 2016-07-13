import com.lxj.domain.User;
import com.lxj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.userMapper.getUserById";
        User user = session.selectOne(statement,3);
        session.close();
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.userMapper.addUser";
        User user = new User("wy",25);
/*        User user = new User();
        user.setName("xxx");
        user.setAge(25);*/
        int retValue = session.insert(statement,user);
        //此处如果不commit，就会产生脏数据，id自增长了，但是实际上数据没有插入进去
        //解决方案：Util里openSession()的时候传一个boolean，表示是否需要自动提交
        //session.commit();
        session.close();
        System.out.println(retValue);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.userMapper.updateUserById";
        User user = new User(10,"wyy",23);
        int retValue = sqlSession.update(statement,user);
        sqlSession.close();
        System.out.println(retValue);
    }

    @Test
    public void testDelete() {
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.userMapper.deleteUserById";
        int retValue = session.delete(statement,9);
        session.close();
        System.out.println(retValue);
    }

    @Test
    public void testGetAll() {
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.userMapper.selectAll";
        List<User> users = session.selectList(statement);
        session.close();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
