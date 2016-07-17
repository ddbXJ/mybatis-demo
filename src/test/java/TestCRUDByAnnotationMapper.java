import com.lxj.domain.User;
import com.lxj.mapping.UserMapperI;
import com.lxj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by lxj on 2016/7/15.
 */
public class TestCRUDByAnnotationMapper {

    @Test
    public void testAdd() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
        User user = new User("lp",26);
        int i = userMapperI.add(user);
        sqlSession.close();
        System.out.println(i);
    }

    @Test
    public void testSelect() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
        User user = userMapperI.selectById(1);
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
        User user = new User(10,"ydd",15);
        int i = userMapperI.update(user);
        sqlSession.close();
        System.out.print(i);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
        int i = userMapperI.delete(11);
        System.out.println(i);
    }

    @Test
    public void selectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI = sqlSession.getMapper(UserMapperI.class);
        List<User> users = userMapperI.selectAll();
        for (User u : users) {
            System.out.println(u);
        }
        sqlSession.close();
    }
}
