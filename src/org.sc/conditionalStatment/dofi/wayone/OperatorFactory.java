package conditionalStatment.dofi.wayone;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by duizhuang on 8/29/2019.
 */
public class OperatorFactory {
    static Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("add", new Addition());
        operationMap.put("divide", new Division());
        // more operators
    }

    public static Optional<Operation> getOperation(String operator) {
        return Optional.ofNullable(operationMap.get(operator));
    }


}
