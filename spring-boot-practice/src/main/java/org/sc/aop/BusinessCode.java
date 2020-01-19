package org.sc.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessCode {

    @RequestMapping(value = "/bus/name")
    public String getName(){
        System.out.println("businessCode : getName");
        return "name";
    }

    @RequestMapping(value = "/bus/num")
    public int reNumber(){
        return 7777;
    }
}
