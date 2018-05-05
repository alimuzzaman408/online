package utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	private static FileInputStream ExcelFile;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	private static XSSFRow SheetRow;
	private static FileOutputStream Fileout; 
	public static String GetCellData(File Path,String SheetName,int rowNum,int colNum) throws Exception{
		ExcelFile=new FileInputStream(Path);
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
		Cell=ExcelWSheet.getRow(rowNum).getCell(colNum);
		String CellData=Cell.getStringCellValue();
		ExcelWBook.close();
		ExcelFile.close();
		return CellData;
	}

	public static void SetCellData(File Path,String SheetName,int rowNum,int colNum,String result) throws Exception{
		ExcelFile=new FileInputStream(Path);
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		ExcelWSheet=ExcelWBook.getSheet(SheetName);	
		//Retrieve the row and check for Null
		SheetRow=ExcelWSheet.getRow(rowNum);
		if(SheetRow==null){
			SheetRow=ExcelWSheet.createRow(rowNum);
		}
		//Update the value of the cell
		Cell=SheetRow.getCell(colNum);
		if(Cell==null){
			Cell=SheetRow.createCell(colNum);
		}

		Cell.setCellValue(result);
		Fileout=new FileOutputStream(Path);
		ExcelWBook.write(Fileout);
		Fileout.flush();
		Fileout.close();
	}
}


