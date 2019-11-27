package httpclient.fluent;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo1 {

    @Test
    public void demo1() throws IOException {
        String imgUrl = "https://img.dz8.cn/gemImg/2019-09/16/9af4a048db8628e403e490c595f557fc.origin.jpg";
        String imgPath = "C:\\Users\\duizhuang\\Pictures";
        String name = "test";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try{
            HttpGet get = new HttpGet(imgUrl);
            HttpResponse response = httpclient.execute(get);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();
            String dir = imgPath;
            File file = new File(dir,name+".jpg");
            try {
                FileOutputStream fout = new FileOutputStream(file);
                int l = -1;
                byte[] tmp = new byte[1024];
                while ((l = in.read(tmp)) != -1) {
                    fout.write(tmp, 0, l);
                }
                fout.flush();
                fout.close();
            } finally {
                // 关闭低层流。
                in.close();
            }
        }catch(Exception e1){
            System.out.println("下载图片出错"+imgUrl);
        }
        httpclient.close();
    }
}
