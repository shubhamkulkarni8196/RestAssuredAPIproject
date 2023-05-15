import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_GET_Request {
	
	@Test
	void getHeader() {
		
		//specify base url
		RestAssured.baseURI = "https://developers.google.com/";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//response object
		Response response = httprequest.request(Method.GET,"/s/results/maps?q=super%20market&text=super%20market");
		
		//print response in console 
		String responseBody = response.getBody().asString();
		
		System.out.println("response body is" + responseBody);
		
        //capture details of headers from response 
		
		 String contentType =  response.header("Content-Type");
		 
		 System.out.println("content type is" + contentType);
		 
		 Assert.assertEquals(contentType, "text/html; charset=utf-8");
		 
		 String contentencoding = response.header("Content-Encoding");
		 
		 System.out.println("content encoding value is" + contentencoding);
		 
		 Assert.assertEquals(contentencoding, "gzip");
	}
}
