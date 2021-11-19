package org.sc.mytest;

import og.sc.UserMockTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.sc.ScPracticeApplication;
import org.sc.custom.ScDemos;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Sc
 * @date 2021/5/28
 */

@RunWith(MockitoJUnitRunner.class) //Mockito测试框架
public class TestSc {

    @BeforeClass
    public static void initMockAnnotation() {
        // Annotation初始化
        MockitoAnnotations.initMocks(UserMockTest.class);
    }

    @Test
    public void argumentCaptorTest() {
        List mock = Mockito.mock(List.class);
        List mock2 = Mockito.mock(List.class);
        mock.add("John");
        mock2.add("Brian");
        mock2.add("Jim");

        ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);
        verify(mock).add(argument.capture());
        assertEquals("John", argument.getValue());

/*        verify(mock2, times(2)).add(argument.capture());

        assertEquals("Jim", argument.getValue());
        assertArrayEquals(new Object[]{"Brian","Jim"},argument.getAllValues().toArray());*/
    }
}
