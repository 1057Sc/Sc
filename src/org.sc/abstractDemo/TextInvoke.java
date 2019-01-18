package abstractDemo;

/**
 * Created by Sc on 2019/1/18.
 * 这边有一个遗忘的知识点，是在看Mybatis源码发现的。
 * 知识点为:静态方法内部需要调用静态方法，或者使用对象去调用
 *         非静态的方法可以直接调用非静态方法和静态方法
 *
 */
public class TextInvoke {

    public static void main(String args[]){
        TextInvoke t = new TextInvoke();
        t.acc();
    }

    public int add(int i){

        return i+1;
    }

    public void acc(){
        abb();
        System.out.println("add:"+add(1));
        System.out.println("I am acc");
    }

    public static void abb(){

        System.out.println("I am dbb");
    }
}
