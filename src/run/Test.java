package run;

import javax.swing.UIManager;

import view.StartPanel;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StartPanel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}