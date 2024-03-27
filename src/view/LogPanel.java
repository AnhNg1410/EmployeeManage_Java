package view;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Log;
import model.LogList;

public class LogPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private LogList logList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogPanel frame = new LogPanel();
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
	public LogPanel() {
		setTitle("Log");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 484, 461);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Time", "User", "Content"
			}
		));
		scrollPane.setViewportView(table);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public LogList getLogList() {
		return logList;
	}

	public void setLogList(LogList logList) {
		this.logList = logList;
	}

	public void insertIntoTable(Log log) {
		DefaultTableModel dtb = (DefaultTableModel) table.getModel();
		dtb.addRow(new Object[] {
				log.getDayLogDate(), log.getTimeLogTime(), log.getEmployee(), log.getContextString(),
		});
	}
	
	public void openFile(String file) {
		ArrayList<Log> logListTmp = new ArrayList<Log>();
		try {
			logList.setFileString(file);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Log log = null;
			while((log = (Log) ois.readObject()) != null) {
				logListTmp.add(log);
			}
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		logList.setLogList(logListTmp);
	}
	
	public void openFromFile(String file) {
		openFile(file);
		for (Log log : logList.getLogList()) {
			insertIntoTable(log);
		}
	}
	
	public void saveFile(String file) {
		try {
			this.logList.setFileString(file);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Log log : this.logList.getLogList()) {
				oos.writeObject(log);
			}
			oos.flush(); oos.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	public void saveIntoFile(String file) {
		saveFile(file);
	}
}
