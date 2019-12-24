package variable;

import org.junit.Test;
import reflect.Student;

/**
 *
 * pass by reference
 *
 */
public class ReferencePass {

    @Test
    public void demo1(){
        String s = null;

        try {
            s = "11";
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(null == s);
    }

    @Test
    public void demo2(){
        Student student = new Student();
    }

    public static Student foo(Student student){
        student = new Student("sc", "man", 11, "zzzzzzzz");
        return student;
    }

    public static void foo1(Student student){
        student = new Student("sc", "man", 11, "zzzzzzzz");
    }

    public static void bar(){

    }
}
