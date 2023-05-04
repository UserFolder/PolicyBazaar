package testClassUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData {
	
	public static String fromExcelSheet(int row,int cell) throws EncryptedDocumentException, IOException {
		
		String data="";
		
		String path = "C:"+File.separator+"Users"+File.separator+"Rajat Dhawade"+File.separator+"eclipse-workspace"+File.separator+"Bazaar"+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"PolicyBazaar.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		Sheet s=WorkbookFactory.create(file).getSheet("sheet1");
		
		Cell c = s.getRow(row).getCell(cell);
		CellType type = c.getCellType();
		
		if(type==CellType.STRING) {
			data=c.getStringCellValue();
		}
		else if(type==CellType.NUMERIC) {
			double d=c.getNumericCellValue();
	        data = String.valueOf(d);	
		}
		else if(type==CellType.BLANK){
			data=c.getStringCellValue();
		}
		
		return data;
	}

}
