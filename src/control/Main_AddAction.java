package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Main_addPanel;

public class Main_AddAction implements ActionListener{
	private Main_addPanel mainAdd;

	public Main_AddAction(Main_addPanel mainAdd) {
		this.mainAdd = mainAdd;
	}

	public Main_addPanel getMainAdd() {
		return mainAdd;
	}

	public void setMainAdd(Main_addPanel mainAdd) {
		this.mainAdd = mainAdd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Add")) {
			mainAdd.Insert(mainAdd.GetInfor());
		}else if (src.equals("Clear")) {
			mainAdd.ClearForm();
		}else if (src.equals("Calculate")) {
			mainAdd.Calculate();
		}
	}
}
