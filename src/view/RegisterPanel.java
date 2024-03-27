package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.RegisterAction;
import model.Address;
import model.Department;
import model.EmployModel;
import model.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.TextArea;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class RegisterPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private EmployModel employModel;
	private ArrayList<Employee> empList;
	
	private JPanel contentPane;
	private JTextField textName;
	private JLabel lblAddress;
	private JComboBox<String> cbAdd;
	private JLabel lblGender;
	private JLabel lblBirthday;
	private JTextField textBirth;
	private JLabel lblPhoneNumber;
	private JTextField textPhone;
	private JLabel lblDepartment;
	private JComboBox<String> cbDepart;
	private JLabel lblPosition;
	private JTextField textPosit;
	private JLabel lblUser;
	private JTextField textUser;
	private JRadioButton rdbtnMen;
	private JRadioButton rdbtnWomen;
	private JLabel lblPass;
	private JTextField textPass;
	private ButtonGroup buttonGroup;
	private JTextField textRePass;

	private String checkUserString = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPanel frame = new RegisterPanel();
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
	public RegisterPanel() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new RegisterAction(this);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFullName.setBounds(10, 11, 109, 28);
		contentPane.add(lblFullName);
		
		textName = new JTextField();
		textName.setBounds(129, 14, 206, 25);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAddress.setBounds(10, 50, 109, 28);
		contentPane.add(lblAddress);
		
		cbAdd = new JComboBox<String>();
		cbAdd.setBounds(129, 54, 206, 22);
		contentPane.add(cbAdd);
		for(Address prov : Address.getProvList()) {
			cbAdd.addItem(prov.getProvinceName());
		}
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGender.setBounds(365, 176, 109, 28);
		contentPane.add(lblGender);
		
		rdbtnMen = new JRadioButton("Men");
		rdbtnMen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMen.setBounds(365, 211, 56, 23);
		contentPane.add(rdbtnMen);
		
		rdbtnWomen = new JRadioButton("Women");
		rdbtnWomen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnWomen.setBounds(435, 211, 78, 23);
		contentPane.add(rdbtnWomen);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMen);
		buttonGroup.add(rdbtnWomen);
		
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBirthday.setBounds(10, 89, 109, 28);
		contentPane.add(lblBirthday);
		
		textBirth = new JTextField();
		textBirth.setToolTipText("Format: dd/mm/yyyy");
		textBirth.setColumns(10);
		textBirth.setBounds(129, 92, 206, 25);
		contentPane.add(textBirth);
		
		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(10, 128, 109, 28);
		contentPane.add(lblPhoneNumber);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(129, 131, 206, 25);
		contentPane.add(textPhone);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDepartment.setBounds(10, 167, 109, 28);
		contentPane.add(lblDepartment);
		
		cbDepart = new JComboBox<String>();
		cbDepart.setBounds(129, 171, 206, 22);
		contentPane.add(cbDepart);
		for(Department depart : Department.getDepartmentsList()) {
			cbDepart.addItem(depart.getDepart());
		}
		
		lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPosition.setBounds(10, 206, 109, 28);
		contentPane.add(lblPosition);
		
		textPosit = new JTextField();
		textPosit.setColumns(10);
		textPosit.setBounds(129, 209, 206, 25);
		contentPane.add(textPosit);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(365, 11, 189, 160);
		contentPane.add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 254, 325, 2);
		contentPane.add(separator);

		
		lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUser.setBounds(10, 267, 109, 28);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(129, 270, 206, 25);
		contentPane.add(textUser);
		
		lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPass.setBounds(10, 306, 109, 28);
		contentPane.add(lblPass);
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(129, 306, 206, 25);
		contentPane.add(textPass);
		
		textRePass = new JTextField();
		textRePass.setColumns(10);
		textRePass.setBounds(129, 342, 206, 25);
		contentPane.add(textRePass);
		
		JLabel lblRePass = new JLabel("Re - Password");
		lblRePass.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRePass.setBounds(10, 342, 109, 28);
		contentPane.add(lblRePass);

		JButton btnReg = new JButton("Register");
		btnReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReg.setBounds(365, 306, 189, 27);
		contentPane.add(btnReg);
		btnReg.addActionListener(ac);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBounds(365, 342, 189, 27);
		contentPane.add(btnClear);
		btnClear.addActionListener(ac);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public ArrayList<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(ArrayList<Employee> empList) {
		this.empList = empList;
	}
	
	public EmployModel getEmployModel() {
		return employModel;
	}

	public void setEmployModel(EmployModel employModel) {
		this.employModel = employModel;
	}

	public String getCheckUserString() {
		return checkUserString;
	}

	public void setCheckUserString(String checkUserString) {
		this.checkUserString = checkUserString;
	}

	public Employee GetInfor() {
		try {
			String name = this.textName.getText();
			if(name.equals("")) {
				JOptionPane.showMessageDialog(this, "Full name must be different empty", "Warning", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			Address address = new Address(Address.getTinhbyID(this.cbAdd.getSelectedIndex()).getProvinceName(), this.cbAdd.getSelectedIndex());
			LocalDate birth = LocalDate.parse(Employee.setFormatDate(this.textBirth.getText()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			boolean gender = true;
			if(rdbtnMen.isSelected()) { gender = true; } else if(rdbtnWomen.isSelected()) { gender = false; }
			else {
				JOptionPane.showMessageDialog(this, "Gender must be different empty", "Warning", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			String phones = this.textPhone.getText();
			Department depart = new Department(Department.getDepartbyID(this.cbDepart.getSelectedIndex()).getDepart(),
					Department.getDepartbyID(this.cbDepart.getSelectedIndex()).getDepartCode(),
					Department.getDepartbyID(this.cbDepart.getSelectedIndex()).getID(),
					Department.getDepartbyID(this.cbDepart.getSelectedIndex()).getSalaryRate());
			String posit = this.textPosit.getText();
			String usernameString = this.textUser.getText();
			if(diffUserCheck(usernameString) == false) {
				JOptionPane.showMessageDialog(this, "Username is exist", "Warning", JOptionPane.WARNING_MESSAGE);
				return null;
			}
            String passwordString = this.textPass.getText();
			String rePasswordString = this.textRePass.getText();
			if(!passwordString.equals(rePasswordString)) {
				JOptionPane.showMessageDialog(this, "Password and RePassword must not be different other", "Warning", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			Employee employee = new Employee(name, phones, gender, address, birth, posit, depart, 0, 0);
			employee.setUsernameString(usernameString);
			employee.setPasswordString(passwordString);
			checkUserString = usernameString;
			return employee;
		} catch (Exception e) {
			if(e.getMessage().contains("could not be parsed at index")) {
				JOptionPane.showMessageDialog(this, "Bithday format : dd/mm/yyyy or dd-mm-yyyy", "Warning", JOptionPane.WARNING_MESSAGE);
			} 
			if(e.getMessage().equals("empty String")) {
				JOptionPane.showMessageDialog(this, "Some field lack of information", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			if(e.getMessage().contains("For input string")) {
				JOptionPane.showMessageDialog(this, "Base salary and Seniority must be a number", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			e.getMessage();
		}
		return null;
	}
	
	public void checkkkk() {
		for (Employee employee : empList) {
			System.out.println(employee.toString());
		}
	}
	
	public boolean diffUserCheck(String usernameString) {
		if(empList == null) {
			return true;
		} else {
			for (Employee employee : empList) {
				if(!usernameString.equals(employee.getUsernameString())) {
					return true;
				}
			}
			return false;
		}
	}
	
	public void Insert() {
		Employee emp = this.GetInfor();
		try {
			getEmployModel().InsertEmp(emp);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void saveFile(File file) {
		try {
			this.employModel.setFileName(file.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Employee emp : this.employModel.getEmployList()) {
				oos.writeObject(emp);
			}
			oos.flush(); oos.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void saveFileString(String file) {
		try {
			this.employModel.setFileName(file);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Employee emp : this.employModel.getEmployList()) {
				oos.writeObject(emp);
			}
			oos.flush(); oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveIntoFile() {
		String file = employModel.getFileName();
		saveFileString(file);
	}

	public void ClearForm() {
		this.textName.setText("");
		this.textBirth.setText("");
		this.textPosit.setText("");
		this.textPhone.setText("");
		this.textPass.setText("");
		this.rdbtnMen.setSelected(false);
		this.rdbtnWomen.setSelected(false);
		this.cbAdd.setSelectedIndex(0);
		this.cbDepart.setSelectedIndex(0);
		this.textUser.setText("");
		this.textPass.setText("");
		this.textRePass.setText("");
	}
	
	public void mess() {
		if(GetInfor() != null) {
			JOptionPane.showMessageDialog(this, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}
}
