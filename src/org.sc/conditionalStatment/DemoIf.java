package conditionalStatment;

import org.apache.commons.lang.StringUtils;

/**
 * Created by duizhuang on 5/5/2019.
 */
public class DemoIf {

    public static void main(String[] args) {

        //Demo1();
        demo2();
    }

    public static void Demo1(){

        String s = "111";

        for(int i=0;i<10;i++){
            if(s.equals("111")){
                System.out.println("111111111111111111111111");
                break;
            }

            if(s.equals("111")){
                System.out.println(1111);;
            }
        }

    }


    public static void demo2(){

        School school = new School();
        school.setSchoolName("77");
        school.setSchoolNo("11");

        if (StringUtils.equals(school.getStudent().getName(),"777")) {
            System.out.println(777777);
        }
    }
}


class School{
    private String schoolName;

    private String schoolNo;

    private Student student;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolNo() {
        return schoolNo;
    }

    public void setSchoolNo(String schoolNo) {
        this.schoolNo = schoolNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

class Student{
    private Integer age;

    private String name;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
