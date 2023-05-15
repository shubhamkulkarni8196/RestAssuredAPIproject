import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_post_request {
	
	@Test
	void post() {
		
		//specify base url
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//response object
		
		JSONObject requestParams  = new JSONObject();
		
		requestParams.put("bookId", 1);
		requestParams.put("customerName", "John");
		
		httprequest.header("Content-Type", "application/json");
		
		httprequest.body(requestParams.toJSONString()); //attach data to request
		
		Response response = httprequest.request(Method.POST,"/orders");
		
	String responseBody = response.getBody().asString();
		
		System.out.println("response body is" + responseBody);
		
		//status code validation 
		int statuscode = response.getStatusCode();
		
		System.out.println("statsus code is " + statuscode);
	     Assert.assertEquals(statuscode, 201);
	    
	     String successcode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "operation_sucess");
		}
	

}
