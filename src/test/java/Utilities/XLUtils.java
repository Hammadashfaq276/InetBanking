package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
	    return cellcount;
	}
	
	 public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
			fi=new FileInputStream(xlfile);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(xlsheet);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
				String data;
				try {
					data=formatter.formatCellValue(cell);
				}
				catch(Exception e)
				{
					data="";
				}
				workbook.close();
				fi.close();
				return data;
		}
	 
	 public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
		{
			File file=new File(xlfile);
			if(!file.exists())
			{
				workbook=new XSSFWorkbook();
				fo=new FileOutputStream(xlfile);
				workbook.write(fo);
			}
			fi=new FileInputStream(xlfile);
			workbook=new XSSFWorkbook(fi);
			
			if(workbook.getSheetIndex(xlsheet)==-1)
				workbook.createSheet(xlsheet);
			sheet=workbook.getSheet(xlsheet);
			
			if(sheet.getRow(rownum)==null)
				sheet.createRow(rownum);
			row=sheet.getRow(rownum);
			
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(xlfile);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
			
		}
	 
	 
}
