package og.sc;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sc.ScPracticeApplication;
import org.sc.biz.user.User;
import org.sc.biz.user.UserMapper;
import org.sc.biz.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.greaterThan;


/**
 * 注重与三方依赖、中间等测试，在Spring Context中做测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScPracticeApplication.class)
public class UserBaseSpringContextTest {

    /**
     * 注入实际的数据层
     */
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /**
     * 我们会发现删除不能满足Repeatable原则，这只是单测无法重复执行的一种场景而已，在实战中还是要拿具体场景考虑
     */
    @Test
    public void deleteUnRepeatableDemo() {
        // 假如数据库有相应数据，第一次返回为1（成功），第二次返回为0（失败）
        long l = userMapper.fooDelete(1);
        MatcherAssert.assertThat(l, greaterThan(0L));
    }

    /**
     * 尝试满足Repeatable原则，但是却发现不能满足isolated
     */
    @Test
    public void deleteRepeatableDemo() {
        // 插入数据
        long id = userMapper.fooAdd("sc");
        // 根据返回的id操作
        long l = userMapper.fooDelete(id);
        MatcherAssert.assertThat(l, greaterThan(0L));
    }


    /**
     * 提高自测效率，也可以直接采用这种方式测试，
     */
    @Test
    public void updateTest() {
        User sc = userMapper.selectFoo("sc");
        long update = userService.update(sc);
        MatcherAssert.assertThat(update, greaterThan(0L));
    }
}
