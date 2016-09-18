import com.lxj.domain.ProductId;
import com.lxj.domain.Teacher;
import com.lxj.domain.User;
import com.lxj.protest.ProductQueryDTO;
import com.lxj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lxj on 2016/7/12.
 * 这个类的所有test方法都用到了自己写的MyBatisUtil
 * 传入conf配置,就可以通过MyBatisUtil.getSqlSession(true)获得一个sqlSession(会自动提交)
 * 默认读取的配置是conf.xml
 * 如果要更改db源配置,只需要调用 MyBatisUtil.setResourcePath("xxx.xml");
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

    @Test
    public void testAddTeacher() {
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.TeacherMapper.insert";
        Teacher teacher = new Teacher();
        teacher.settName("xxx");
        int retValue = session.insert(statement,teacher);
        //此处如果不commit，就会产生脏数据，id自增长了，但是实际上数据没有插入进去
        //解决方案：Util里openSession()的时候传一个boolean，表示是否需要自动提交
        //session.commit();
        session.close();
        System.out.println("return : " + retValue);
        System.out.println("teacher : " + teacher.gettId());
    }

    @Test
    public void testPath() throws Exception{
        System.out.println(System.getProperty("user.dir"));
        File directory = new File("");//设定为当前文件夹
        System.out.println(directory.getCanonicalPath());//获取标准的路径
        System.out.println(directory.getAbsolutePath());//获取绝对路径
    }

    @Test
    public void testProduct() {
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.protest.ProductMapper.queryProductIds";
        int[] pids = {5829,5830};
        int[] cids = {1095};
        int[] bids = {12};
        int[] vids = {2};
        Integer limit = 1;
        Integer offset = null;
        ProductQueryDTO dto = new ProductQueryDTO();
        dto.setBids(null);
        dto.setCids(null);
        dto.setPids(null);
        dto.setVids(null);
        dto.setLimit(limit);
//        dto.setOffset(offset);
        dto.setStatus(0);
//        dto.setStock(1);
        int retValue = session.insert(statement,dto);
        session.close();
        System.out.println(retValue);
    }

    @Test
    public void testAddProductId() {
        SqlSession session = MyBatisUtil.getSqlSession(true);
        String statement = "com.lxj.mapping.ProductId.addPro";
        ProductId p = new ProductId();
        int retValue = session.insert(statement,p);
        session.close();
        System.out.println(retValue);
        System.out.println(p.getId());
    }
}
