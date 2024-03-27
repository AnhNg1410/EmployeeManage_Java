package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Main_updatePanel;

public class Main_UpdateAction implements ActionListener{
	private Main_updatePanel mainUpdate;

	public Main_UpdateAction(Main_updatePanel main_updatePanel) {
		this.mainUpdate = main_updatePanel;
	}

	public Main_updatePanel getMainAdd() {
		return mainUpdate;
	}

	public void setMainAdd(Main_updatePanel mainAdd) {
		this.mainUpdate = mainAdd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Update")) {
			mainUpdate.Update();;
		}else if (src.equals("Clear")) {
			mainUpdate.ClearForm();
		}else if (src.equals("Calculate")) {
			mainUpdate.Calculate();
		}
	}
}
