package exception;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * 异常后运行终止
 *
 */
public class LoopException {

    @Test
    public void demo1() {
        try {
            loop1();
        } catch (Exception e) {
            System.out.println("sadasdsa"+ e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("final :::::::::::::::::");
        }
    }

    private void loop1() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("before exception" + i);
            if (i > 5) {
                // throw new Exception();
                throw new FileNotFoundException("dsad");
            }
            System.out.println("after exception" + i);
        }
    }
}
