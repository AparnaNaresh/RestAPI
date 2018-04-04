package restFramework.com.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restFramework.com.rest.requestpojo.CreatePerson;
import restFramework.com.rest.responsepojo.CreatePersonResponse;

public class Service {

	// Post 
	
	List<JSONObject> list;
	public Response createPerson(String name, String job)
	{
		
		CreatePerson person = new CreatePerson();//Pojo class
		person.setName(name);
		person.setJob(job);
		
		// convert pojo class to json object
		
		JSONObject jsonobj = new JSONObject(person);
		
		list = new ArrayList<JSONObject>();
		list.add(jsonobj);
		RequestSpecification requestspec = RestAssured.given();
		requestspec.contentType("application/json"); // send json request to server
		requestspec.accept("application/json");// accept json response from server
		
	
		// set body
		
		requestspec.body(list.toString());
		
		//post request and get response
		Response response = requestspec.post(ServiceURL.createPersonURL);
		
		return response;
		
	}
	
	public void getResponse()
	{
		RequestSpecification get = RestAssured.given();
		Response getResponse = get.post(ServiceURL.getURL);
		System.out.println(getResponse);
		JSONObject json = new JSONObject(getResponse);
		
		System.out.println(json);
		System.out.println(json.toString());
	}
	
	// to check above api
	@Test(enabled = false)
	public void test()
	{
		Service service = new Service();
		Response res = service.createPerson("Aparna", "Software Engineer");
		System.out.println(res.asString());
		int statusCode = res.getStatusCode();
		System.out.println(statusCode);// 201 means successfully posted
		
		// it will intialize response pojo class with response json
//		Gson gson = new Gson();
//		CreatePersonResponse resp=gson.fromJson(res.asString(), CreatePersonResponse.class);
//		
//		
//		String name =resp.getName();
//		System.out.println(name);
			
	}
		@Test
		public void get()
		{
			getResponse();
		}
}
