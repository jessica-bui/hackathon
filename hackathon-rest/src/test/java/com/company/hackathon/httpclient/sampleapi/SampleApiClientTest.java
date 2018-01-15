package com.company.hackathon.httpclient.sampleapi;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.hackathon.HackathonRestApplication;
import com.company.hackathon.httpclient.sampleapi.model.Comment;
import com.company.hackathon.httpclient.sampleapi.model.Post;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HackathonRestApplication.class)
public class SampleApiClientTest {

	@Autowired
	private SampleApiClient sampleApiClient;
	
	@Test
	public void testGetCommentsByPostId() throws IOException {
		List<Comment> list = sampleApiClient.getCommentsByPostId(1L);
		Assert.assertEquals(5,  list.size());
	}
	
	@Test
	public void testCreateNewPost() throws IOException {
		Post item = new Post();
		item.setBody("My post 1");
		item.setTitle("aaa");
		item.setUserId(1L);
		item = sampleApiClient.createNewPost(item);
		
		Assert.assertNotNull(item.getId());
	}
}
