package RestAssure_Practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;
import files.Payload1;

public class Basics {

	public static void main(String[] args) {
 // Validate if add place API is working as expected
		
		//given:=all input details
		//when: submit the API-resource,HTTP Method
		//then: validate the response
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("Key","qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		         .header("Server","Apache/2.4.41 (Ubuntu)");
		
//ADD Place ->update place with new address ->Get place to validate if new address is present in response
	}

}
