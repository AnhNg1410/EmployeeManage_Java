package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.StartAction;
import model.EmployModel;
import model.Employee;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class StartPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployModel empModel;
	private JPanel contentPane;
	
	private String fileString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPanel frame = new StartPanel();
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
	public StartPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		setTitle("EmployeeManagement");
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.empModel = new EmployModel();
		
		ActionListener sac = new StartAction(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setForeground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuFile);
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(menuHelp);
		
		JMenuItem mntmInfo = new JMenuItem("About Application");
		menuHelp.add(mntmInfo);
		mntmInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(contentPane, "Employee Management ver0.0.1", "About Application", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JMenuItem mntmAboutMe = new JMenuItem("About Me");
		menuHelp.add(mntmAboutMe);
		mntmAboutMe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(contentPane, "AnhNg1410\nfacebook.com/anhng1410", "About Me", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Employee management");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 29));
		lblNewLabel.setBounds(62, 11, 362, 88);
		contentPane.add(lblNewLabel);
		
		JButton btnNew = new JButton("New");
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNew.setBounds(90, 127, 89, 49);
		contentPane.add(btnNew);
		btnNew.addActionListener(sac);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnOpen.setBounds(271, 127, 89, 49);
		contentPane.add(btnOpen);
		btnOpen.addActionListener(sac);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public EmployModel getEmpModel() {
		return empModel;
	}

	public void setEmpModel(EmployModel empModel) {
		this.empModel = empModel;
	}

	public String getFileString() {
		return fileString;
	}
	public void setFileString(String fileString) {
		this.fileString = fileString;
	}
	public void openFromFile() {
		ArrayList<Employee> empList= new ArrayList<Employee>();
		JFileChooser fc = new JFileChooser();
		int rVal = fc.showOpenDialog(this);
		if(rVal == JFileChooser.APPROVE_OPTION) {
			try {
				empModel.setFileName(fc.getSelectedFile().getAbsolutePath());
				fileString = fc.getSelectedFile().getAbsolutePath();
				FileInputStream fis = new FileInputStream(fc.getSelectedFile());
				ObjectInputStream ois = new ObjectInputStream(fis);
				Employee emp = null;
				while((emp = (Employee) ois.readObject()) != null) {
					empList.add(emp);
				}
				ois.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		empModel.setEmployList(empList);
	}
	
	public void Open() {
		openFromFile();
		if(!empModel.getEmployList().isEmpty()) {
			LoginPanel loginPanel = new LoginPanel();
			loginPanel.setEmployModel(empModel);
			loginPanel.setStartFramePanel(this);
			loginPanel.setFileString(fileString);
		}
	}
}
