package generics.demo;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;
import reflect.FooStudent;
import reflect.Student;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TypeGet {

    public <T> void test1(List<T> list) {
        try {
            for (T t : list) {
                Class<?> aClass = t.getClass();
                Object o = aClass.newInstance();
                Field[] fields = aClass.getFields();
                for (Field field : fields) {
                    field.getName();
                    System.out.println(field.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> void getSql(List<T> list) {
        try {
            for (T t : list) {
                Class<?> aClass = t.getClass();
                String simpleName = aClass.getSimpleName();
                System.out.println(simpleName);
                String tableName = StrUtil.toUnderlineCase(simpleName);
                System.out.println(tableName);
                Field[] fields = aClass.getDeclaredFields();
                StringBuffer columnSql = new StringBuffer("insert into ").append(tableName).append(" (");
                StringBuffer valueSql = new StringBuffer("values (");

                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    String name = field.getName();
                    if (i != fields.length - 1) {
                        columnSql.append(name).append(",");
                        valueSql.append(":").append(name).append(",");
                    } else {
                        columnSql.append(name).append(") ");
                        valueSql.append(":").append(name).append(") ");
                    }

                }

                String sql = columnSql.append(valueSql).toString();
                System.out.println(sql);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void boot() {
        List<FooStudent> students = new ArrayList<>();
        students.add(new FooStudent());
        getSql(students);
    }
}
