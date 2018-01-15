package com.company.hackathon.httpclient;

import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * This class contains generic setting for all http client 
 */
public class HttpComponentsClientHttpRequestFactoryBasicAuth extends HttpComponentsClientHttpRequestFactory {

	HttpHost host;

	public HttpComponentsClientHttpRequestFactoryBasicAuth(HttpHost host) {
		super();
		this.setConnectTimeout(5000);
		this.setConnectionRequestTimeout(5000);
		this.setReadTimeout(30000);
		this.host = host;
	}

	protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
		return createHttpContext();
	}

	/**
	 * Authenticate sheme, for this example is basic, but not use
	 */
	private HttpContext createHttpContext() {
		AuthCache authCache = new BasicAuthCache();

		BasicScheme basicAuth = new BasicScheme();
		authCache.put(host, basicAuth);

		BasicHttpContext localcontext = new BasicHttpContext();
		localcontext.setAttribute(HttpClientContext.AUTH_CACHE, authCache);
		return localcontext;
	}
}
