/*
package apache;

import arithmetic.Entity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;


public class HttpClientDemo {

    public static void main(String[] args) throws Exception{
        demo2();
    }

    public String httpRequest(String url) {
        // String urlNameString = "https://local.Sc.com:30002/sale_survey/one_day?data_type=focus&date_start=2019-01-01&date_end=2019-01-02";
        String result = "";
        try {
            // 根据地址获取请求
            HttpGet request = new HttpGet(url);//这里发送get请求
            // 获取当前客户端对象
            HttpClient httpClient = HttpClientBuilder.create().build();
            // 通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(request);

            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            } else {
                result = "接口请求异常状态码为" + response.getStatusLine().getStatusCode();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    public static void httpdemo() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
HttpRequest httpRequest = new BasicHttpRequest("GET","localhost:9200/_search");
        httpRequest.

        HttpGet httpget = new HttpGet("http://10.0.0.14:9200/_search");
        HttpPost httpPost = new HttpPost("http://10.0.0.14:9200/_search");
        StringEntity stringEntity = new StringEntity("{\"query\": { \"match_all\": {} }}", ContentType.create("application/json", "UTF-8"));
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpclient.execute(httpget);
        CloseableHttpResponse response1 = httpclient.execute(httpPost);

        String s1 = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(s1);

        String s = EntityUtils.toString(response1.getEntity(), "utf-8");
        System.out.println(s);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    // do something useful
                } finally {
                    instream.close();
                }
            }
        } finally {
            response.close();
        }
    }

    public static void payload() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 构建请求头
        StringEntity stringEntity = new StringEntity("{\"query\": { \"match_all\": {} }}", ContentType.create("application/json", "UTF-8"));
        String s = EntityUtils.toString(stringEntity);
        System.out.println(s);
    }
*/
/**//*

*/
/**//*

    public static void demo2() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://10.0.0.14:9200/_search");
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity,"utf-8"));
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    // do something useful
                } finally {
                    instream.close();
                }
            }
        } finally {
            response.close();
        }
    }

}
*/
