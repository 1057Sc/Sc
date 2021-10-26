package og.sc;

import cn.hutool.core.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.sc.aop.FooEntity;
import org.sc.aop.FooMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

import static org.mockito.ArgumentMatchers.any;

public class Demo {

    @MockBean
    FooMapper fooMapper;
    @Mock
    FooMapper fooMapper1;

    @Test
    public void demo(){
        FooEntity fooEntity = fooMapper1.selectFoo(1);
    }

   /* @Test
    public void runTest() {

        FooEntity fooEntity = fooMapper.selectFoo(1);
        PersonMapper personMapper = (PersonMapper) init(PersonService, PersonMapper.class);
        Mockito.doReturn(new Person("mike")).when(personMapper ).getById(any());

        Person testPerson = personService.getById("testId");
        Assert.isTrue(testPerson.getName().equals("mike"), "");
    }


    Object init(Object mainClass, Class memberField) throws Exception {
        Class<?> clazzRoot = mainClass.getClass();
        Object obj = Mockito.mock(memberField);
        Field field = clazzRoot.getDeclaredField(StrUtils.headToLowerCase(memberField.getSimpleName()));
        field.setAccessible(true);
        field.set(mainClass, obj);
        return obj;
    }*/
}
