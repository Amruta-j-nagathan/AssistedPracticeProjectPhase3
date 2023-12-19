package restassuredscripts;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Script008GitHubBearerToken {
	@Test(priority = '1')
	public void Authorization_bearertoken() {
		
		Response res = given().baseUri("https://api.github.com")
		.basePath("/user/repos")
		.header("Authorization","Bearer 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")
		.when().get()
		.then().statusCode(200)
		.extract().response();
		
		res.prettyPrint();
		
		
	}
	
	@Test(priority='2')
	public void Authorization_bearertoken_specificRepo() {
		
		Response res=given().baseUri("https://api.github.com")
		.basePath("/repos/Amruta-j-nagathan/todayslpro")
		.header("Authorization", "Bearer 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")
		.when().get()
		.then().statusCode(200)
		.extract().response();
		
		res.prettyPrint();
		
		//https://github.com/Amruta-j-nagathan/todayslpro		
	}

}
