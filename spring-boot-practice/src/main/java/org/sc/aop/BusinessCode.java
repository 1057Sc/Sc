package org.sc.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessCode {

    @RequestMapping(value = "/bus/name")
    public String getName(){
        System.out.println("businessCode : getName");
        System.out.println("I hope everything is ok!");
        return "name";
    }

    @RequestMapping(value = "/bus/num")
    public int reNumber(){
        return 7777;
    }

    @RequestMapping(value = "/bus/num/22")
    public int reNumber1(){
        return 7777;
    }

}
