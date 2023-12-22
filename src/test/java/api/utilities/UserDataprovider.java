package api.utilities;

import org.testng.annotations.DataProvider;

public class UserDataprovider {
	
	
	
	@DataProvider(name="completeUserData")
	public String[][] getUserData(){
		
		String path = System.getProperty("user.dir")+"/testData/userDetail.xlsx";		
		int rowcount = XLUtils.getRowCount(path, "Details");
		int colcount = XLUtils.getCellCount(path, "Details");
		
		String[][] udetail = new String[rowcount][colcount];
				
		for(int i=1; i<=rowcount; i++) {
			for(int j=0; j<colcount;j++) {
				int k = i-1;	
				udetail[k][j] = XLUtils.getcellval(path, "Details", i, j)	;
				
			}
			
		}
		
		return udetail;
		
	}
	
	@DataProvider(name="OnlyUsername")
	public String[] getUserData1(){
		String path = System.getProperty("user.dir")+"/testData/userDetail.xlsx";		
		int rowcount = XLUtils.getRowCount(path, "Details");
				
		String[] udetail = new String[rowcount];
				
		for(int i=1; i<=rowcount; i++) {
				int k = i-1;			
				udetail[k] = XLUtils.getcellval(path, "Details", i, 1)	;
				
		}
		
		return udetail;
		
	}
}
