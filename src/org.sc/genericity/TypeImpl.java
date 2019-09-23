package genericity;

import lambda.stream.TestObj;

public class TypeImpl implements Type<TestObj,TestObjChild> {


    @Override
    public TestObj getEntity(TestObjChild entity) {
        return null;
    }

    @Override
    public <E extends TestObj> TestObj getE(E e) {
        return null;
    }

}

