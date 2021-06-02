package org.sc.controller;

import org.sc.common.config.ThreadLocalMapConfig;
import org.sc.mapper.TextDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
public class TextController {

    @Resource
    private TextDao textDao;

    @RequestMapping("test")
    public String demo1() {
        return String.valueOf(textDao.test1());
    }

    @RequestMapping("insert")
    public int demo2(){
        return textDao.insertTest1();
    }

    // from-data ids: 1 ids:2
    @PostMapping("array")
    public int arrayP(Long[] ids){
        System.out.println(Arrays.toString(ids));
        return 1;
    }

    @GetMapping("switch")
    public void switch123(){
        ThreadLocalMapConfig.set();
        textDao.insertTest2();
    }

    @GetMapping("switch_no")
    public void switchNo(){
        textDao.insertTest2();
    }
}
