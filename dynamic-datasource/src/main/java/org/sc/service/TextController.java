package org.sc.service;

import org.sc.mapper.TextDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TextController {

    @Resource
    private TextDao textDao;

    @RequestMapping("test")
    public String demo1() {
        return String.valueOf(textDao.test1());
    }

}
