package reflect.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @description: Generic Method Return Types
 */
public class Demo2 {

    protected List<String> stringList = new ArrayList<>();

    public List<String> getStringList() {
        return this.stringList;
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Demo2.class.getMethod("getStringList", null);

        Type returnType = method.getGenericReturnType();

        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }
}
