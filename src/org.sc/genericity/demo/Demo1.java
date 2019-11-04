package genericity.demo;

/**
 * Created by Sc on 2018/12/21.
 */
public class Demo1<R,C extends Child> extends Root<C>{

    protected R perform(R r){

        return r;
    }

    public static void main(String args[]){
        Demo1 d = new Demo1();
        Child1 child1 = new Child1<Child1>();
    }

}

class Root<C>{

}

class Child<C>{

}

class Child1<C> extends Child<C>{

}

class Restrict<List>{

    public Restrict() {
    }


}