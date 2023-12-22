package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.response.Response;
public class UserEndpoints {
	
		
	public static Response createUser(User payload){
		
	Response response = given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(String usernm) {
		
		Response response = given()
				.accept("application/json")
				.pathParam("username", usernm)
				.when()
				.get(Routes.get_url);
				return response;
		
		
	}

	public static Response updateUser(String usernm , User payload) {
		
	Response response = given()
		.accept("application/json")
		.contentType("application/json")
		.pathParam("username", usernm)
		.body(payload)
		.when()
		.put(Routes.update_url);
		return response;
		
	}
	
	public static Response deleteUser(String usernm) {
	Response response = given()
			.accept("application/json")
			.pathParam("username", usernm)
			.when()
			.delete(Routes.delete_url);
			return response;
		
	}

}
