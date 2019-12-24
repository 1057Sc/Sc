package abstractDemo;

import java.util.List;

/**
 * Created by Sc on 2019/1/18.
 */
public class SimpleAbstract extends AbstractDemo {

    @Override
    public <E> List<E> query(String sql) {
        doquery("dosql");
        return null;
    }

    @Override
    public <E> List<E> doquery(String sql) {
        System.out.println("SimpleAbstract-doquery");
        return null;
    }

    public static void main(String args[]){
        Exeutor e = new SimpleAbstract();
        e.query("sql");
    }
}
