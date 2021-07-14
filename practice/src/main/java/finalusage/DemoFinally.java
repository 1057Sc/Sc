package finalusage;

import org.junit.Test;

/**
 * @author Sc
 * @date 2021/3/31
 */
public class DemoFinally {

    /**
     * --try--
     * --finally--
     * true
     */
    @Test
    public void demo(){
        boolean b = demo1();
        System.out.println(b);
    }


    private boolean demo1() {
        try {
            System.out.println("--try--");
            return true;
        } finally {
            System.out.println("--finally--");
        }
    }
}
