import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Parser {
	
	
	public ArrayList<Employee> parseEmployee() throws IOException {
		ArrayList<Employee> employees = new ArrayList<>();
		FileInputStream fis = new FileInputStream("./Programming Employee List (1).docx");
		String tempName = "";
		String  tempDate = "";
		String test="";
		int n = -1;
		
		XWPFDocument doc = new XWPFDocument(fis);
		List<XWPFTable> tables = doc.getTables();
		   for ( XWPFTable table : tables ) {
               for ( XWPFTableRow row : table.getRows() ) { 
                   for ( XWPFTableCell cell : row.getTableCells()) {
                	   test = cell.getText();
                	   if(n >= 1) {
                		   if(n == 1) {
                    		   tempName = cell.getText();   	   
                    	   } else {
                    		   n = 0;
                    		   tempDate = cell.getText();
                    	   }
                   
                	   }
                	   n++;
            	   }
               employees.add(new Employee(tempName,tempDate));
                   
               }
		   }
		   return employees;
           }

	
	public ArrayList<Item> parseItems() throws IOException{
		ArrayList<Item> items = new ArrayList<>();
		FileInputStream fis = new FileInputStream("./Programming Food List (1).docx");
		String tempName = "";
		int tempQuantity = 0;
		String  tempDate = "";
		String test="";
		int n = -2;
		
		XWPFDocument doc = new XWPFDocument(fis);
		List<XWPFTable> tables = doc.getTables();
		   for ( XWPFTable table : tables ) {
               for ( XWPFTableRow row : table.getRows() ) { 
                   for ( XWPFTableCell cell : row.getTableCells()) {
                	   test = cell.getText();
                	   if(n >= 1) {
                		   if(n == 1) {
                    		   tempName = cell.getText();   
                    		   
                    	   } else if(n == 2) {
                    		   tempDate = cell.getText();
                    		   
                    	   } else {
                    		   n = 0;
                    		   tempQuantity = Integer.parseInt(cell.getText());
                    	   }
                   
                	   }
                	   n++;
            	   }
               items.add(new Item(tempName,tempDate , tempQuantity));
                   
               }
		   }
		   return items;
           }

}

