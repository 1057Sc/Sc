package org.sc.config;

import org.sc.aop.FooEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class RegisterBean {

    @Autowired
    private AutowireCapableBeanFactory beanFactory;
    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;


    public void testmenualInject() {
        FooEntity userDao = new FooEntity();
        //将new出的对象放入Spring容器中
        defaultListableBeanFactory.registerSingleton("userDao", userDao);
        //自动注入依赖
        /*beanFactory.autowireBean(userDao);*/
        //判断new的对象和从容器中拿出的对象是否一致
        System.out.println(defaultListableBeanFactory.getBean("userDao").equals(userDao));
    }
}
