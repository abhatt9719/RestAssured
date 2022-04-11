package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDelete{
	
	@Test
	public void testPut()
    {
    baseURI="https://reqres.in/";
    JSONObject request = new JSONObject();
    request.put("name","Ankita");
    request.put("job","Engineer");
   
    given().body(request.toJSONString()).when().patch("api/users/2").then().statusCode(200).log().all();
    }
	
	@Test
	public void testDelete()
	{
	baseURI="https://reqres.in/";
	when().delete("/api/users/2").then().statusCode(204).log().all();	
	}

}
