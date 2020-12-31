package generics;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhuqingxin
 * @date 2020/12/25
 */
public class Demos {

    public static void main(String[] args) {

        int i = ThreadLocalRandom.current().nextInt(100_000);
        System.out.println(i);
    }
}
