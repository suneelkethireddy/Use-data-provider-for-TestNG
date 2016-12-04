package dataprovider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadFromExcelFile {
/*
 * To read or write data from a excel file,we need the following jar files
 * poi-3.9.jar
 * poi-ooxml-3.5-beta5.jar
 * xmlbeans-2.6.0.jar
 * stax-api
 * commons-codec-1.9.jar
 * ooxml-schemas-1.1.jar
 * 
 */
	public static Object[][] getExcelData(String fileName,String sheetName) throws IOException{
		
		//File file=new File("F:\\Login.xlsx");  //Location of the file
		 //FileInputStream fis = new FileInputStream(file);//load file
		 XSSFWorkbook book = new XSSFWorkbook (ReadFromExcelFile.class.getClassLoader().getResourceAsStream("dataprovider/"+fileName));//load workbook
		XSSFSheet sheet=book.getSheet(sheetName);
		XSSFRow row=null;
		XSSFCell cel=null;
		Map<String,Object> map=null;
		
		//For getting the headers i.e at 0 row
		row=sheet.getRow(0);
		String[] header=new String[row.getLastCellNum()];
		Object[][] data=new Object[row.getLastCellNum()][1];
		for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++){
			cel=row.getCell(j);
			header[j]=cel.getStringCellValue();
		}
		for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
			row=sheet.getRow(i);
			map=new LinkedHashMap<String,Object>();
			for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++){
				cel=row.getCell(j);
				
				switch(cel.getCellType()){
				case XSSFCell.CELL_TYPE_STRING:
					map.put(header[j], cel.getStringCellValue());
					break;
					
				case XSSFCell.CELL_TYPE_NUMERIC:
					map.put(header[j], cel.getNumericCellValue());
					break;
				}
			}
			data[i-1] [0]=map;
		}
		
		return data;
	}

}
//Using mapping concepts to get the value from excel.
/*
Map<Integer,String> map=new LinkedHashMap<Integer,String>();
map.put(1, "ABC");
map.put(2, "DEF");
map.put(3, "CBA");
System.out.println("Size   : "+map.size());

map.put(3, "ABC");
System.out.println("size    :"+map.size());

System.out.println("Value   :"+map.get(3));*/
