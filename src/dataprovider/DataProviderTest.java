package dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider(name="data")
	public static Object [][] getData(Method name){
		 																	//[]------->Number of arguments to pass the value to			
		//Object[][] obj=new Object[3][2]; //[]------>No of times the arguments has to be passed 
		Object [][] obj=null;
		if(name.getName().equalsIgnoreCase("testCaseOne")){
			obj=new Object[2][2];
			obj[0][0]="String 1";                         
			obj[0][1]=123;
			
			obj[1][0]="String 2";
			obj[1][1]=321;
		}
		if(name.getName().equalsIgnoreCase("testCaseTwo")){
			obj=new Object[3][2];
			obj[0][0]="ABC";                         
			obj[0][1]=123;
			
			obj[1][0]="DEF";
			obj[1][1]=321;
					
			obj[2][0]="GHIJ 3";
			obj[2][1]=456;
		}
		if(name.getName().equalsIgnoreCase("testCaseThree")){
			obj=new Object[3][2];
			obj[0][0]="TestCase 3";                         
			obj[0][1]=123;
			
			obj[1][0]="TestCase 3";
			obj[1][1]=321;
					
			obj[2][0]="TestCase 3";
			obj[2][1]=456;
		}
		return obj;
	}
	
	@Test(dataProvider="data")
	public void testCaseOne(String a, Integer b){
		System.out.println("Argument :"+ a + "         Argument "+ b);
	}
	@Test(dataProvider="data")
	public void testCaseTwo(String a, Integer b){
		System.out.println("Argument :"+ a + "         Argument "+ b);
	}
}
