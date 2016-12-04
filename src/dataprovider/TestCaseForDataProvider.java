package dataprovider;

import java.util.Map;

import org.testng.annotations.Test;


public class TestCaseForDataProvider {

	@Test(dataProvider="getLoginData",dataProviderClass=DataProviderClass.class)
	public void testcase(Map<String ,Object>data){
		System.out.println("UserName   :"+data.get("UserName")+  " Password    :   "+data.get("Password"));
	}
}
