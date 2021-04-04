package encryption;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import reflect.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class SerializerDemos {


    @Test
    public void demo() {
        List<Student> list = new ArrayList<>();
        int i = 2_000_000;
        for (int i1 = 0; i1 < i; i1++) {
            Student student = new Student("1", "2", 1, "123");
            list.add(student);
        }

        byte[] serialize = serialize(list);
        byte[] gzip = ZipUtil.gzip(serialize);
        byte[] unGzip = ZipUtil.unGzip(gzip);
        List deserialize = deserialize(unGzip, ArrayList.class);


        System.out.println(ClassLayout.parseInstance(serialize).toPrintable());
        System.out.println(ClassLayout.parseInstance(gzip).toPrintable());
        System.out.println(serialize);
    }


    public static byte[] gzip(byte[] buf) {
        return gzip(new ByteArrayInputStream(buf), buf.length);
    }


    public static byte[] gzip(InputStream in, int length) throws UtilException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
        GZIPOutputStream gos = null;
        try {
            gos = new GZIPOutputStream(bos);
            IoUtil.copy(in, gos);
        } catch (IOException e) {
            // throw new UtilException(e);
        } finally {
            // IoUtil.close(gos);
        }
        // 返回必须在关闭gos后进行，因为关闭时会自动执行finish()方法，保证数据全部写出
        return bos.toByteArray();
    }


    public static byte[] serialize(Object obj) {
        FastByteArrayOutputStream byteOut = new FastByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(byteOut);
            oos.writeObject(obj);
            oos.flush();
        } catch (Exception e) {
            throw new UtilException(e);
        } finally {
            IoUtil.close(oos);
        }
        return byteOut.toByteArray();
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
        ObjectInputStream ois;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            throw new UtilException(e);
        }
    }
}
