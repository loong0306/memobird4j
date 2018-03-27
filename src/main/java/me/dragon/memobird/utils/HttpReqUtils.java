package me.dragon.memobird.utils;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * <p>Title: HttpReqUtils. </p>
 * <p>Description HttpClient请求封装工具类 </p>
 * @author dragon
 * @date 2018/3/27 下午1:52
 */
public class HttpReqUtils {

    /**
     * <p>Title: doGeting. </p>
     * <p>HttpClient GET请求 </p>
     * @param url
     * @param params
     * @author dragon
     * @date 2018/3/27 下午1:55
     * @return json
     */
    public static String doGeting(String url, List<NameValuePair> params) {
        String resultJson = "";
        try {
            if (StringUtils.isSEmptyOrNull(url)) {
                throw new Exception("请求API接口地址不能为空");
            }
            HttpClient client = HttpClients.createDefault();
            String urlParams = "";
            if (!ListUtils.isEmpty(params)) {
                urlParams = "?" + EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            }
            HttpGet get = new HttpGet(url + urlParams);
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            resultJson = EntityUtils.toString(entity, "UTF-8");
            System.out.println("MemoBird GET API URL = " + get.getURI());
            System.out.println("MemoBird GET API result = " + resultJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }


    /**
     * <p>Title: doPosting. </p>
     * <p>HttpClient POST请求 </p>
     * @param url
     * @param params
     * @author dragon
     * @date 2018/3/27 下午1:55
     * @return json
     */
    public static String doPosting(String url, List<NameValuePair> params) {
        String resultJson = "";
        try {
            if (StringUtils.isSEmptyOrNull(url)) {
                throw new Exception("请求API接口地址不能为空");
            }
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            if (!ListUtils.isEmpty(params)) {
                post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            }
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            resultJson = EntityUtils.toString(entity, "UTF-8");
            System.out.println("MemoBird POST API URL = " + post.getURI());
            System.out.println("MemoBird POST API result = " + resultJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }


    /**
     * <p>Title: doGetHtml. </p>
     * <p>HttpClient GET 页面渲染请求 </p>
     * @param url
     * @author dragon
     * @date 2018/3/27 下午4:27
     * @return
     */
    public static String doGetHtml(String url, List<NameValuePair> params) {
        String resultJson = "";
        try {
            if (StringUtils.isSEmptyOrNull(url)) {
                throw new Exception("请求API接口地址不能为空");
            }
            HttpClient client = HttpClients.createDefault();
            String urlParams = "";
            if (!ListUtils.isEmpty(params)) {
                urlParams = "?" + EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
            }
            HttpGet get = new HttpGet(url + urlParams);
            HttpResponse response = client.execute(get);
            response.addHeader("Content-type","application/json; charset=utf-8");
            response.setHeader("Accept", "application/json");
            HttpEntity entity = response.getEntity();
            resultJson = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }
}
