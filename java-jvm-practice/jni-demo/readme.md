## Java Native Interface JNI 
### `JNI`基础概念
​`Java Native Interface (JNI)`是用于编写`Java native methods`和将`JVM`嵌入本地应用程序的标准编程接口。其主要目标是在给定平台上跨所有Java虚拟机实现的本机方法库的二进制兼容性。
其主要作用为在指定平台上所有的Java虚拟机实现提供`native method libraries`的二进制兼容性 
### `JNI`在MacOs的简单实战

1. 创建`DemoJni`文件
```java
public class DemoJni {

    public static native String sayHello(String name);

    static {
        try {
            System.loadLibrary("sayHello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello " + sayHello("Sc"));
    }
}
```

2. `javah`生成`DemoJni`头文件，输出文件为`org_sc_DemoJni.h`，输出规则为packageName.className
```bash
javah -d output-dir -jni org.sc.DemoJni
```

3. 编写`sayHello.c`文件，include`org_sc_DemoJni.h`文件，复制`org_sc_DemoJni.h`里的函数
```c
#include "stdio.h"
#include "org_sc_DemoJni.h"

JNIEXPORT jstring JNICALL Java_org_sc_DemoJni_sayHello
  (JNIEnv *env, jclass jc, jstring name)
{
	return name;
}
```

4. 编译`sayHello.c`
注意：
-  需要根据不同的操作系统指定编译后文件的后缀MacOs为`jnilib`，其它环境没实践
-  编译后的文件需要带`lib`前缀
```bash
gcc -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin/" -o libsayHello.jnilib -shared sayHello.c
```

5. 编译&运行`DemoJni`
```bash
javac org/sc/DemoJni.java 
java -Djava.library.path="libsayHello.jnilib文件所在目录" org.sc.DemoJni
```

6. 验证结果
```bash
Hello Sc
```
