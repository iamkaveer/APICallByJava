package com.chucknorris.chuckNorris;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App 
{
    public static void main( String[] args )
    {
    	try {
    		newAPI();
    	}catch (URISyntaxException e) {
    		System.out.print("No");
    	}catch (IOException e) {
    		System.out.print("No");
    	}
    }
    
    public static void newAPI() throws URISyntaxException, IOException {
    	
    	URIBuilder builder = new URIBuilder("https://api.nationalize.io/?name=nathaniel");
    	//build object 
    	HttpGet getData = new HttpGet(builder.build());
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	CloseableHttpResponse respone = httpClient.execute(getData);
    	HttpEntity responseEntity = respone.getEntity();
    	String result = EntityUtils.toString(responseEntity);
    	System.out.println("JSON data :");
    	System.out.println(result);
    	httpClient.close();
    }
}

