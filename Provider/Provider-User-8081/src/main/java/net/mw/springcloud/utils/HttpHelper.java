/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package net.mw.springcloud.utils;


import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//import net.kyjun.superw6.baiye.payutils.WXPayConstants;

/**
 * http访问操作工具类.
 * 
 * @since 0.2.1
 */
public final class HttpHelper {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(HttpHelper.class);
    
    /**
	 * 编码格式.
	 * */
	public static final String UTF_8 = "UTF-8";
	
	/**
	 * 发送成功状态码.
	 * */
	public final static Integer HTTP_POST_SUCCESS_CODE = 200;
    
    /**
     * http客户端.
     */
    private static CloseableHttpClient client = HttpClientBuilder.create()
            .build();

    /**
     * http访问操作工具类的私有构造方法，其作用是为了防止用户显式生成工具类的实例对象.
     * 
     */
    private HttpHelper() {
    }

    /**
     * 使用get方式来访问传入的url，并返回服务器反馈到的信息.
     * 
     * @param url
     *            需要访问的url
     * @return 服务器反馈信息
     */
    public static String requestByGet(final String url) {
        logger.debug("进入方法requestByGet");
        logger.info("url:" + url);

        String response = "";
        try {

            HttpGet httpget = new HttpGet(url);

            httpget.setConfig(RequestConfig.custom().setSocketTimeout(3000)
                    .setConnectTimeout(3000).build());
            response = client.execute(httpget, new BasicResponseHandler());

        } catch (SocketTimeoutException e) {
            // logger.error("SocketTimeoutException:", e);
        } catch (ConnectTimeoutException e) {
            // logger.error("ConnectTimeoutException:", e);
        } catch (UnknownHostException e) {
            // logger.error("UnknownHostException:", e);
        } catch (ClientProtocolException e) {
            // logger.error("ClientProtocolException:", e);
        } catch (IOException e) {
            // logger.error("IOException:", e);
        }

        logger.debug("退出方法requestByGet");
        return response;
    }

    /**
     * @param host
     *            主机
     * @param path
     *            子路径
     * @param method
     *            请求方法
     * @param headers
     *            请求头
     * @param querys
     *            参数
     */
    public static String doGet(final String host, final String path,
                               final String method, final Map<String, String> headers,
                               final Map<String, String> querys) {
        logger.debug("进入方法requestByGet");

        String url = buildUrl(host, path, querys);
        logger.info("url:" + url);
        String response = "";
        try {

            HttpGet httpget = new HttpGet(url);
            for (Entry<String, String> e : headers.entrySet()) {
                httpget.addHeader(e.getKey(), e.getValue());
            }
            httpget.setConfig(RequestConfig.custom().setSocketTimeout(3000)
                    .setConnectTimeout(3000).build());
            response = client.execute(httpget, new BasicResponseHandler());

        } catch (SocketTimeoutException e) {
            logger.error("SocketTimeoutException:", e);
        } catch (ConnectTimeoutException e) {
            logger.error("ConnectTimeoutException:", e);
        } catch (UnknownHostException e) {
            logger.error("UnknownHostException:", e);
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException:", e);
        } catch (IOException e) {
            logger.error("IOException:", e);
        }

        logger.debug("退出方法requestByGet");
        return response;
    }

    /**
     * 使用get方式来访问传入的url，并返回服务器反馈到的信息.
     *
     * @param url
     *            需要访问的url
     * @return 服务器反馈信息
     */
    public static String requestByPost(final String url,
                                       final Map<String, String> parms) {
        logger.debug("进入方法requestByPost");
        logger.info("url:" + url);

        String response = "";
        try {

            HttpPost httpPost = new HttpPost(url);

            NameValuePair tempPair = null;
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Entry<String, String> entry : parms.entrySet()) {
                tempPair = new BasicNameValuePair(entry.getKey(),
                        entry.getValue());
                nvps.add(tempPair);
            }

            // 设置参数到请求对象中
            httpPost.setEntity(new UrlEncodedFormEntity(nvps,
                    CharEncoding.UTF_8));
            httpPost.setConfig(RequestConfig.custom().setSocketTimeout(3000)
                    .setConnectTimeout(3000).build());
            response = client.execute(httpPost, new BasicResponseHandler());

        } catch (SocketTimeoutException e) {
            logger.error("SocketTimeoutException:", e);
        } catch (ConnectTimeoutException e) {
            logger.error("ConnectTimeoutException:", e);
        } catch (UnknownHostException e) {
            logger.error("UnknownHostException:", e);
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException:", e);
        } catch (IOException e) {
            logger.error("IOException:", e);
        }

