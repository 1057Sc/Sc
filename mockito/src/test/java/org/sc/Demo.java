package org.sc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.sc.mockito.BeanBar;
import org.sc.mockito.BeanFoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// @RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)
// @PrepareForTest
public class Demo {

/*    @Rule
    public MockitoRule initRule = MockitoJUnit.rule();*/

    @Mock
    List<String> mockedList;

    @Test
    public void whenUseMockAnnotation_thenMockIsInjected() {
        mockedList.add("one");
        verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        verify(mockList).add("one");
        assertEquals(0, mockList.size());

        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }

    @Test
    public void whenNotUseSpyAnnotation_thenCorrect() {
        List<String> spyList = Mockito.spy(new ArrayList<String>());

        spyList.add("one");
        spyList.add("two");

        verify(spyList).add("one");
        verify(spyList).add("two");

        assertEquals(2, spyList.size());

        Mockito.doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }

    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        List mockList = Mockito.mock(List.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        mockList.add("one");
        verify(mockList).add(arg.capture());

        assertEquals("one", arg.getValue());
    }

    @Test
    public void demo1() {

        List list = new LinkedList();
        List spy = Mockito.spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
    }

    @Test
    public void demo2() {
        List list = new LinkedList();
        List spy = Mockito.spy(list);
        spy.add("sc");
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(spy).add(stringArgumentCaptor.capture());
        System.out.println(stringArgumentCaptor.getValue());
    }

    @Mock
    private BeanBar beanBar;
    @InjectMocks
    private BeanFoo beanFoo;

    @Mock BeanFoo beanFoo1;
    @InjectMocks
    private BeanBar beanBar1;

    @Test
    public void demo() {
        beanBar1.bar("sc");
        beanFoo.foo("scsc");
    }

    @Test
    public void demo3() {
        // use InjectMocks of beanBar can't verify
        beanFoo.foo("sc");
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(beanFoo).foo(stringArgumentCaptor.capture());
        System.out.println(stringArgumentCaptor.getValue());
    }


}
