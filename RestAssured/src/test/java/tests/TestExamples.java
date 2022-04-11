package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	//create a function
	
	//add annotation
	//@Test
	public void test_1()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		//System.out.println(response.getTime());
		//System.out.println(response.getBody().asString());
		//System.out.println(response.getHeaders());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200);
	}
	
	@Test
	public void test_2()
	{
	baseURI="https://reqres.in/api/users?page=2";
	given().get(baseURI).then().statusCode(200).
	body("data[1].id", equalTo(8));
	

	}

}
