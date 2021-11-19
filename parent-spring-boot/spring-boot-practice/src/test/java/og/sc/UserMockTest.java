package og.sc;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.sc.biz.user.User;
import org.sc.biz.user.UserMapper;
import org.sc.biz.user.UserService;

import java.text.MessageFormat;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * 注重于业务逻辑的单测，因此会mock掉所有三方依赖
 */
@RunWith(MockitoJUnitRunner.class) //Mockito测试框架
public class UserMockTest {

    @BeforeClass
    public static void initMockAnnotation() {
        // Annotation初始化
        MockitoAnnotations.initMocks(UserMockTest.class);
    }

    /**
     * 声明Mock
     */
    @Mock
    private UserMapper userMapperMock;
    /**
     * 为UserService注入mock类
     */
    @InjectMocks
    // @Mock
    private UserService userService;

    /**
     * 模拟实际业务场景中Mock外部依赖，带来的问题为我们的Sql又没办法通过这种风格的单测验证了，
     * 所以这种风格的单测侧重点应该在验证业务逻辑
     * 所有的原则在某些场景无法全部满足
     */
    @Test
    public void createTest() {
        Mockito.when(userMapperMock.fooAdd(anyString())).thenReturn(1L);
        long sc = userService.create("sc");
        MatcherAssert.assertThat(sc, greaterThan(0L));
    }

    /**
     * 其实这里是可以拆成三个测试用例，但是拆成三个后不方便针对单个方法做测试，所以在FIRST原则和编写、操作的时间成本做一个权衡
     * 而且针对单个场景的单个method不推荐写的特别复杂，这样会导致后期的维护成本、测试成本加大
     */
    @Test
    public void retrieveTest() {
        // 如果User对象field多了之后，那么数据的模拟也会相应的变复杂
        Mockito.when(userMapperMock.selectFoo("sc")).thenReturn(new User(1L, "sc"));
        User sc = userService.retrieve("sc");
        Assert.assertNotNull(sc);

        // 在做数据模拟的时候可以根据业务场景做用例，定义输入和输出，例如输入"odd"后期望得到"new User(2, "odd")"
        Mockito.when(userMapperMock.selectFoo("odd")).thenReturn(new User(2L, "odd"));
        User odd = userService.retrieve("odd");
        // 如果对odd对象做程序校验
        Assert.assertNotNull(odd);

        // 异常校验方法
        Mockito.when(userMapperMock.selectFoo("bar")).thenReturn(null);
        Assert.assertThrows(RuntimeException.class, () -> userService.retrieve("bar"));

    }

    @Test
    public void captor() {
        // Mockito.when(userMapperMock.selectFoo("sc")).thenReturn(new User(1L, "sc"));
        User sc = userService.retrieve("sc");
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(userService).retrieve(stringArgumentCaptor.capture());
        assertEquals("sc", stringArgumentCaptor.getValue());
    }

    @Test
    public void demo() {
        Integer i = 12321321;

        String s = "{0,number,#}hcisjkshdjksa";

        String format = MessageFormat.format(s, i);
        System.out.println(format);
    }
}
