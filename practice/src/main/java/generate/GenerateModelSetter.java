package generate;


import generate.scan.PackageScan;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * 生成model的 set 和 get
 *
 */
public class GenerateModelSetter {

    public static void main(String[] args) {
        List<String> classNames = PackageScan.getClassName("generate.miao");
        for (String clazzName : classNames) {
            generate(clazzName);
            System.out.println("----------------------------");
        }
    }

    public static String generate(String className) {
        try {


            Class<?> clz = Class.forName(className);
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {

                if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                    continue;
                }

                Class<?> type = field.getType();
                String typeSimpleName = type.getSimpleName();
                if (typeSimpleName.equals("Date")) {

                }
                //System.out.println(type.getSimpleName());

                System.out.println(clz.getSimpleName() + ".set" + firstLetterToUpperCase(field.getName()) + "(" + firstLetterToLowerCase(clz.getSimpleName()) + ".get" + firstLetterToUpperCase(field.getName()) + "());");
            }


            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String firstLetterToUpperCase(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }
        if (value.length() == 1) {
            return value.toUpperCase();
        }

        return String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1);
    }

    public static String firstLetterToLowerCase(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }
        if (value.length() == 1) {
            return value.toUpperCase();
        }

        return String.valueOf(value.charAt(0)).toLowerCase() + value.substring(1);
    }
}
