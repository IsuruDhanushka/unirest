package com.qa.api;

import org.junit.Test;

import org.testng.Assert;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RestApi {
	
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
	
	
	@Test	
	public void testGetMethod() throws UnirestException{
		
		
		HttpResponse<JsonNode> response = Unirest.get(BASE_URL + "/users").asJson();
		
		Assert.assertEquals(response.getStatus(), 200);
		
		System.out.println(response.getBody());
				
		
	}
	
	@Test
	public void testPostMethod() throws UnirestException {
		
		int i;
		
		for(i=1; i<10; i++) {
		
		HttpResponse<JsonNode> response = Unirest.post(BASE_URL + "/posts").field("title", "assignmet")
				.field("body", "Interview Test").field("userId", 1).asJson();
		
		Assert.assertEquals(response.getStatus(), 201);
		
		}		

		//System.out.println(response.getBody());

		System.out.format("The Number of post method is: %d%n", i);
		
	}
	
	@Test
	public void testPutMethod() throws UnirestException {
		HttpResponse<String> response = Unirest.put(BASE_URL + "/posts/1")
				.body("{\"id\":\"1\",\"title\":\"QA Group Rules\",\"body\":\"Nothing\",\"userId\":\"1\"}").asString();

		System.out.println(response.getBody());
		
		Assert.assertEquals(response.getStatusText(), "OK");
		
	}
	
	@Test
	public void testDeleteMethod() throws UnirestException {
		HttpResponse<String> response = Unirest.delete(BASE_URL + "/posts/1").asString();
		
		System.out.println("Delete");

		Assert.assertEquals(response.getStatus(), 200);
	}

	

}
