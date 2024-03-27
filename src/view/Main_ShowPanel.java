package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Address;
import model.Department;
import model.Employee;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.TextArea;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class Main_ShowPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private Employee employee;
	
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
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_ShowPanel frame = new Main_ShowPanel();
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
	public Main_ShowPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Employee");
		
		setBounds(100, 100, 575, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFullName.setBounds(20, 50, 99, 28);
		contentPane.add(lblFullName);
		
		textName = new JTextField();
		textName.setDisabledTextColor(new Color(0, 0, 0));
		textName.setEnabled(false);
		textName.setEditable(false);
		textName.setBounds(129, 53, 185, 25);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAddress.setBounds(20, 129, 99, 28);
		contentPane.add(lblAddress);
		
		cbAdd = new JComboBox<String>();
		cbAdd.setEnabled(false);
		cbAdd.setBounds(129, 133, 185, 22);
		contentPane.add(cbAdd);
		for(Address prov : Address.getProvList()) {
			cbAdd.addItem(prov.getProvinceName());
		}
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGender.setBounds(20, 90, 99, 28);
		contentPane.add(lblGender);
		
		rdbtnMen = new JRadioButton("Men");
		rdbtnMen.setForeground(new Color(0, 0, 0));
		rdbtnMen.setEnabled(false);
		rdbtnMen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMen.setBounds(129, 95, 56, 23);
		contentPane.add(rdbtnMen);
		
		rdbtnWomen = new JRadioButton("Women");
		rdbtnWomen.setEnabled(false);
		rdbtnWomen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnWomen.setBounds(187, 95, 78, 23);
		contentPane.add(rdbtnWomen);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMen);
		buttonGroup.add(rdbtnWomen);
		
		lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBirthday.setBounds(20, 168, 99, 28);
		contentPane.add(lblBirthday);
		
		textBirth = new JTextField();
		textBirth.setDisabledTextColor(new Color(0, 0, 0));
		textBirth.setEnabled(false);
		textBirth.setEditable(false);
		textBirth.setToolTipText("Format: dd/mm/yyyy");
		textBirth.setColumns(10);
		textBirth.setBounds(129, 171, 185, 25);
		contentPane.add(textBirth);
		
		lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(20, 207, 99, 28);
		contentPane.add(lblPhoneNumber);
		
		textPhone = new JTextField();
		textPhone.setDisabledTextColor(new Color(0, 0, 0));
		textPhone.setEnabled(false);
		textPhone.setEditable(false);
		textPhone.setColumns(10);
		textPhone.setBounds(129, 210, 185, 25);
		contentPane.add(textPhone);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDepartment.setBounds(20, 246, 99, 28);
		contentPane.add(lblDepartment);
		
		cbDepart = new JComboBox<String>();
		cbDepart.setEnabled(false);
		cbDepart.setBounds(129, 250, 185, 22);
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
		lblPosition.setBounds(20, 285, 99, 28);
		contentPane.add(lblPosition);
		
		textPosit = new JTextField();
		textPosit.setDisabledTextColor(new Color(0, 0, 0));
		textPosit.setEnabled(false);
		textPosit.setEditable(false);
		textPosit.setColumns(10);
		textPosit.setBounds(129, 288, 185, 25);
		contentPane.add(textPosit);
		
		lblBaseSal = new JLabel("Base Salary");
		lblBaseSal.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBaseSal.setBounds(20, 351, 99, 28);
		contentPane.add(lblBaseSal);
		
		textBaseSal = new JTextField();
		textBaseSal.setDisabledTextColor(new Color(0, 0, 0));
		textBaseSal.setEnabled(false);
		textBaseSal.setEditable(false);
		textBaseSal.setColumns(10);
		textBaseSal.setBounds(130, 354, 184, 25);
		contentPane.add(textBaseSal);
		
		lblSalRate = new JLabel("Salary Rate");
		lblSalRate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSalRate.setBounds(20, 390, 99, 28);
		contentPane.add(lblSalRate);
		
		textRate = new JTextField();
		textRate.setDisabledTextColor(new Color(0, 0, 0));
		textRate.setEnabled(false);
		textRate.setEditable(false);
		textRate.setColumns(10);
		textRate.setBounds(130, 393, 184, 25);
		textRate.setText(Department.getDepartbyID(this.cbDepart.getSelectedIndex()).getSalaryRate() + "");
		contentPane.add(textRate);
		
		lblSeniority = new JLabel("Seniority");
		lblSeniority.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeniority.setBounds(20, 429, 99, 28);
		contentPane.add(lblSeniority);
		
		textSenio = new JTextField();
		textSenio.setDisabledTextColor(new Color(0, 0, 0));
		textSenio.setEnabled(false);
		textSenio.setEditable(false);
		textSenio.setColumns(10);
		textSenio.setBounds(130, 432, 184, 25);
		contentPane.add(textSenio);
		
		textSalary = new JTextField();
		textSalary.setDisabledTextColor(new Color(0, 0, 0));
		textSalary.setEnabled(false);
		textSalary.setEditable(false);
		textSalary.setColumns(10);
		textSalary.setBounds(130, 471, 184, 25);
		contentPane.add(textSalary);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSalary.setBounds(20, 468, 99, 28);
		contentPane.add(lblSalary);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(346, 14, 193, 181);
		contentPane.add(textArea);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblId.setBounds(20, 11, 99, 28);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setDisabledTextColor(new Color(0, 0, 0));
		textID.setEnabled(false);
		textID.setEditable(false);
		textID.setColumns(10);
		textID.setBounds(129, 14, 185, 25);
		contentPane.add(textID);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 330, 304, 2);
		contentPane.add(separator);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void ImportInfor() {
		this.textID.setText(employee.getID());
		this.textName.setText(getEmployee().getName());
		this.textBirth.setText(getEmployee().getBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		this.textPhone.setText(getEmployee().getPhones());
		this.textPosit.setText(getEmployee().getPosit());
		this.textRate.setText(getEmployee().getDepart().getSalaryRate() + "");
		this.textSalary.setText(getEmployee().getSalary() + "");
		this.textBaseSal.setText(getEmployee().getBaseSal() + "");
		this.textSenio.setText(getEmployee().getSeniority() + "");
		this.cbAdd.setSelectedIndex(getEmployee().getAddress().getProvinceCode());
		this.cbDepart.setSelectedIndex(getEmployee().getDepart().getID()-1);
		if(getEmployee().getGender()) {
			this.rdbtnMen.setSelected(true);
		} else {
			this.rdbtnWomen.setSelected(true);
		}
	}
}
