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
	
	/**
	 * 
	 * @param file		the employee file
	 * @return			arrayList with all employees
	 * @throws IOException	if file cannot be opened for any reason
	 */
	public ArrayList<Employee> parseEmployees(File file) throws IOException {
		ArrayList<Employee> employees = new ArrayList<>();
		FileInputStream fis = new FileInputStream(file);
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
       

	/**
	 * 
	 * @param file	the stock list file
	 * @return		arrayList of items
	 * @throws IOException	if file cannot be opened for any reason
	 */
	public ArrayList<Item> parseItems(File file) throws IOException{
		ArrayList<Item> items = new ArrayList<>();
		FileInputStream fis = new FileInputStream(file);
		int x = 0;
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
                    		   tempQuantity = Integer.parseInt(cell.getText().replaceAll("[^0-9]",""));
                    	   }
                   
                	   }
                	   n++;
            	   }
                   if(x > 0) {
                        int i;
                        for(i = 0; i < tempDate.length(); i++) {
                        	if(tempDate.charAt(i) == ' ') {
                        		break;
                        	}
                        }
                        String xmonth= tempDate.substring(i);
                        String month = tempDate.substring(0, 3);
                        tempDate = month + xmonth;

                        
                    items.add(new Item(tempName,tempDate , tempQuantity));
                    
                   }
                   x++;
               
                   
               }
		   }
		   return items;
           }

}

