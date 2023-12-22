package api.test;

import org.testng.annotations.Test;
import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.UserDataprovider;
import io.restassured.response.Response;

public class TC_DDTUserModuleTest_002 extends BaseClass {
	
	public User payload ;
			
	@Test(priority=1, dataProvider = "completeUserData", dataProviderClass = UserDataprovider.class)
	public void createUserDetail(String id, String unm, String nm, String lnm, String emal, String pwd, String phone, String status) {
		payload = new User();
		
		payload.setId(Integer.parseInt(id));
		payload.setUsername(unm);
		payload.setFirstName(nm);
		payload.setLastName(lnm);
		payload.setEmail(emal);
		payload.setPassword(pwd);
		payload.setPhone(phone);
		payload.setUserStatus(Integer.parseInt(status));
	
	logger.info("*****Running create user request in DDT**********");
	Response response = UserEndpoints.createUser(payload);
	response.then().log().body().and().statusCode(200);
	
	}
	
		
	@Test(priority=2,dataProvider ="OnlyUsername", dataProviderClass = UserDataprovider.class)
	public void deleteUserDetail(String unm) {
		logger.info("*****Running delete user request in DDT**********");
		Response response = UserEndpoints.deleteUser(unm)	;
		response.then().log().body().and().statusCode(200);
	}

}
