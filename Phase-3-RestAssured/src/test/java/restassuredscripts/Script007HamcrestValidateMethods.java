package restassuredscripts;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Script007HamcrestValidateMethods {
	
	// Hamcrest dependency has been added to your POM file
	// This dependency provides us many validation methods that help us to validate the response code
	
	// equalTo() Hamcrest method
	
	@Test(priority='1')
	public void ValidateResponseBody() {
		
		String PMapikey="PMAK-657b263350cb3f00386a3a9b-b7d2f80329511182bc480ede9ce0f94133";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMapikey )
		.when().get()
		.then().statusCode(200)
		//fetch the resonse body and validate if response includes correct values or not
		
		.body("workspaces[1].id", equalTo("9ed6fd3d-34fb-4c1b-8448-39d44801968d"),
				"workspaces[1].name", equalTo("Phase-3-Postman"),
				"workspaces[1].type", equalTo("personal"));
			  	
	}
	
	@Test(priority='2')
	public void ValidateResponseBody_equalTo() {
		
		
		given().baseUri("https://petstore.swagger.io")
		.basePath("/v2/user/amrutaa")
		.when().get()
		.then().statusCode(200)
		//fetch the response body and validate if response includes correct values or not
		
		.body("username", equalTo("amrutaa"),
			 ("firstName"),equalTo("Amruta"),
			 ("lastName"),equalTo("N"),
			 ("email"),equalTo("feelsmile@gmail.com"),
			 ("userStatus"),equalTo(1));
			 
			 		
	}
	@Test(priority='3')
	public void ValidateResponseBody_hasItems() {
		
	String PMapikey="PMAK-657b263350cb3f00386a3a9b-b7d2f80329511182bc480ede9ce0f94133";
		
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMapikey )
		.when().get()
		.then().statusCode(200)
		// fetch the response body and validate if response includes correct values or not
		
		.body("workspaces.name", hasItems("Workspace-1", "My Workspace", "Workspace-y"),
			 "workspaces.type", hasItems("personal"));
		
		
	}
	
	

}