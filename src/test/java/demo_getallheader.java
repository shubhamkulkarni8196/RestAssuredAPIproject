import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class demo_getallheader {
	
	@Test
	public void getheaderdetail() {
			
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
			
			 Headers allheader = response.headers();
			 
			 for( Header header : allheader){
				 
				 System.out.println(header.getName() + "   " +header.getValue() );
				
			 }
			 
		}
}

