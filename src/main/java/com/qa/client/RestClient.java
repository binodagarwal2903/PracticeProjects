package com.qa.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//1. GET Method
	
	public CloseableHttpResponse get(String URL) throws ClientProtocolException, IOException{
		CloseableHttpClient http = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(URL); //GET Request
		CloseableHttpResponse closebleHttpResponse = http.execute(httpget);
		return closebleHttpResponse;
		
	}

}
