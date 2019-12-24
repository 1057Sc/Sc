package abstractDemo;

import java.util.List;

/**
 * Created by Sc on 2019/1/18.
 */
public interface Exeutor {

    <E> List<E> query(String sql);
}
