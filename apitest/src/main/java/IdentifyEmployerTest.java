import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deft on 2017/5/10.
 */
public class IdentifyEmployerTest {
    public static final String LOGIN_URL = "http://localhost:8080/nanny/login.action";
    public static final String IDENTIFY_NANNY_URL = "http://localhost:8080/nanny/employerAuth.action";

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


        HttpPost newPost = new HttpPost(IDENTIFY_NANNY_URL);
        //设置超时时间
        newPost.setConfig(requestConfig);
        JSONObject employerData = new JSONObject();
        employerData.put("workPlace", "北京");  //请求参数
        employerData.put("isNeedLive", "是");  //请求参数
        employerData.put("experience", "1年以上");  //请求参数
        employerData.put("employerEducation", "初中");  //请求参数
        employerData.put("employerSalary", "1000");  //请求参数
        employerData.put("employerRestTime", "10");  //请求参数
        employerData.put("babyyear", "1999");  //请求参数
        employerData.put("babymonth", "10");  //请求参数
        employerData.put("babydate", "22"); //请求参数
        employerData.put("babyBirthWeight", "1");  //请求参数
        employerData.put("motherAge", "20");  //请求参数
        employerData.put("motherWeight", "50"); //请求参数
        employerData.put("motherHeight", "165");  //请求参数
        employerData.put("deliveryTimes", "1");  //请求参数
        employerData.put("deliveryMode", "顺产");  //请求参数
        //System.out.println(employerData.toString());

        List<BasicNameValuePair> list1 = new ArrayList<BasicNameValuePair>();
        list1.add(new BasicNameValuePair("employerData", employerData.toString()));  //请求参数
        UrlEncodedFormEntity entity2 = new UrlEncodedFormEntity(list1, "UTF-8");
        newPost.setEntity(entity2);
        HttpResponse httpResponse2 = httpClient.execute(newPost);


        if (httpClient != null) {
            httpClient.close(); //释放资源
        }

        Assert.assertEquals(HttpStatus.SC_OK,httpResponse2.getStatusLine().getStatusCode() );
    }


    @Test
    public void requestFail() throws InterruptedException, IOException {
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


        HttpPost newPost = new HttpPost(IDENTIFY_NANNY_URL);
        //设置超时时间
        newPost.setConfig(requestConfig);
        JSONObject employerData = new JSONObject();
        employerData.put("workPlace", "北京");  //请求参数
        employerData.put("isNeedLive", "是");  //请求参数
        employerData.put("experience", "1年以上");  //请求参数
        employerData.put("employerEducation", "初中");  //请求参数
        employerData.put("employerSalary", "www");  //请求参数
        employerData.put("employerRestTime", "10");  //请求参数
        employerData.put("babyyear", "1999");  //请求参数
        employerData.put("babymonth", "10");  //请求参数
        employerData.put("babydate", "22"); //请求参数
        employerData.put("babyBirthWeight", "1");  //请求参数
        employerData.put("motherAge", "20");  //请求参数
        employerData.put("motherWeight", "50"); //请求参数
        employerData.put("motherHeight", "165");  //请求参数
        employerData.put("deliveryTimes", "1");  //请求参数
        employerData.put("deliveryMode", "顺产");  //请求参数
        //System.out.println(employerData.toString());

        List<BasicNameValuePair> list1 = new ArrayList<BasicNameValuePair>();
        list1.add(new BasicNameValuePair("employerData", employerData.toString()));  //请求参数
        UrlEncodedFormEntity entity2 = new UrlEncodedFormEntity(list1, "UTF-8");
        newPost.setEntity(entity2);
        HttpResponse httpResponse2 = httpClient.execute(newPost);


        if (httpClient != null) {
            httpClient.close(); //释放资源
        }

        Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,httpResponse2.getStatusLine().getStatusCode() );
    }
}
