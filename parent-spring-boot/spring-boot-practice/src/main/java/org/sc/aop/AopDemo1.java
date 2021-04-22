package org.sc.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.sc.config.ConfigRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopDemo1 {

    @Autowired(required = false)
    private ConfigRegister configRegister;

    @GetMapping(value = "/aop/add")
    public int add() {
        int a = 1;
        int b = 2;
        System.out.println(a + b);
        return a + b;
    }

    @GetMapping(value = "/aop/add/param")
    public int add(Integer a , Integer b) {
        System.out.println(a + b);
        return a + b;
    }

    public int asd(){
        return 0;
    }
}
