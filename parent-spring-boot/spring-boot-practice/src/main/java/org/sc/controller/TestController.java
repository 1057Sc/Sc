package org.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqingxin
 * @date 2021/3/5
 */


@RestController
@RequestMapping("/test")
public class TestController {
/*
    @Autowired
    private RedisTemplateExtension redisTemplateExtension;

    @GetMapping("test")
    public void test() {
        boolean lock = redisTemplateExtension.lock(RedisKeyEnum.SET_DEMO, "123");
        System.out.println(lock);
        boolean unlock = redisTemplateExtension.unlock(RedisKeyEnum.SET_DEMO, "123");
        System.out.println(unlock);

    }*/
}
