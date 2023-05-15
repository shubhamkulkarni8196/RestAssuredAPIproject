import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_validateJsonResponse {

	
	@Test
	public void validateJsonData() {
		
		
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET, "/books");
		
		 String responseBody = response.getBody().asString();
		 
		 System.out.println("response body is " + responseBody);
		 
		 Assert.assertEquals(responseBody.contains("1"), true);
		
	}
	
}