        logger.debug("退出方法requestByPost");
        return response;
    }

    /**
     * 使用get方式来访问传入的url，并返回服务器反馈到的信息.
     *
     * @param url
     *            需要访问的url
     * @return 服务器反馈信息
     */
//    public static String requestByPost(final String url,
//            final Map<String, String> parms, final String body,
//            final String MchID) {
//        logger.debug("进入方法requestByPost");
//        logger.info("url:" + url);
//
//        String response = "";
//        try {
//
//            HttpPost httpPost = new HttpPost(url);
//
//            if (parms != null && parms.size() != 0) {
//                NameValuePair tempPair = null;
//                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//                for (Entry<String, String> entry : parms.entrySet()) {
//                    tempPair = new BasicNameValuePair(entry.getKey(),
//                            entry.getValue());
//                    nvps.add(tempPair);
//                }
//                // 设置参数到请求对象中
//                httpPost.setEntity(new UrlEncodedFormEntity(nvps,
//                        CharEncoding.UTF_8));
//            }
//            // 设置参数到请求对象中
//            httpPost.addHeader("Content-Type", "text/xml");
//            httpPost.addHeader("User-Agent", WXPayConstants.USER_AGENT + " " + MchID);
//            httpPost.setEntity(new StringEntity(body, "UTF-8"));
//            httpPost.setConfig(RequestConfig.custom().setSocketTimeout(3000)
//                    .setConnectTimeout(3000).build());
//            response = client.execute(httpPost, new BasicResponseHandler());
//
//        } catch (SocketTimeoutException e) {
//            logger.error("SocketTimeoutException:", e);
//        } catch (ConnectTimeoutException e) {
//            logger.error("ConnectTimeoutException:", e);
//        } catch (UnknownHostException e) {
//            logger.error("UnknownHostException:", e);
//        } catch (ClientProtocolException e) {
//            logger.error("ClientProtocolException:", e);
//        } catch (IOException e) {
//            logger.error("IOException:", e);
//        }
//
//        logger.debug("退出方法requestByPost");
//        return response;
//    }

    public static InputStream postJson(String url, String json) {
        InputStream is = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);
            HttpResponse response;
            response = httpClient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK == code) {
                is = response.getEntity().getContent();
            }
        } catch (Exception e) {
            logger.error("Exception:", e);
        } finally {
        }
        return is;
    }

    private static String buildUrl(String host, String path,
                                   Map<String, String> querys) {

        StringBuilder sbUrl = new StringBuilder();
        try {
            sbUrl.append(host);
            if (!StringUtils.isBlank(path)) {
                sbUrl.append(path);
            }
            if (null != querys) {
                StringBuilder sbQuery = new StringBuilder();
                for (Entry<String, String> query : querys.entrySet()) {
                    if (0 < sbQuery.length()) {
                        sbQuery.append("&");
                    }
                    if (StringUtils.isBlank(query.getKey())
                            && !StringUtils.isBlank(query.getValue())) {
                        sbQuery.append(query.getValue());
                    }
                    if (!StringUtils.isBlank(query.getKey())) {
                        sbQuery.append(query.getKey());
                        if (!StringUtils.isBlank(query.getValue())) {
                            sbQuery.append("=");
                            sbQuery.append(URLEncoder.encode(query.getValue(),
                                    "utf-8"));
                        }
                    }
                }
                if (0 < sbQuery.length()) {
                    sbUrl.append("?").append(sbQuery);
                }
            }
        } catch (UnsupportedEncodingException e) {

        }
        return sbUrl.toString();
    }

    /**
     * 发送soap
     *
     * @param url
     *            请求路径
     * @soap xml格式的string字符串
     * @param 可为空
     */
    public static String doPostSoap(String url, String soap, String SOAPAction) {
        logger.info("进入doPostSoap");
        // 请求体
        String retStr = "";
        try {
            // 创建HttpClientBuilder
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            // HttpClient
            CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
            HttpPost httpPost = new HttpPost(url);
            // 设置请求和传输超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000).setConnectTimeout(2000).build();
            httpPost.setConfig(requestConfig);

            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", SOAPAction);
            StringEntity data = new StringEntity(soap, Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            CloseableHttpResponse response = closeableHttpClient
                    .execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                retStr = EntityUtils.toString(httpEntity, "UTF-8");
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (SocketTimeoutException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            logger.info(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
        logger.info("退出doPostSoap");
        return retStr;
    }

    /**
	 * post请求.
	 *
	 * @param url 请求URL.
	 * @param params json参数.
	 * @param encoding 编码格式.
	 * @param contentType 请求数据格式.
	 * @return Map<String,Object> 返回结果集合.
	 *
	 * @author 张剑民
	 * @since 6.0.0
	 */
	public static Map<String, Object> doPost(String url, Map<String, String> params, String encoding, String contentType) {
		logger.debug("进入doPost方法");

		Map<String, Object> responeMap = null;
		try {

			responeMap = new HashMap<>();

			HttpPost httpPost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			for(Entry<String, String> entry : params.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey() , entry.getValue()));
			}

			//设置参数.
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps);
			entity.setContentEncoding(encoding);
			entity.setContentType(contentType);
			httpPost.setEntity(entity);

			//获取响应对象.
			HttpResponse response = client.execute(httpPost);
			//获取响应体.
			HttpEntity responseEntity = response.getEntity();

			String statusCode = String.valueOf(response.getStatusLine().getStatusCode());

			responeMap.put("response_code", statusCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(responseEntity.getContent(), "utf-8"));
			responeMap.put("response_data", in.readLine());
		}catch(Exception e) {
			e.printStackTrace();
		}
		logger.debug("退出doPost方法");
		return responeMap;
	}

	  /**
		 * post请求.
		 *
		 * @param url 请求URL.
		 * @param params json参数.
		 * @return Map<String,Object> 返回结果集合.
		 *
		 * @author 张剑民
		 * @since 6.0.0
		 */
	public static Map<String, Object> sendPost(String url, Map<String, String> params) {

		Map<String, Object> responeMap = null;
		URL u = null;
		HttpURLConnection con = null;
		//构建请求参数
		StringBuffer sb = new StringBuffer();
		if(params != null) {
			for(Entry<String, String> e : params.entrySet()) {
				sb.append(e.getKey()).append("=").append(e.getValue()).append("&");
			}
			sb.substring(0,sb.length() - 1);
		}
		//尝试发送请求
		try {
			responeMap = new HashMap<>();
			
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("POST");
			con.setConnectTimeout(6000);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(),"UTF-8");
			osw.write(sb.toString());
			osw.flush();
			osw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				con.disconnect();
			}
		}
		//读取返回内容
		BufferedReader in = null;
		try {
			
			responeMap.put("response_code", con.getResponseCode());
			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			responeMap.put("response_data", in.readLine());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return responeMap;
	}
	
	 /**
		 * get请求.
		 * 
		 * @param url 请求URL.
		 * @param encoding 编码格式.
		 * 
		 * @author 张剑民
		 * @since 6.0.0
		 */
		public static Map<String, Object> sendGet(String url, String encoding) {
			logger.debug("进入sendGet方法");

			Map<String, Object> responeMap = null;
			try {
				
				responeMap = new HashMap<>();
				
				HttpGet httpGet = new HttpGet(url);
				
				//获取响应对象.
				HttpResponse response = client.execute(httpGet);
				//获取响应体.
				HttpEntity responseEntity = response.getEntity();
				
				String statusCode = String.valueOf(response.getStatusLine().getStatusCode());
				
				responeMap.put("response_code", statusCode);
				BufferedReader in = new BufferedReader(new InputStreamReader(responseEntity.getContent(), encoding));
				responeMap.put("response_data", in.readLine());
			}catch(Exception e) {
				e.printStackTrace();
			}
			logger.debug("退出sendGet方法");
			return responeMap;
		}
	
}
