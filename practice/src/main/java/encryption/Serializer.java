package encryption;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import reflect.Student;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhuqingxin
 * @date 2021/4/3
 */
public class Serializer {

    @Test
    public void demo1() {
        List list = new ArrayList();
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        list.add(12);
        // String key = "Mary1has2onecat1123";
        String key = "IpxjnyBDkvrj8HxASlgZHwbH";

        byte[] demos = demos(list);
        byte[] bytes = CryptoUtils.doCrypto(Cipher.ENCRYPT_MODE, key, demos);
        byte[] bytes2 = CryptoUtils.doCrypto(Cipher.DECRYPT_MODE, key, bytes);
        // 判断字节占用内存大小
        ArrayList<Integer> arrayList = demo2(bytes2, ArrayList.class);
        for (Integer student : arrayList) {
            System.out.println(student);
        }
        System.out.println(JSON.toJSONString(arrayList));
    }

    @Test
    public void demo2() {
        byte[] demos = "213456".getBytes();
        String key = "IpxjnyBDkvrj8HxASlgZHwbH";


        byte[] bytes1 = CryptoUtils.doCrypto(Cipher.ENCRYPT_MODE, key, demos);
        byte[] bytes2 = CryptoUtils.doCrypto(Cipher.DECRYPT_MODE, key, bytes1);



        // 新的方式加密
        // byte[] bytes11 = CryptoUtils.doCrypto1(Cipher.ENCRYPT_MODE, key, demos);
        // byte[] bytes2 = CryptoUtils.doCrypto(Cipher.DECRYPT_MODE, key, bytes);

        // 新的方式解密
        // byte[] bytes11 = CryptoUtils.doCrypto1(Cipher.ENCRYPT_MODE, key, demos);
        // byte[] bytes22 = CryptoUtils.doCrypto1(Cipher.DECRYPT_MODE, key, bytes11);

        // String s = new String(bytes22);
        // System.out.println(s);

    }


    public <T> byte[] demos(List<T> list) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(list);
            return bos.toByteArray();
        } catch (Exception e) {
            // todo
        }
        return null;
    }

    public <T> T demo2(byte[] bytes, Class<T> tClass) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bais)
        ) {
            return (T) ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    @Test
    public void demo(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }
}
