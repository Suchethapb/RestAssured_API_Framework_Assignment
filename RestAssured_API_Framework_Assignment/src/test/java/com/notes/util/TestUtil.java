package com.notes.util;

import java.io.FileReader;
import java.io.IOException;

import org.apache.http.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestUtil {
	static String outh_token;
	public static String oAuth_Token() {
		RestRequestUtil.setBaseURI();
		RestRequestUtil.setBasePath("");
		
		JSONObject requestParams = new JSONObject();
		//requestParams.put("grant_type", "password");
		requestParams.put("email", "suchetha01@mail.com");
		requestParams.put("password", "API05**");
		
		Response response = RestRequestUtil.responseWithTokenAndBody("post", null, requestParams, "/notes/api");
		RestResponseUtil.checkStatusIs200(response);
		
		
		String outh_token = RestResponseUtil.getValue(response, "data.token");
		System.out.println("oAuth Token is =>  " + outh_token);
		return outh_token;
		
	}

	//get userID given accessToken
	public static String getUserId(String accessToken) {
		RestRequestUtil.setBaseURI();
		RestRequestUtil.setBasePath("/notes/api");

//		RequestSpecification req = RestAssuredUtil.auth2(accessToken);
//		Response response = RestAssuredUtil.get(req, "/account");
		Response response = RestRequestUtil.responseWithTokenAndBody("get", accessToken, null, "/notes");
		RestResponseUtil.checkStatusIs200(response);
		return RestResponseUtil.getValue(response, "data.id");
	}
	
	public static JSONObject generateJSONAddress(String title, String description, String category) {
		JSONObject body = new JSONObject();
		body.put("title", title);
		body.put("description", description);
		body.put("category", category);
		
		return body;
	}
	
	@Test(priority=2)
	public static void createnote() throws IOException, ParseException {
		
//		JSONParser jsonparser = new JSONParser();
//		// Create object for FileReader class, which help to load and read JSON file
//		FileReader reader = new FileReader(".\\TestData\\Notess.json");
//		// Returning/assigning to Java Object
//		Object obj = jsonparser.parse(reader);
//		// Convert Java Object to JSON Object, JSONObject is typecast here
//		JSONObject prodjsonobj = (JSONObject) obj;
//		System.out.println("PASS");

//		RestRequestUtil.setBaseURI();
//		RestRequestUtil.setBasePath("/notes/api");
//		request.header("x-auth-token",outh_token );
//		request.body(prodjsonobj.toJSONString());
		outh_token=TestUtil.oAuth_Token();
		
		RestRequestUtil.reqWithToken(req,outh_token);
		//request.header("x-auth-token",outh_token );
		// POST the Response
		//Response response = req.request(Method.POST, "/notes/api/notes");
		// Response response = request.request(Method.POST,"/spree_oauth/token");
		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		// System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
		// To get the Token from JSON Response
		//JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		notesid = jsonPathEvaluator.get("data.id").toString();
		
		String fname = jsonPathEvaluator.get("data.title").toString();
		System.out.println("Title is =>  " + fname);
		Assert.assertEquals("Practice WebApp UI", fname);

	}
//	public static JSONObject generateJSONAddress(String fName, String lName, String address1,
//			String city, String zipcode, String phone, String state, String country, String label) {
//		JSONObject newAddress = new JSONObject();
//		newAddress.put("firstname", fName);
//		newAddress.put("lastname", lName);
//		newAddress.put("address1", address1);
//		newAddress.put("city", city);
//		newAddress.put("zipcode", zipcode);
//		newAddress.put("phone", phone);
//		newAddress.put("state_name", state);
//		newAddress.put("country_iso", country);
//		newAddress.put("label", label);
//		JSONObject body = new JSONObject();
//		body.put("address", newAddress);
//		return body;
//	}
	
	public static JSONObject readFile(String filename) throws IOException, ParseException, org.json.simple.parser.ParseException
	{
		
		//Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\JSON_File\\"+filename);
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		return prodjsonobj;
	}
	

}
