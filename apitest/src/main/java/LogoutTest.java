import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deft on 2017/5/10.
 */
public class LogoutTest {
    public static final String LOGIN_URL = "http://localhost:8080/nanny/login.action";
    public static final String LOGOUT_URL = "http://localhost:8080/nanny/logout.action";
    private static int user_index = 0;

    @Test
    public void requestSuccess() throws InterruptedException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(1000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000).setRedirectsEnabled(true).build();
        HttpPost httpPost = new HttpPost(LOGIN_URL);
        //设置超时时间
        httpPost.setConfig(requestConfig);
        //装配post请求参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("username", "2@qq.com"));  //请求参数
        list.add(new BasicNameValuePair("password", "2"));  //请求参数

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
        //设置post求情参数
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);



        HttpPost httpPost1 = new HttpPost(LOGOUT_URL);
        //设置超时时间
        httpPost1.setConfig(requestConfig);
        //装配post请求参数
        List<BasicNameValuePair> list1 = new ArrayList<BasicNameValuePair>();

        UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(list1, "UTF-8");
        //设置post求情参数
        //httpPost1.setEntity(entity1);
        HttpResponse httpResponse1 = httpClient.execute(httpPost1);
        httpClient.close(); //释放资源

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse1.getStatusLine().getStatusCode() );
    }
}
