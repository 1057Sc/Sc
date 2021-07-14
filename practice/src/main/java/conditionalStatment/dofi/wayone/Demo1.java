package conditionalStatment.dofi.wayone;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Sc
 * @date 2021/3/25
 */
public class Demo1 {


    public void demo() {
        Map<Class<?>, Function<String, ?>> map = new HashMap<>();
        map.put(String.class, Function.identity());
        map.put(BigDecimal.class, s -> new BigDecimal(s).setScale(1, RoundingMode.DOWN));
        map.put(Long.class, Long::parseLong);
        map.put(Integer.class, Integer::parseInt);
    }
}
