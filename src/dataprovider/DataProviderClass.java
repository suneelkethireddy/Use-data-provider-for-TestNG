package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="getLoginData")
	public static  Object[][] getLoginData() throws IOException{
		System.out.println("This is in new branch: branchA");
		return ReadFromExcelFile.getExcelData("Login.xlsx", "LoginDetails");
		
		
		
	}
	
}
