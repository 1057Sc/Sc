package org.sc.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopDemo1 {

    @GetMapping(value = "/aop/add")
    public int add() {
        int a = 1;
        int b = 2;
        System.out.println(a + b);
        return a + b;
    }
}
