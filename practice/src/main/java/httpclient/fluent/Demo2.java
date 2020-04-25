package httpclient.fluent;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
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
import java.io.IOException;

public class Demo2 {


    @Test
    public void demo1(){
        try {

            String s = "https://www.baidu.com";

            String s1 = "https://www.baidu.com";
            Request.Get(s1).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void whenHttpsUrlIsConsumed_thenException()
            throws ClientProtocolException, IOException {

        String s = "https://www.baidu.com";

        String s1 = "https://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // String urlOverHttps = s;
        HttpGet getMethod = new HttpGet(s1);

        HttpResponse response = httpClient.execute(getMethod);
    }

    @Test
    public final void givenAcceptingAllCertificates_whenHttpsUrlIsConsumed_thenOk()
            throws Exception {
        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                NoopHostnameVerifier.INSTANCE);

        Registry<ConnectionSocketFactory> socketFactoryRegistry =
                RegistryBuilder.<ConnectionSocketFactory> create()
                        .register("https", sslsf)
                        .register("http", new PlainConnectionSocketFactory())
                        .build();

        BasicHttpClientConnectionManager connectionManager =
                new BasicHttpClientConnectionManager(socketFactoryRegistry);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
                .setConnectionManager(connectionManager).build();
        String s = "https://www.baidu.com";
        String s1 = "https://www.baidu.com";
        HttpGet getMethod = new HttpGet(s);

        HttpResponse response = httpClient.execute(getMethod);


    }

}
