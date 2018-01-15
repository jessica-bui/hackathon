package com.company.hackathon.httpclient.sampleapi;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.hackathon.exception.ApplicationException;
import com.company.hackathon.httpclient.sampleapi.model.Comment;
import com.company.hackathon.httpclient.sampleapi.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Main class to handle http client logic
 */
@Component
public class SampleApiClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleApiClient.class);

	@Autowired
	private SampleApiRestTemplateFactory factory;

	@Value("${sampleApi.authUser}")
	private String authUser;

	@Value("${sampleApi.authPwd}")
	private String authPwd;

	private final ObjectMapper objectMapper;

	public SampleApiClient() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public List<Comment> getCommentsByPostId(Long postId) throws IOException {
		Map<String, String> requestParams = new HashMap<>();
		requestParams.put("postId", String.valueOf(postId));

		// use TypeReference for passing List as type
		List<Comment> response = getUrl("/comments", requestParams, new TypeReference<List<Comment>>() {
		});
		return response;
	}

	public Post createNewPost(Post item) throws IOException {

		// use TypeReference for passing List as type
		return postUrl("/posts", item, Post.class);
	}

	private <T> T getUrl(String apiURL, Map<String, String> requestParams, TypeReference<T> responseClass)
			throws IOException {
		RestTemplate restTemplate = factory.getObject();

		MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<>();
		requestHeaders.add("Content-Type", "application/json");

		HttpEntity<?> request = new HttpEntity<Object>(requestHeaders);

		// restTemplate.getInterceptors().add(new
		// BasicAuthorizationInterceptor(authUser, authPwd));

		MultiValueMap<String, String> requestHeadersMap = new LinkedMultiValueMap<>();
		requestHeadersMap.setAll(requestParams);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(factory.getHost() + apiURL)
				.queryParams(requestHeadersMap);
		ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, request,
				String.class);

		if (!responseEntity.getStatusCode().is2xxSuccessful()) {
			throw new ApplicationException(
					"Error from response - " + responseEntity.getStatusCode() + ", body " + responseEntity.getBody());
		}

		return objectMapper.readValue(responseEntity.getBody(), responseClass);
	}

	private <T> T postUrl(String apiURL, Object requestBody, Class<T> responseClass) throws IOException {
		RestTemplate restTemplate = factory.getObject();

		MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<String, String>();
		requestHeaders.add("Content-Type", "application/json");

		HttpEntity<?> request = new HttpEntity<Object>(requestBody, requestHeaders);

//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(authUser, authPwd));

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(factory.getHost() + apiURL, request,
				String.class, Collections.emptyMap());
		if (!responseEntity.getStatusCode().is2xxSuccessful()) {
			throw new ApplicationException(
					"Error from response - " + responseEntity.getStatusCode() + ", body " + responseEntity.getBody());
		}

		return objectMapper.readValue(responseEntity.getBody(), responseClass);
	}
}
