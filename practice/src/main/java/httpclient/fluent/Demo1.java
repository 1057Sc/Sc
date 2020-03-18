package httpclient.fluent;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {

    @Test
    public void demo1() throws IOException {
        String imgUrl = "http://img.dz8.cn/gemImg/2019-09/16/9af4a048db8628e403e490c595f557fc.origin.jpg";
        String imgPath = "C:\\Users\\duizhuang\\Pictures";
        String name = "test";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet get = new HttpGet(imgUrl);
            HttpResponse response = httpclient.execute(get);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();
            String dir = imgPath;
            File file = new File(dir, name + ".jpg");
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
        } catch (Exception e1) {
            System.out.println("下载图片出错" + imgUrl);
        }
        httpclient.close();
    }

    @Test
    public final void givenAcceptingAllCertificates_whenHttpsUrlIsConsumed_thenOk_2() throws GeneralSecurityException, IOException {

        String urlOverHttps = "http://img.dz8.cn/gemImg/2019-09/16/9af4a048db8628e403e490c595f557fc.origin.jpg";
        //String imgUrl = "https://img.dz8.cn/gemImg/2019-09/16/9af4a048db8628e403e490c595f557fc.origin.jpg";
         String imgUrl = "http://img.dz8.cn/setting/wechat/mini_program/2019-12/826bb3bd3e772a80780b3f5b05d00247.png";
        String imgPath = "C:\\Users\\duizhuang\\Pictures";
        String name = "https1";

        final TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        final Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();

        final BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(socketFactoryRegistry);
        final CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(connectionManager)
                .build();

        try {
            HttpGet get = new HttpGet(imgUrl);
            HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            InputStream in = entity.getContent();

            String dir = imgPath;
            File file = new File(dir, name + ".jpg");
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
        } catch (Exception e1) {
            System.out.println("下载图片出错" + imgUrl);
        }
        httpClient.close();

/*        final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        final ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(urlOverHttps, HttpMethod.GET, null, String.class);*/

    }

    @Test
    public void readImage() {
        String s = "1,2,3,4,5";
        List<Long> collect = Arrays.stream(s.split(",")).map(Long::valueOf).collect(Collectors.toList());

        String s1 = "1,2,3,4,5";
        List<Long> collect1 = Arrays.stream(s.split(",")).map(Long::valueOf).collect(Collectors.toList());

        System.out.println(collect.removeAll(collect1));
        System.out.println(collect.removeAll(collect1));

    }




}
