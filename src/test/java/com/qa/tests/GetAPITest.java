package com.qa.tests;



import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase {
	TestBase testBase;
	String serviceurl;
	String apiUrl;
	String url;
	CloseableHttpResponse closebleHttpResponse;
	RestClient restClient; 
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceurl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		url = serviceurl+apiUrl;
		
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException{
		restClient = new RestClient(); 
		closebleHttpResponse =  restClient.get(url);
		int statusCode = closebleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code --->"+statusCode);
		
		String responseString = EntityUtils.toString(closebleHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API -->"+responseJson);
		
		//1st Way using Lambada
		System.out.println(Arrays.stream(closebleHttpResponse.getAllHeaders()).collect(Collectors.toMap(k->k.getName(), v->v.getValue())));
		
		//2nd Way
		/*Header[] headerArray = closebleHttpResponse.getAllHeaders();
		HashMap<String,String> allheaders = new HashMap<String,String>();
		for(Header header:headerArray){
			allheaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("Header Array -->"+allheaders);
		*/
		
		//3rd Way		
		/*Map<String,String> a = Arrays.stream(headerArray).map(array ->{ 
		String [] headerString = {array.getName(),array.getValue()};
		 return headerString; }).collect(Collectors.toMap(e -> e[0], e-> e[1]));
		System.out.println("Map Header" + a.get("Transfer-Encoding"));*/
				
		RestClient restClient = new RestClient();
		restClient.get(url);
	}
	

}
