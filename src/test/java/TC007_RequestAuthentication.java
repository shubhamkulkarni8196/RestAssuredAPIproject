import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_RequestAuthentication {
	
	
	@Test
	public void AutherisationTest() {
		
		
		//specify baseURi
		
		RestAssured.baseURI = "https://demoqa.com";
		
		//Basic Authentication 
		
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		
		authscheme.setUserName("toool");
		authscheme.setPassword("test");
	
		RestAssured.authentication = authscheme;
		
		//Request object
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Response Object
		
		Response response = httprequest.request(Method.GET, "/auth");
		
		//print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("response body is" + responseBody);
		
		//status code validation
		
		int statuscode = response.getStatusCode();
		System.out.println("status code is"+ statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
	}
	
	
	
	

}
