package instruction.invoekedynamic;

import java.lang.invoke.*;

public class Example {

    public static CallSite mybsm(
            MethodHandles.Lookup callerClass, String dynMethodName, MethodType dynMethodType)
            throws Throwable {

        MethodHandle mh =
                callerClass.findStatic(
                        Example.class,
                        "IntegerOps.adder",
                        MethodType.methodType(Integer.class, Integer.class, Integer.class));

        if (!dynMethodType.equals(mh.type())) {
            mh = mh.asType(dynMethodType);
        }

        return new ConstantCallSite(mh);
    }

    public static void main(String[] args) {
    }

}
