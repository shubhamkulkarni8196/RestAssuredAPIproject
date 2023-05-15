package dataDrivenTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDrivenTest_addnewEmployes {
	
	
	@Test(dataProvider = "empdataprovider")
	void addnewEmployes(String ename , String esalary, String eage) {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		//we creatred data
		JSONObject requestparam = new JSONObject();
		
		requestparam.put("name", ename);
		requestparam.put("salary", esalary);
		requestparam.put("age", eage);
		
		//add header 
		httprequest.header("Content-Type", "application/json");
		
		//add json to body of request
		httprequest.body(requestparam.toJSONString());
		
		//post request 
		
		Response response = httprequest.request(Method.POST, "/create");
		
		//capture response body to perform validation
		String responseBody = response.getBody().asString();
		
         Assert.assertEquals(responseBody.contains(ename),true);
         Assert.assertEquals(responseBody.contains(esalary),true);
         Assert.assertEquals(responseBody.contains(eage),true);
         
         int statuscode = response.getStatusCode();
         
         Assert.assertEquals(statuscode, 200);
         
	}
         
            @DataProvider(name="empdataprovider")
	        String[][] getempData() {
        	 
             String path = System.getProperty("user.dir")+"\\src\\test\\empdata.xlsx";
        	//
             String empdata[][] = {{"abc100", "15400", "45"},{"xy100", "154400", "45"},{"ertr10", "152400", "35"}};
        	 return(empdata);
         }
         
	}


