package reflect;

/**
 * Created by Sc on 2018/6/12.
 */
public class Student implements java.io.Serializable {

    private String name;

    private String sex;

    public int age;

    public String phone;

    public Student() {
        System.out.println("调用了无参的构造方法");
    }

    public Student(String name, String sex, int age, String phone) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        // System.out.println("调用了有参的构造方法");
    }

    public int method(){
        System.out.println("调用了无参数的方法");
        return  1;
    }

    public int method(int i,String s){
        System.out.println("调用了有参数的方法");
        System.out.println(i+s);
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
