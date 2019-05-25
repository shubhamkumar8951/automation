package com.frameworkTest01.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class propertiesClass {

	static Properties properties = new Properties();

	public static Properties readPropertyFile(String fileName) throws IOException {
		File file = new File("data\\" + fileName + ".properties");
		FileInputStream fs = new FileInputStream(file);
		properties.load(fs);
		fs.close();
		return properties;
	}

	public String readExcelFile(int rowIndex,String columnName) throws IOException {
		String valueofCell = null;
		File file = new File("data\\datasheet.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row HeaderRow = sheet.getRow(0);

		for (int i = rowIndex; i < rowIndex+1; i++) {
			Row currentRow = sheet.getRow(i);
			HashMap<String, String> exceldata = new HashMap<String, String>();

			for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
				Cell Currentcell = currentRow.getCell(j);

				switch (Currentcell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.println(columnName + " columnName");
					System.out.println(HeaderRow.getCell(j).getStringCellValue() + " cell value");
					if(columnName.equalsIgnoreCase(HeaderRow.getCell(j).getStringCellValue())){
					exceldata.put(columnName, Currentcell.getStringCellValue());
					if(exceldata.containsKey(columnName)){
						valueofCell = exceldata.get(columnName);
						System.out.println(valueofCell + " valueofCell");
					}
					}
					else{
						System.out.println("null :- Value not found");
					}
					break;
				}
			}
		}
		
		fs.close();
		System.out.println(valueofCell + " filtered excel value");	
		return valueofCell;
		
	}
	
	public List<String> readTextFile(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		String strLine = "";
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while(strLine!=null) {
				strLine = br.readLine();
				sb.append(strLine);
                sb.append(System.lineSeparator());
                if (strLine==null)
                   break;
                list.add(strLine);
			}br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
