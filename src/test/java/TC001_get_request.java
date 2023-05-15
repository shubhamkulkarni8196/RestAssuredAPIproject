import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_get_request {

	@Test
	void getbookDetails() {
		
		//specify base url
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//response object
		Response response = httprequest.request(Method.GET,"/books");
		
		//print response in console 
		String responseBody = response.getBody().asString();
		
		System.out.println("response body is" + responseBody);
		
		
		//status code validation 
		int statuscode = response.getStatusCode();
		
		System.out.println("statsus code is " + statuscode);
	     Assert.assertEquals(statuscode, 200);
	     
	     //status line verification
		
		String statusline = response.getStatusLine();
		
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		
		System.out.println("status line is " + statusline);
		
		}
	
}
