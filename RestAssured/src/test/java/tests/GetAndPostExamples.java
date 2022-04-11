package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class GetAndPostExamples 
{
    //@Test
	public void testGet()
	{
    	baseURI="https://reqres.in/api";	
    	
    	given().get("/users?page=2").then().statusCode(200).body("data[4].first_name",equalTo("George")).and().body("data.first_name",hasItems("George","Byroni"));
    	
    	
	}
	
	
    @Test
    public void testPost()
    {
//    Map<String,Object> map=new HashMap<String,Object>();
//    map.put("name","Ankita");
//    map.put("job","Engineer");
//    System.out.println(map);
    baseURI="https://reqres.in/api";
    JSONObject request = new JSONObject();
    request.put("name","Ankita");
    request.put("job","Engineer");
    //System.out.println(request);
    	
    given().
   
    body(request.toJSONString()).when().post("api/users").then().statusCode(203).log().all();
    }
}
