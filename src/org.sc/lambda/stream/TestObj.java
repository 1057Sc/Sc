package lambda.stream;

public class TestObj {


    private Integer id;

    private String name;

    private Integer age;

    private Integer classNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classNo=" + classNo +
                '}';
    }
}
