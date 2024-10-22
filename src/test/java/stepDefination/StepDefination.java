package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.API_Resources;
import resources.TestDataBuilder;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification request;
	Response response;
	static String place_Id;
	 TestDataBuilder data =new TestDataBuilder();
	 
	 @Given("Add place Payload with {string} {string} {string}")
	 public void add_place_payload_with(String name, String language, String address) throws IOException {
		
	 request=given().spec(requestSpecification())
				.body(data.addPlacePayload(name,language,address));
	    
	}

	 @When("user call {string} with {string} http request")
	 public void user_call_with_http_request(String resource, String method) {
		
		 
		API_Resources resourceAPI=API_Resources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		if(method.equalsIgnoreCase("POST")) 
		 response=request.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("get"))
			 response=request.when().get(resourceAPI.getResource());
		
	   
	}

	@Then("the api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	   
		
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		
	
		assertEquals(getJsonPath(response,key),value);
		
	   
	}
	
	@Then("verify with the PlaceId as {string} with {string}")
	public void verify_with_the_place_id_as_with(String expectedName, String resource) throws IOException {
		
		 place_Id=getJsonPath(response,"place_id");
	
		request=given().spec(requestSpecification()).queryParam("place_id",place_Id );
		user_call_with_http_request(resource,"GET");
	String ActualName=	getJsonPath(response,"name");
	assertEquals(ActualName,expectedName);
		
	}

@Given("delete place payload")
public void delete_place_payload() throws IOException {
	
	request=given().spec(requestSpecification()).body(data.deletePayload(place_Id));
}




}
