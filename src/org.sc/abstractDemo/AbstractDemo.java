package abstractDemo;


import abstractDemo.Exeutor;

import java.util.List;

/**
 * Created by Sc on 2019/1/18.
 */
public abstract class AbstractDemo implements Exeutor {

    protected abstract <E> List<E> doquery(String sql);

    public <E> List<E> queryFormDatabses(String sql){
        List<E> list;
        list = doquery("sql");
        return list;
    }

}
