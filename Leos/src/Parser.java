import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Parser {
	
	public Parser(){}
	
	public void parse() throws IOException{
		
		FileInputStream fis = new FileInputStream("/home/dan/workspace/Coding-Competition/Programming Food List (1).docx");
		
		XWPFDocument doc = new XWPFDocument(fis);
		List<XWPFTable> tables = doc.getTables();
		   for ( XWPFTable table : tables )
           {
               for ( XWPFTableRow row : table.getRows() )
               {
                   for ( XWPFTableCell cell : row.getTableCells() )
                   {
                       System.out.print(cell.getText());
                       System.out.print("\t");
                   }
                   System.out.println("");
               }
           }
	}
	
	public static void main(String args[]) throws IOException{
		Parser p =new Parser();
		p.parse();
	}
	}

