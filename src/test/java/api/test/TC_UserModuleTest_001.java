package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class TC_UserModuleTest_001 extends BaseClass{
	
	public Faker fkr;
	public User payload ;
	
	@BeforeClass
	public void setUserDetails() {
		fkr = new Faker();
		payload = new User();
		
		payload.setId(fkr.idNumber().hashCode());
		payload.setUsername(fkr.name().username());
		payload.setFirstName(fkr.name().firstName());
		payload.setLastName(fkr.name().lastName());
		payload.setEmail(fkr.internet().emailAddress());
		payload.setPhone(fkr.phoneNumber().cellPhone());
		payload.setPassword(fkr.internet().password());
		payload.setUserStatus(0);
		
		}
	
	@Test(priority=1)
	public void createUserDetail() {
		logger.info("*****Running create user request**********");
		
	Response response = UserEndpoints.createUser(payload);
	response.then().log().body().and().statusCode(200);
	
	}
	
	@Test(priority=2)
	public void getUserDetail() {
		logger.info("*****Running get user request**********");
		Response response = UserEndpoints.getUser(payload.getUsername())	;
		response.then().log().body().and().statusCode(200);
	}
	
	@Test(priority=3)
	public void updateUserDetail() {
		logger.info("*****Running update user request**********");
		Response response = UserEndpoints.updateUser(payload.getUsername(), payload);
		response.then().log().body().and().statusCode(200);
	}
	
	@Test(priority=4)
	public void deleteUserDetail() {
		logger.info("*****Running delete user request**********");
		Response response = UserEndpoints.deleteUser(payload.getUsername())	;
		response.then().log().body().and().statusCode(200);
	}

}
