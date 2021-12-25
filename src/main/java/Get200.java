import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Get200 {
	
	HttpClient client;
	public static final String baseURL = "https://api.github.com";
	
	@Before
	public void setup() {
	client = HttpClientBuilder.create().build();//building a client like POSTMAN or CURL
	}
	
	@After
	public void closeResources() throws IOException {
		((Closeable) client).close();
	}
		
	
	@Test
	public void baseUrlReturns200() throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(baseURL);
		HttpResponse response = client.execute(get);
		int actualStatus = response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualStatus,200);
	}
	
	@Test
	public void rateLimitReturns200() throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(baseURL + "/rate_limit");
		HttpResponse response = client.execute(get);
		int actualStatus = response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualStatus,200);
	}

	@Test
	public void searchReposReturns200() throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(baseURL + "/search/repositories");
		HttpResponse response = client.execute(get);
		int actualStatus = response.getStatusLine().getStatusCode();
		Assert.assertEquals(actualStatus,200);
	}
	
}
