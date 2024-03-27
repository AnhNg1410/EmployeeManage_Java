package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EmployModel;
import view.MainPanel;
import view.StartPanel;

public class StartAction implements ActionListener{
	private StartPanel start;
	private EmployModel employModel = new EmployModel();

	public StartAction(StartPanel start) {
		this.start = start;
	}

	public EmployModel getEmployModel() {
		return employModel;
	}

	public void setEmployModel(EmployModel employModel) {
		this.employModel = employModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("New")) {
			new MainPanel();
			start.dispose();
		} else if(command.equals("Open")){
			start.Open();
		}
	}

}
