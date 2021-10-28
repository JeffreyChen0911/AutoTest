package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //用来存储Cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;

        /*
        // 测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();//已弃用
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.printf(result.replaceAll("%", "%%"));
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        */


        //CloseableHttpClient替换DefaultHttpClient获取cookies
        store = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.printf(result + "\n");
        //获取cookies信息
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie: cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.printf("cookie name = " + name
            + "; cookie value = " + value + "\n");
        }

        client.close();
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        /*
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        */

        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(this.store).build();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.printf("statusCode = " + statusCode + "\n");

        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.printf(result + "\n");
        }
    }

}
