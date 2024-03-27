package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.MainAction;
import model.Address;
import model.Department;
import model.EmployModel;
import model.Employee;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class MainPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFind;
	
	private EmployModel empModel;
	private JComboBox<String> cbFindDepart;
	private JComboBox<String> cbFindAdd;
	
	private String radio = "Name";
	private Boolean checkAdd = false, checkDepart = false;
	private String checkUserString;
	private String fileString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel frame = new MainPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 990, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Employee Management");
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.empModel = new EmployModel();
		ActionListener ac = new MainAction(this);
		
		JPanel toolPanel = new JPanel();
		toolPanel.setBounds(9, 487, 336, 136);
		contentPane.add(toolPanel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		menuFile.add(mntmNew);
		mntmNew.addActionListener(ac);
		
		JMenuItem mntmOpen = new JMenuItem("Open Table");
		menuFile.add(mntmOpen);
		mntmOpen.addActionListener(ac);
		
		JMenuItem mntmSave = new JMenuItem("Save Table");
		menuFile.add(mntmSave);
		mntmSave.addActionListener(ac);
		
		JMenu menuTool = new JMenu("Tool");
		menuTool.setEnabled(false);
		menuTool.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuTool);
		
		JMenuItem mntmLog = new JMenuItem("Log");
		menuTool.add(mntmLog);
		mntmLog.addActionListener(ac);
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuHelp);
		
		JMenuItem mntmInfo = new JMenuItem("About Application");
		menuHelp.add(mntmInfo);
		mntmInfo.addActionListener(ac);
		
		JMenuItem mntmAboutMe = new JMenuItem("About Me");
		menuHelp.add(mntmAboutMe);
		mntmAboutMe.addActionListener(ac);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(9, 52, 955, 415);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(24);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Full Name", "Gender", "Address", "Phone nums", "Department", "Positon", "Salary"
			}
		));
		toolPanel.setLayout(null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2 ) {
					showEmp();
				}
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 5, 65, 33);
		toolPanel.add(btnAdd);
		btnAdd.addActionListener(ac);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(85, 5, 65, 33);
		toolPanel.add(btnDelete);
		btnDelete.addActionListener(ac);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(160, 5, 67, 33);
		toolPanel.add(btnUpdate);
		btnUpdate.addActionListener(ac);
		
		JLabel lblNewLabel = new JLabel("Employee Table");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 220, 31);
		contentPane.add(lblNewLabel);
		
		Panel findPanel = new Panel();
		findPanel.setBounds(611, 487, 353, 136);
		contentPane.add(findPanel);
		findPanel.setLayout(null);
		
		JLabel lblFind = new JLabel("Find");
		lblFind.setBounds(10, 4, 51, 24);
		findPanel.add(lblFind);
		lblFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFind = new JTextField();
		textFind.setBounds(10, 35, 217, 24);
		findPanel.add(textFind);
		textFind.setColumns(10);
		
		cbFindAdd = new JComboBox<String>();
		cbFindAdd.setBounds(10, 70, 217, 22);
		for(Address prov : Address.getProvList()) {
			cbFindAdd.addItem(prov.getProvinceName());
		}
		findPanel.add(cbFindAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(88, 7, 64, 23);
		findPanel.add(btnFind);
		btnFind.addActionListener(ac);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(162, 7, 65, 23);
		findPanel.add(btnCancel);
		btnCancel.addActionListener(ac);
		
		cbFindDepart = new JComboBox<String>();
		cbFindDepart.setBounds(10, 103, 217, 22);
		findPanel.add(cbFindDepart);
		for(Department depart : Department.getDepartmentsList()) {
			cbFindDepart.addItem(depart.getDepart());
		}
		
		JRadioButton rdbtnID = new JRadioButton("ID");
		rdbtnID.setBounds(258, 3, 89, 23);
		findPanel.add(rdbtnID);
		rdbtnID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				radio = "ID";
			}
		});
		
		JRadioButton rdbtnName = new JRadioButton("Name", true);
		rdbtnName.setBounds(258, 27, 89, 23);
		findPanel.add(rdbtnName);
		rdbtnName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				radio = "Name";
			}
		});
		
		JRadioButton rdbtnPosition = new JRadioButton("Position");
		rdbtnPosition.setBounds(258, 51, 89, 23);
		findPanel.add(rdbtnPosition);
		rdbtnPosition.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				radio = "Position";
			}
		});
		
		ButtonGroup btGroup = new ButtonGroup();
		btGroup.add(rdbtnPosition);
		btGroup.add(rdbtnName);
		btGroup.add(rdbtnID);
		
		JCheckBox chckbxAddFind = new JCheckBox("Address");
		chckbxAddFind.setBounds(233, 74, 97, 23);
		findPanel.add(chckbxAddFind);
		chckbxAddFind.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) { checkAdd = true; }
				else { checkAdd = false; }
			}
		});
		
		JCheckBox chckbxDepartFind = new JCheckBox("Department");
		chckbxDepartFind.setBounds(233, 106, 97, 23);
		findPanel.add(chckbxDepartFind);
		chckbxDepartFind.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int src = e.getStateChange();
				if(src == 1) checkDepart = true;
				else checkDepart = false;
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 478, 955, 2);
		contentPane.add(separator);
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	
	public EmployModel getEmpModel() {
		return empModel;
	}

	public void setEmpModel(EmployModel empModel) {
		this.empModel = empModel;
	}
	
	public String getCheckUserString() {
		return checkUserString;
	}

	public void setCheckUserString(String checkUserString) {
		this.checkUserString = checkUserString;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}

	public void insertIntoTable(Employee emp, MainPanel mainPanel) {
		DefaultTableModel dtb = (DefaultTableModel) mainPanel.table.getModel();
		dtb.addRow(new Object[] {
				emp.getID(), emp.getName(), emp.getNameGender(emp.getGender()), emp.getAddress().getProvinceName(),
				emp.getPhones(), emp.getDepart().getDepart(), emp.getPosit(), emp.getSalary()
		});
	}
	
	public void deleteFromTable() {
		DefaultTableModel dtb = (DefaultTableModel) table.getModel();
		dtb.removeRow(table.getSelectedRow());
	}
	  
	public void updateIntoTable(Employee employee) {
		DefaultTableModel dtb = (DefaultTableModel) table.getModel();
		dtb.setValueAt(employee.getName(), table.getSelectedRow(), 1);
		dtb.setValueAt(employee.getNameGender(employee.getGender()), table.getSelectedRow(), 2);
		dtb.setValueAt(employee.getAddress().getProvinceName(), table.getSelectedRow(), 3);
		dtb.setValueAt(employee.getPhones(), table.getSelectedRow(), 4);
		dtb.setValueAt(employee.getDepart().getDepart(), table.getSelectedRow(), 5);
		dtb.setValueAt(employee.getPosit(), table.getSelectedRow(), 6);
		dtb.setValueAt(employee.getSalary(), table.getSelectedRow(), 7);
	}

	public void clearTable() {
		DefaultTableModel dtb = (DefaultTableModel) table.getModel();
		for(int i=0; i<dtb.getRowCount();) {
			dtb.removeRow(i);
		}
	}
	
	public Employee choseEmpfromTable() {
		DefaultTableModel dtb = (DefaultTableModel) this.table.getModel();
		try {
			String id = dtb.getValueAt(table.getSelectedRow(), 0) + "";
			return empModel.getEmpByID(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Choice a row fisrt", "Warning", JOptionPane.WARNING_MESSAGE);
//			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void openAdd() {
		Main_addPanel mainAddPanel = new Main_addPanel();
		mainAddPanel.setMainPanel(this);
		mainAddPanel.setEmployModel(empModel);
	}

	public void deleteEmp() {
		Employee emp = choseEmpfromTable();
		if(emp == null) return;
		int check = JOptionPane.showConfirmDialog(this, "Do you really want remove this row", "Delete Row", JOptionPane.YES_NO_OPTION);
		if(check == JOptionPane.YES_OPTION) {
			empModel.RemoveEmp(emp);
			deleteFromTable();
		}
	}

	public void updateEmp() {
		Employee emp = choseEmpfromTable();
		if(emp == null) return;
		Main_updatePanel mainUpdatePanel = new Main_updatePanel();
		mainUpdatePanel.setMainPanel(this);
		mainUpdatePanel.setEmployModel(empModel);
		mainUpdatePanel.setEmployee(emp);
		mainUpdatePanel.ImportInfor();
	}
	
	public void showEmp() {
		Main_ShowPanel show = new Main_ShowPanel();
		show.setEmployee(choseEmpfromTable());
		show.ImportInfor();
	}
	
	public File choseFile(String type) {
		JFileChooser fc = new JFileChooser();
		int rVal = 0;
		if(type.equals("Open")) {
			rVal = fc.showOpenDialog(this);
		} else if(type.equals("Save")) {
			rVal = fc.showSaveDialog(this);
		}
		if(rVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			return file;
		}
			return null;
	}
	
	public EmployModel openFileEmployeeReturned(File file) {
		try {
			file.exists();
			ArrayList<Employee> empList = new ArrayList<Employee>();
			try {
				this.empModel.setFileName(file.getAbsolutePath());
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Employee employee = null;
				while((employee = (Employee) ois.readObject()) != null) {
					empList.add(employee);
				}
				ois.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return new EmployModel(empList, file.getAbsolutePath());
		} catch (Exception e1) {
			e1.getMessage();
		}
		return null;
	}
	
	public void openFile(File file) {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			this.empModel.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee employee = null;
			while((employee = (Employee) ois.readObject()) != null) {
				empList.add(employee);
			}
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.empModel.setEmployList(empList);
	}
	
	public void openFileOpen(File file, MainPanel mainPanel) {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try {
			mainPanel.empModel.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee employee = null;
			while((employee = (Employee) ois.readObject()) != null) {
				empList.add(employee);
			}
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		mainPanel.empModel.setEmployList(empList);
	}
	
	public void openFromFile() {
		File fileOpenFromFile = choseFile("Open");
		if(checkUserString != null) {
			MainPanel mainPanelOpenMainPanel = new MainPanel();
			mainPanelOpenMainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			openFileOpen(fileOpenFromFile, mainPanelOpenMainPanel);
			for (Employee employee : mainPanelOpenMainPanel.getEmpModel().getEmployList()) {
				insertIntoTable(employee, mainPanelOpenMainPanel);
			}
		} else {
			if(openFileEmployeeReturned(fileOpenFromFile) != null) {
				LoginPanel loginPanel = new LoginPanel();
				loginPanel.setEmployModel(openFileEmployeeReturned(fileOpenFromFile));
				loginPanel.setCheckLoginBoolean(true);
			}
		}
	}
	
	public void saveFile(File file) {
		try {
			this.empModel.setFileName(file.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Employee emp : this.empModel.getEmployList()) {
				oos.writeObject(emp);
			}
			oos.flush(); oos.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	public void saveIntoFile() {
		File file = choseFile("Save");
		saveFile(file);
	}

	public void about(String type) {
		if(type.equals("Me")) {
			JOptionPane.showMessageDialog(this, "AnhNg1410\nfacebook.com/anhng1410", "About Me", JOptionPane.PLAIN_MESSAGE);
		} else if(type.equals("App")) {
			JOptionPane.showMessageDialog(this, "Employee Management ver0.0.1", "About Application", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public ArrayList<Employee> findByOption(String option) {
		ArrayList<Employee> empFindList = new ArrayList<Employee>();
		String text = textFind.getText();
		if(text.equals("")) {
			empFindList = empModel.getEmployList();
		} else {
			if(option.equals("ID")) {
				for (Employee employee : empModel.getEmployList()) {
					if(employee.getID().equals(text)) {
						empFindList.add(employee);
					}
				}
				return empFindList;
			} else if(option.equals("Name")) {
				for (Employee employee : empModel.getEmployList()) {
					if(employee.getName().equals(text)) {
						empFindList.add(employee);
					}
				}
				return empFindList;
			} else if(option.equals("Position")) {
				for (Employee employee : empModel.getEmployList()) {
				System.out.println(employee.getPosit());
					if(employee.getPosit().equals(text)) {
						empFindList.add(employee);
					}
				}
				return empFindList;
			}
		}
		return empFindList;
	}
	
	public ArrayList<Employee> findByCheckBox() {
		ArrayList<Employee> empFindList = findByOption(radio);
		ArrayList<Employee> empAddList = new ArrayList<Employee>();
		ArrayList<Employee> empDeprtList = new ArrayList<Employee>();
		if(checkAdd == true && checkDepart == true) {
			int add = cbFindAdd.getSelectedIndex(); 
			for (int i=0; i<empFindList.size(); i++) {
				if(empFindList.get(i).getAddress().getProvinceCode() == add) {
					empAddList.add(empFindList.get(i));
				}
			}
			int depart = cbFindDepart.getSelectedIndex()+1;
			for (int i=0; i<empAddList.size(); i++) {
				if(empFindList.get(i).getDepart().getID() == depart) {
					empDeprtList.add(empAddList.get(i));
				}
			}
			return empDeprtList;
		} else if(checkAdd == false && checkDepart == false) {
			return empFindList;
		} else if(checkAdd == true && checkDepart == false){
			int add = cbFindAdd.getSelectedIndex(); 
			for (int i=0; i<empFindList.size(); i++) {
				if(empFindList.get(i).getAddress().getProvinceCode() == add) {
					empAddList.add(empFindList.get(i));
				}
			}
			return empAddList;
		} else if(checkAdd == false && checkDepart == true) {
			int depart = cbFindDepart.getSelectedIndex()+1;
			for (int i=0; i<empFindList.size(); i++) {
				if(empFindList.get(i).getDepart().getID() == depart) {
					empDeprtList.add(empFindList.get(i));
				}
			}
			return empDeprtList;
		}
		return null;
	}
	
	public void find() {
		clearTable();
		ArrayList<Employee> empFindList = findByCheckBox(); 
		for (Employee employee : empFindList) {
			insertIntoTable(employee, this);
		}
	}

	public void cancelFind() {
		clearTable();
		for (Employee employee : empModel.getEmployList()) {
			insertIntoTable(employee, this);
		}
	}
	
	public void exchange(Employee emp1, Employee emp2) {
		
	}

}
