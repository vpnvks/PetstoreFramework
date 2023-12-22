package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {


	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell col;
	public static int rowcount;
	public static int cellcount;
	
	public static int getRowCount(String filepath, String sheetname) {
		try {
			fis = 	new FileInputStream(filepath);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet(sheetname);
			rowcount = ws.getLastRowNum();
			wb.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	public static int getCellCount(String filepath, String sheetname) {
		try {
			fis = 	new FileInputStream(filepath);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet(sheetname);
			row = ws.getRow(1);
			cellcount = row.getLastCellNum();
			wb.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cellcount;
	}
	
	public static String getcellval(String filepath, String sheetname,int i, int j) {
		XSSFCell val = null;
		String celldata = null;
		try {
			fis = 	new FileInputStream(filepath);
			wb = new XSSFWorkbook(fis);
			ws = wb.getSheet(sheetname);
			val = ws.getRow(i).getCell(j);
			
			
			DataFormatter ft = new DataFormatter();
			celldata = ft.formatCellValue(val);
			
			wb.close();
			fis.close();
			return celldata;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return celldata;
		}

}
