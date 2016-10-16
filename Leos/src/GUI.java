import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
	
	public GUI()
	{ 
		textArea = new JTextArea();
		importEmployees = new JMenuItem("Employees");
		importStock = new JMenuItem("Stock");
		exportStock = new JMenuItem("Stock");
		exportEmployees = new JMenuItem("Employees");
		viewStock = new JMenuItem("Stock");
		viewEmployees = new JMenuItem("Employees");
		notificationButton = new JButton();
		
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
		System.out.println();
		pane.setDividerLocation((int)(this.getHeight()*0.75));
		pane.setTopComponent(textArea);
		pane.setBottomComponent(notificationButton);
		
		notificationButton.setSize(50, 50);
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
				textArea.append(file.getName() + " has been imported to the employee list. \n");
			}
		});
		importStock.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				File file = getFile("Import Stock");
				if(file == null) return;
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
				textArea.append(file.getName() + " has been exported. \n");
			}
		});
	}
	
	public static void main(String args[])
	{
		GUI gui = new GUI();
		gui.setUpButtons();
	}
}
