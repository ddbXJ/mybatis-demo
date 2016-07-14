import com.lxj.domain.User;
import com.lxj.mapping.UserMapperI;
import com.lxj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

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
}
