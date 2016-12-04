package dataprovider;

import org.testng.annotations.Test;

public class TestData {
	/*
	 * Using the same dataprovider across various classes
	 * In such a=cases we have to give the class name of the data provider 
	 * in the arguments list as
	 * (dataProvider="data",dataProviderClass=dataproviderclassname.class)
	 */
	@Test(dataProvider="data",dataProviderClass=DataProviderTest.class)
	public void testCaseThree(String a, Integer b){
		System.out.println("Argument :"+ a + "         Argument "+ b);
	}

}
