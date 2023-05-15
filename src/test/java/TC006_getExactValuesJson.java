import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_getExactValuesJson {
	
	
	@Test
	public void getExactValue() {
		
		RestAssured.baseURI = "https://simple-books-api.glitch.me";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/books");
		
		 JsonPath jsonpath = response.jsonPath(); //capture complete json
		 
		System.out.println( jsonpath.get("id"));
		System.out.println( jsonpath.get("name"));
		System.out.println( jsonpath.get("type"));
		System.out.println( jsonpath.get("available"));
		 
		 Assert.assertEquals(jsonpath.get("id"), "<[1, 2, 3, 4, 5, 6]>");
		
	}

}
