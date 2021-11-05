package org.sc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.sc.mockito.DemoLogic;

@RunWith(MockitoJUnitRunner.class)
public class TestDemo1 {

    @Test
    public void demoTest1() {
        DemoLogic demoLogic = new DemoLogic();
        demoLogic.test1(1);

        DemoLogic demoLogic1 = new DemoLogic();
        demoLogic1.test1(2);

        DemoLogic demoLogic2 = new DemoLogic();
        demoLogic1.test1(3);
    }
}
