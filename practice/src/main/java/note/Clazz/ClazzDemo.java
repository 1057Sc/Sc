package note.Clazz;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * java Class类api使用
 *
 * @author zhuqingxin
 * @date 2021/1/20
 */
public class ClazzDemo {

    @Test
    public void assignable(){
        String s = "123";
        Integer.class.isAssignableFrom(s.getClass());

    }
}
