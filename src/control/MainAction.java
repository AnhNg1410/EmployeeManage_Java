package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import view.LogPanel;
import view.MainPanel;

public class MainAction implements ActionListener {
	private MainPanel main;
	
	public MainAction(MainPanel main) {
		this.main = main;
	}
	
	public MainPanel getMain() {
		return main;
	}

	public void setMain(MainPanel main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Add")) {
			main.openAdd();
		} else if(src.equals("Delete")) {
			main.deleteEmp();
		} else if(src.equals("Update")) {
			main.updateEmp();
		} else if (src.equals("Open Table")) {
			main.openFromFile();
		} else if (src.equals("Save Table")) {
			main.saveIntoFile();
		} else if (src.equals("About Me")) {
			main.about("Me");
		} else if (src.equals("About Application")) {
			main.about("App");
		} else if (src.equals("Find")) {
			main.find();
		} else if (src.equals("Cancel")) {
			main.cancelFind();
//		} else if (src.equals("Log")) {
//			LogPanel logPanel = new LogPanel();
//			logPanel.saveIntoFile(main.getFileString());
//			logPanel.openFromFile(main.getFileString());
		}
	}

}
