package restassuredscripts;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Script006PostmanAPIKey {
	@Test(priority='1')
	public void postmangetReq() {

		String PMapikey = "PMAK-657b263350cb3f00386a3a9b-b7d2f80329511182bc480ede9ce0f94133";

		given().baseUri("https://api.postman.com").basePath("/workspaces").header("x-api-key", PMapikey).when().get()
				.then().statusCode(200).log().all();

	}

	@Test(priority='2')
	public void extract_value_response() {
		String PMapikey = "PMAK-657b263350cb3f00386a3a9b-b7d2f80329511182bc480ede9ce0f94133";

		String responseoutput = given().baseUri("https://api.postman.com").basePath("/workspaces")
		.header("x-api-key", PMapikey).when().get()
		.then()
		.extract().path("workspaces[3].name");// extracting
																											// the name
																											// and save
																											// it in a string																									// string
		System.out.println("the name of the workspace is extracting : " + responseoutput);
		

	}
	@Test(priority='3')
	public void extract_response_JSONPath() {
		String PMapikey = "PMAK-657b263350cb3f00386a3a9b-b7d2f80329511182bc480ede9ce0f94133";
		Response res = given().baseUri("https://api.postman.com").basePath("/workspaces")
				.header("x-api-key", PMapikey).when().get()
				.then()
				.extract().response();//extracting the response and sva it in a Response object
		
		JsonPath json = new JsonPath(res.asString());
		
		System.out.println(json.getString("workspaces[10]"));
		System.out.println(json.getString("workspaces[10].type"));
		System.out.println(json.getString("workspaces[10].visibility"));
		
		
	}

}
