package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="getLoginData")
	public static  Object[][] getLoginData() throws IOException{
		return ReadFromExcelFile.getExcelData("Login.xlsx", "LoginDetails");
	}
	
}
