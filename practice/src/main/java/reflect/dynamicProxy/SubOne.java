package reflect.dynamicProxy;

public class SubOne extends Father {


    private Father subOne = new SubOne();

    @Override
    public Father getObj() {
        return subOne;
    }

    public Father getObj(String name){
        return new Father();
    }

}
