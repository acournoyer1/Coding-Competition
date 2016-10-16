import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	private JTextArea textArea;
	private JMenuItem importEmployees;
	private JMenuItem importStock;
	private JMenuItem exportStock;
	private JMenuItem exportEmployees;
	private JMenuItem viewEmployees;
	private JMenuItem viewStock;
	private JButton notificationButton;
	private JButton advanceTime;
	private Parser parser;
	private Stock stock;
	private Scheduler scheduler;
	
	public GUI()
	{
		scheduler = new Scheduler("Monday");
		parser = new Parser();
		stock = new Stock();
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		importEmployees = new JMenuItem("Employees");
		importStock = new JMenuItem("Stock");
		exportStock = new JMenuItem("Stock");
		exportEmployees = new JMenuItem("Employees");
		viewStock = new JMenuItem("Stock");
		viewEmployees = new JMenuItem("Employees");
		notificationButton = new JButton();
		advanceTime = new JButton("Advance Time");
		
		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu viewMenu = new JMenu("View");
		JMenu importMenu = new JMenu("Import");
		JMenu exportMenu = new JMenu("Export");
		
		menu.add(fileMenu);
		menu.add(viewMenu);
		fileMenu.add(importMenu);
		fileMenu.add(exportMenu);
		importMenu.add(importEmployees);
		importMenu.add(importStock);
		exportMenu.add(exportEmployees);
		exportMenu.add(exportStock);
		viewMenu.add(viewEmployees);
		viewMenu.add(viewStock);
		
		this.setSize(600, 400);
		
		JSplitPane pane = new JSplitPane();
		pane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		pane.setDividerSize(1);
		pane.setDividerLocation((int)(this.getHeight()*0.75));
		pane.setTopComponent(scrollPane);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(advanceTime);
		panel.add(notificationButton);
		notificationButton.setEnabled(false);
		pane.setBottomComponent(panel);
		
		pane.setEnabled(false);
		textArea.setEditable(false);
		
		this.setJMenuBar(menu);
		this.add(pane);
		
		this.setVisible(true);
	}
	
	private File saveFile(String title)
	{
		JFileChooser fileSaver = new JFileChooser();
		fileSaver.setDialogTitle(title);
		fileSaver.setDialogType(JFileChooser.SAVE_DIALOG);
		fileSaver.setFileFilter(new FileNameExtensionFilter("Comma Seperated Values (.csv)", "csv"));
		if (fileSaver.showSaveDialog(fileSaver) == JFileChooser.APPROVE_OPTION) { 
			return fileSaver.getSelectedFile();
		}
		else
		{
			return null;
		}
	}
	
	private File getFile(String title)
	{
		JFileChooser fileFinder = new JFileChooser();
		fileFinder.setDialogTitle(title);
		fileFinder.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileFinder.setDialogType(JFileChooser.OPEN_DIALOG);
		fileFinder.setFileFilter(new FileNameExtensionFilter("Microsoft Word Document(.docx)", "docx"));
		if (fileFinder.showOpenDialog(fileFinder) == JFileChooser.APPROVE_OPTION) { 
			return fileFinder.getSelectedFile();
		}
		else
		{
			return null;
		}
	}
	
	private void setUpButtons()
	{
		importEmployees.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = getFile("Import Employee");
				if(file == null) return;
				try {
					ArrayList<Employee> employees = parser.parseEmployees(file);
					employees.remove(0);
					scheduler.addEmployees(employees);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea.append(file.getName() + " has been imported to the employee list. \n");
			}
		});
		importStock.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = getFile("Import Stock");
				try {
					stock.addItem(parser.parseItems(file));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea.append(file.getName() + " has been imported to the stock. \n");
			}
		});
		exportEmployees.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = saveFile("Export Employees");
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(file == null) return;
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				for(Employee employee: scheduler.getEmployees())
				{
					try {
						fos.write((employee.toString() + "\n").getBytes());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				textArea.append(file.getName() + " has been exported. \n");
			}
		});
		exportStock.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = saveFile("Export Employees");
				if(file == null) return;
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file);
				} catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				for(Item i: stock.getItems())
				{
					try {
						fos.write((i.toString() + "\n").getBytes());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				textArea.append(file.getName() + " has been exported. \n");
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		viewStock.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				textArea.append("Current inventory: \n");
				for(Item i: stock.getItems())textArea.append(i.toString() + "\n");
			}
		});
		viewEmployees.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				textArea.append("Current inventory: \n");
				for(Employee employee: scheduler.getEmployees())textArea.append(employee.toString() + "\n");
			}
		});
	}
	
	public static void main(String args[])
	{
		GUI gui = new GUI();
		gui.setUpButtons();
	}
}
