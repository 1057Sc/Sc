package object;

/**
 * Created by Sc on 2018/11/1.
 */
public class ObjectDemo {

    private Class clazz;

    public void setClazz(Class clazz){
        clazz = this.clazz;
    }

    public static void main(String args[]){

        ObjectDemo o = new ObjectDemo();
        o.demo1();
    }

    public void demo1(){
        Class clacc = this.getClass();
        System.out.print(clazz);
    }
}
