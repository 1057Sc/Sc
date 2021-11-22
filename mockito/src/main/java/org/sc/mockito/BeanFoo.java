package org.sc.mockito;

public class BeanFoo {

    private BeanBar beanBar = new BeanBar();

    public void foo(String s) {
        System.out.println("fooooo" + s);
        beanBar.bar("bar");
    }
}
