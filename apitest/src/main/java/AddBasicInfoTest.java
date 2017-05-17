import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangke on 2015/2/4.
 */
public class AddBasicInfoTest {
    public static final String LOGIN_URL = "http://localhost:8080/nanny/login.action";
    public static final String ADDINFO_URL = "http://localhost:8080/nanny/addBaseInfo.action";

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

        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("username", "3@qq.com"));  //请求参数
        list.add(new BasicNameValuePair("password", "3"));  //请求参数

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
        //设置post求情参数
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);


        HttpPost httpPost2 = new HttpPost(ADDINFO_URL);

        //设置超时时间
        httpPost2.setConfig(requestConfig);
        List<BasicNameValuePair> infoList = new ArrayList<BasicNameValuePair>();
        infoList.add(new BasicNameValuePair("username", "ad"));  //请求参数
        infoList.add(new BasicNameValuePair("IDnumber", "123112221111111111"));  //请求参数
        infoList.add(new BasicNameValuePair("appellation", "先生"));  //请求参数
        infoList.add(new BasicNameValuePair("city", "仙女星"));  //请求参数
        infoList.add(new BasicNameValuePair("residence", "仙女屋"));  //请求参数
        infoList.add(new BasicNameValuePair("phoneNumber", "12111111111")); //请求参数
        UrlEncodedFormEntity entity2 = new UrlEncodedFormEntity(infoList, "UTF-8");
        //设置post求情参数
        httpPost2.setEntity(entity2);
        HttpResponse httpResponse2 = httpClient.execute(httpPost2);


        if (httpClient != null) {
            httpClient.close(); //释放资源
        }

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse2.getStatusLine().getStatusCode() );
    }

}