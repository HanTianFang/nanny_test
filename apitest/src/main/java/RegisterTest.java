import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.*;

import java.io.IOException;

/**
 * Created by Deft on 2017/5/6.
 */
public class RegisterTest {
    private static final String REGISTER_URL = "http://localhost:8080/nanny/register.action?username=%s&password=%s";
    private  CloseableHttpClient httpclient;
    private  CloseableHttpResponse response;
    @Before
    public void open(){
        httpclient = HttpClients.createDefault();
    }

    @Test
    public void registerSuccess() throws InterruptedException, IOException {

        String username = String.format("%d", System.currentTimeMillis());
        HttpGet httpget = new HttpGet(String.format(REGISTER_URL, username, "mima"));
        response = httpclient.execute(httpget);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode() );

    }

    @Test
    public void registerFail1() throws InterruptedException, IOException {

        String username = String.format("%d", System.currentTimeMillis());
        HttpGet httpget = new HttpGet(String.format(REGISTER_URL, "", "mima"));
        response = httpclient.execute(httpget);
        System.out.println(response.getStatusLine().getStatusCode());
        //Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode() );

    }

    @Test
    public void registerFail2() throws InterruptedException, IOException {

        String username = String.format("%d", System.currentTimeMillis());
        HttpGet httpget = new HttpGet(String.format(REGISTER_URL, username, ""));
        response = httpclient.execute(httpget);
        Assert.assertEquals(HttpStatus.SC_OK,response.getStatusLine().getStatusCode() );

    }

    @After
    public void close(){
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
