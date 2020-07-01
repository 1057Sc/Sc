package generics.demo;

import org.junit.Test;
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void boot() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        test1(students);
    }
}
