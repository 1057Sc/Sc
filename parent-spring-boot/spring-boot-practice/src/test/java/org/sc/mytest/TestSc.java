package org.sc.mytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sc.ScPracticeApplication;
import org.sc.custom.ScDemos;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Sc
 * @date 2021/5/28
 */

@SpringBootTest(classes = ScPracticeApplication.class)
@RunWith(SpringRunner.class)
public class TestSc {

    @Resource
    private ScDemos scDemos;

    @Test
    public void sc(){
        System.out.println(scDemos);
    }

}
