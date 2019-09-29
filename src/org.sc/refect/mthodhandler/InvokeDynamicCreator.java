package refect.mthodhandler;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Handle;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.invoke.*;
import java.util.List;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

/**
 * javac CountUppercase.java
 * java -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler
 * -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler
 */
public class InvokeDynamicCreator {


    public static void main(final String[] args) throws Exception {
        final String outputClassName = "kathik/Dynamic";
        try (FileOutputStream fos
                     = new FileOutputStream(new File("D:\\Sc\\mygithub\\Sc\\target\\classes\\" + outputClassName + ".class"))) {
            fos.write(dump(outputClassName, "bootstrap", "()V"));
        }

    }

    public static byte[] dump(String outputClassName, String bsmName, String targetMethodDescriptor)
            throws Exception {
        final ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;

        // Setup the basic metadata for the bootstrap class
        cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, outputClassName, null, "java/lang/Object", null);

        // Create a standard void constructor
        mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        // Create a standard main method
        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();
        MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
                MethodType.class);
        Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, "kathik/InvokeDynamicCreator", bsmName,
                mt.toMethodDescriptorString());
        mv.visitInvokeDynamicInsn("runDynamic", targetMethodDescriptor, bootstrap);
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 1);
        mv.visitEnd();

        cw.visitEnd();

        return cw.toByteArray();
    }

    private static void targetMethod() {
        System.out.println("Hello World!");
    }

    public static CallSite bootstrap() throws NoSuchMethodException, IllegalAccessException {
        MethodType type = MethodType.methodType(void.class, String.class);
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        // Need to use lookupClass() as this method is static
        final Class<?> currentClass = lookup.lookupClass();
        final MethodType targetSignature = MethodType.methodType(void.class);
        final MethodHandle targetMH = lookup.findStatic(currentClass, "targetMethod", targetSignature);
        return new ConstantCallSite(targetMH.asType(type));
    }
}