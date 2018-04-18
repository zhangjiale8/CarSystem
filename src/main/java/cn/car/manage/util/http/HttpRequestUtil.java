package cn.car.manage.util.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName: HttpRequestUtil
 * @Description:http请求工具类
 * @author 
 * @date 2016年9月19日 上午11:24:22
 */
public class HttpRequestUtil {

	private static final RequestConfig config = RequestConfig.custom().setSocketTimeout(300000).setConnectTimeout(300000).build();

	/**
	 * @Title: httpGet
	 * @Description:httpGet请求
	 * @author: 
	 * @date: 2016年9月19日 上午11:24:43
	 * @param url
	 * @return
	 */
	public static String httpGet(String url) {
		if (url == null || url.trim().isEmpty()) {
			return null;
		}
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = null;
		String content = null;
		try {
			get.setConfig(config);
			response = client.execute(get);

			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.err.println("请求错误:" + response.getStatusLine().getStatusCode());
				return null;
			}
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	/**
	 * @Title: httpPost
	 * @Description:httpPost请求
	 * @author: 
	 * @date: 2016年9月19日 上午11:25:04
	 * @param url
	 * @param map
	 * @param charset
	 * @return
	 */
	public static String httpPost(String url, Map<String, String> map, String charset) {
		if (url == null || url.trim().isEmpty()) {
			return null;
		}

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = null;
		String content = null;
		try {
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, Charset.forName(charset));
				post.setEntity(entity);
			}

			post.setConfig(config);
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	/**
	 * @Title: httpsGet
	 * @Description:httpsGet请求
	 * @author: 
	 * @date: 2016年9月19日 上午11:25:17
	 * @param url
	 * @return
	 */
	public static String httpsGet(String url) {
		if (url == null || url.trim().isEmpty()) {
			return null;
		}

		TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] certificate, String authType) {
				return true;
			}
		};
		SSLContext sslContext = null;
		String content = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient client = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, acceptingTrustStrategy).build();
			SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
			client = HttpClients.custom().setSSLSocketFactory(sslFactory).build();
			HttpGet get = new HttpGet(url);
			get.setHeader("Accept-Encoding", "identity");
			get.addHeader("Accept", "text/html");
			get.addHeader("Accept-Charset", "utf-8");
			get.addHeader("Accept-Encoding", "gzip");
			get.addHeader("Accept-Language", "en-US,en");
			get.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
			get.setConfig(config);
			response = client.execute(get);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	/**
	 * @Title: httpsPost
	 * @Description:httpsPost请求
	 * @author: 
	 * @date: 2016年9月19日 上午11:25:33
	 * @param url
	 * @param map
	 * @param charset
	 * @return
	 */
	public static String httpsPost(String url, Map<String, String> map, String charset) {
		if (url == null || url.trim().isEmpty()) {
			return null;
		}
		TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] certificate, String authType) {
				return true;
			}
		};
		SSLContext sslContext = null;
		String content = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient client = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, acceptingTrustStrategy).build();
			SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
			client = HttpClients.custom().setSSLSocketFactory(sslFactory).build();
			HttpPost post = new HttpPost(url);
			post.setHeader("Accept-Encoding", "identity");
			post.addHeader("Accept", "text/html");
			post.addHeader("Accept-Charset", "utf-8");
			post.addHeader("Accept-Encoding", "gzip");
			post.addHeader("Accept-Language", "en-US,en");
			post.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.160 Safari/537.22");
			post.setConfig(config);
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String> elem = iterator.next();
				list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, Charset.forName(charset));
				post.setEntity(entity);
			}
			response = client.execute(post);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null)
					response.close();
				if (client != null)
					client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
}
