package og.sc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sc.Application;
import org.sc.aop.FooEntity;
import org.sc.aop.FooMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class DemoTest {

    @BeforeClass
    public static void initMockAnnotation() {
        MockitoAnnotations.initMocks(DemoTest.class);
    }

    @Mock
    private FooMapper fooMapper;


    @Test
    public void demo() {
        Mockito.when(fooMapper.selectFoo(1)).thenReturn(new FooEntity(1, "13123"));
        FooEntity fooEntity = fooMapper.selectFoo(1);
        System.out.println(fooEntity);
    }

    @Test
    public void demo2() {
        Mockito.when(fooMapper.selectFoo(anyInt())).thenReturn(new FooEntity(1, "13123"));
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
