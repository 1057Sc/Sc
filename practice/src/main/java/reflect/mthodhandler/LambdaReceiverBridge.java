package reflect.mthodhandler;

import java.lang.invoke.*;
import java.util.List;

public class LambdaReceiverBridge extends LambdaReceiver_A {

    interface IA {
        int m(LambdaReceiver_A x);
    }

    static MethodHandles.Lookup lookup;
    static MethodHandle methodHandle;

    private static MethodType mt(Class<?> k) {
        return MethodType.methodType(k);
    }

    private static MethodType mt(Class<?> k, Class<?> k2) {
        return MethodType.methodType(k, k2);
    }

    private static void mf(List<String> errs, MethodType mts, MethodType mtf, boolean shouldWork) {
    }

    public static void main(String[] args) throws Throwable {
        // 可以通过MethodHandles.Lookup的方式来获取MethodHandle
        methodHandle = lookup.findVirtual(LambdaReceiver_A.class, "f", mt(int.class));
        lookup = MethodHandles.lookup();
        MethodType X = mt(int.class, LambdaReceiverBridge.class);
        MethodType A = mt(int.class, LambdaReceiver_A.class);
        MethodType mti = mt(IA.class);
        // 这里为创建简单的"函数对象"
        CallSite cs = LambdaMetafactory.altMetafactory(lookup, "m", mti, X, methodHandle, X, LambdaMetafactory.FLAG_BRIDGES, 1, A);
        IA p = (IA) cs.dynamicInvoker().invoke();
        LambdaReceiver_A lra = new LambdaReceiver_A();
        try {
            p.m(lra);
        } catch (ClassCastException cce) {
            return;
        }
        throw new AssertionError("expected");
    }
}
