package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Main_AddAction;
import model.Address;
import model.Department;
import model.EmployModel;
import model.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Main_addPanel extends JFrame {

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
	private JLabel lblBaseSal;
	private JTextField textBaseSal;
	private JLabel lblSalRate;
	private JTextField textRate;
	private JRadioButton rdbtnMen;
	private JRadioButton rdbtnWomen;
	private JLabel lblSeniority;
	private JTextField textSenio;
	private JTextField textSalary;
	private JLabel lblSalary;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_addPanel frame = new Main_addPanel();
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
	public Main_addPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add Employee");
		
		setBounds(100, 100, 580, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener ac = new Main_AddAction(this);
		
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
		cbDepart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textRate.setText(Department.getDepartbyID(cbDepart.getSelectedIndex()).getSalaryRate() + "");		
			}
		});	
		
		lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPosition.setBounds(10, 206, 109, 28);
		contentPane.add(lblPosition);
		
		textPosit = new JTextField();
		textPosit.setColumns(10);
		textPosit.setBounds(129, 209, 206, 25);
		contentPane.add(textPosit);
		
		lblBaseSal = new JLabel("Base Salary");
		lblBaseSal.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBaseSal.setBounds(10, 267, 109, 28);
		contentPane.add(lblBaseSal);
		
		textBaseSal = new JTextField();
		textBaseSal.setColumns(10);
		textBaseSal.setBounds(129, 270, 206, 25);
		contentPane.add(textBaseSal);
		
		lblSalRate = new JLabel("Salary Rate");
		lblSalRate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSalRate.setBounds(10, 306, 109, 28);
		contentPane.add(lblSalRate);
		
		textRate = new JTextField();
		textRate.setEditable(false);
		textRate.setColumns(10);
		textRate.setBounds(129, 309, 206, 25);
		textRate.setText(Department.getDepartbyID(this.cbDepart.getSelectedIndex()).getSalaryRate() + "");
		contentPane.add(textRate);
		
		lblSeniority = new JLabel("Seniority");
		lblSeniority.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeniority.setBounds(10, 345, 109, 28);
		contentPane.add(lblSeniority);
		
		textSenio = new JTextField();
		textSenio.setColumns(10);
		textSenio.setBounds(129, 348, 206, 25);
		contentPane.add(textSenio);
		
		textSalary = new JTextField();
		textSalary.setEditable(false);
		textSalary.setColumns(10);
		textSalary.setBounds(129, 387, 206, 25);
		contentPane.add(textSalary);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSalary.setBounds(10, 384, 109, 28);
		contentPane.add(lblSalary);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(365, 11, 189, 160);
		contentPane.add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 254, 325, 2);
		contentPane.add(separator);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(465, 346, 89, 27);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(ac);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClear.setBounds(465, 387, 89, 27);
		contentPane.add(btnClear);
		btnClear.addActionListener(ac);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(345, 387, 76, 27);
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(ac);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
			double baseSal = Double.valueOf(this.textBaseSal.getText());
			double seniority = Double.valueOf(this.textSenio.getText());			
			Employee employee = new Employee(name, phones, gender, address, birth, posit, depart, seniority, baseSal);
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
		}
		return null;
	}
	
	public void Insert(Employee emp) {
		try {
			getEmployModel().InsertEmp(emp);
			mainPanel.insertIntoTable(emp, mainPanel);
		} catch (Exception e) {
			
		}
	}

	public void ClearForm() {
		this.textName.setText("");
		this.textBirth.setText("");
		this.textPosit.setText("");
		this.textPhone.setText("");
		this.textRate.setText("");
		this.textSalary.setText("");
		this.textSenio.setText("");
		this.rdbtnMen.setSelected(false);
		this.rdbtnWomen.setSelected(false);
		this.cbAdd.setSelectedIndex(0);
		this.cbDepart.setSelectedIndex(0);
		this.textRate.setText("");
	}

	public void Calculate() {
		double salary;
		try {
			salary = Double.valueOf(textBaseSal.getText()) * Double.valueOf(textRate.getText()) * (1+Double.valueOf(textSenio.getText())/100.0);
			this.textSalary.setText(salary + "");
		} catch (Exception e) {
			if(e.getMessage().equals("empty String")) {
				JOptionPane.showMessageDialog(this, "Some field lack of information", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Base salary and Seniority must be a number", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
