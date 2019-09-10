package lambda;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sc on 6/17/2019.
 */
public class StramDemo {

    public static void main(String[] args) {

    }

    public static void demo1() {
        List<Widget> list = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
            Widget widget = new Widget();
            list.add(widget);
        }
/*
        int sum = list.stream()
                      .filter(b -> b.getNum() == RED);*/
    }
}
