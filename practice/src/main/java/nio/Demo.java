package nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/**
 * nio
 *
 * @author zhuqingxin
 * @date 2021/4/1
 */
public class Demo {

    @Test
    public void demo1() {
        try (
                FileChannel inChannel = new FileInputStream("in.txt").getChannel();
                FileChannel outChannel = new FileOutputStream("out.txt").getChannel()
        ) {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (Exception e) {

        }



 /*       try {
            FileChannel inChannel = new FileInputStream("in.txt").getChannel();
            FileChannel outChannel = new FileOutputStream("out.txt").getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
            inChannel.close();
            outChannel.close();
        } catch (Exception e) {

        }*/
    }
}
