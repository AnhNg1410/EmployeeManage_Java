package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginAction;
import model.EmployModel;
import model.Employee;
//import model.Log;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	
	private EmployModel employModel;
	private StartPanel startFramePanel;
	
	private String checkUserString;
	private String fileString;
	private Boolean checkLoginBoolean = false; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
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
	public LoginPanel() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener lac = new LoginAction(this);
		
		JLabel lblNewLabel = new JLabel("Employee Managerment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 372, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("Username\r\n");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(20, 80, 90, 25);
		contentPane.add(lblUser);
		
		textUser = new JTextField();
		textUser.setBounds(117, 81, 275, 25);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(20, 133, 90, 25);
		contentPane.add(lblPass);
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(117, 135, 275, 25);
		contentPane.add(textPass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(20, 194, 186, 27);
		btnLogin.addActionListener(lac);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(20, 261, 372, 27);
		btnRegister.addActionListener(lac);
		contentPane.add(btnRegister);
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.setBounds(279, 194, 113, 27);
		contentPane.add(btnForgetPassword);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public EmployModel getEmployModel() {
		return employModel;
	}

	public void setEmployModel(EmployModel employModel) {
		this.employModel = employModel;
	}

	public StartPanel getStartFramePanel() {
		return startFramePanel;
	}

	public void setStartFramePanel(StartPanel startFramePanel) {
		this.startFramePanel = startFramePanel;
	}
	
	public String getCheckUserString() {
		return checkUserString;
	}
	
	public void setFileString(String fileString) {
		this.fileString = fileString;
	}
	
	public String getFileString() {
		return this.fileString;
	}

	public void setCheckUserString(String checkUserString) {
		this.checkUserString = checkUserString;
	}

	public Boolean getCheckLoginBoolean() {
		return checkLoginBoolean;
	}

	public void setCheckLoginBoolean(Boolean checkLoginBoolean) {
		this.checkLoginBoolean = checkLoginBoolean;
	}

	public Boolean checkAccoutBoolean() {
		String usernameString = textUser.getText();
		String passwordString = textPass.getText();
		for (Employee employee : employModel.getEmployList()) {
			if(employee.getUsernameString()==null) { continue; }
			if(employee.getUsernameString().equals(usernameString)) {
				if(employee.getPasswordString().equals(passwordString)) {
					JOptionPane.showMessageDialog(this, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
					checkUserString = usernameString;
					return true;
				} else {
					JOptionPane.showMessageDialog(this, "Wrong Password", "Warning", JOptionPane.WARNING_MESSAGE);
					return false;
				} 
			}
		}
		JOptionPane.showMessageDialog(this, "Username is not exist", "Warning", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	
	public Boolean checkAccoutBooleanGeneralBoolean(ArrayList<Employee> employeeArrayList) {
		String usernameString = textUser.getText();
		String passwordString = textPass.getText();
		for (Employee employee : employeeArrayList) {
			if(employee.getUsernameString()==null) { continue; }
			if(employee.getUsernameString().equals(usernameString)) {
				if(employee.getPasswordString().equals(passwordString)) {
					JOptionPane.showMessageDialog(this, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
					checkUserString = usernameString;
					return true;
				} else {
					JOptionPane.showMessageDialog(this, "Wrong Password", "Warning", JOptionPane.WARNING_MESSAGE);
					return false;
				} 
			}
		}
		JOptionPane.showMessageDialog(this, "Username is not exist", "Warning", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	
	public void openTable() {
		if(!employModel.getEmployList().isEmpty()) {
			MainPanel mainPanel = new MainPanel();
			mainPanel.setCheckUserString(checkUserString);
			mainPanel.setEmpModel(employModel);
			mainPanel.setFileString(fileString);
			for (Employee employee : employModel.getEmployList()) {
				mainPanel.insertIntoTable(employee, mainPanel);
		}
	}
//		Log.write(checkUserString, "LOGIN", fileString);
		this.dispose();
	}
	
	public void closeStartFrame() {
		getStartFramePanel().dispose();	
	}
}
