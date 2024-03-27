package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.RegisterPanel;

public class RegisterAction implements ActionListener {
	private RegisterPanel registerPanel;

	public RegisterAction(RegisterPanel registerPanel) {
		this.registerPanel = registerPanel;
	}

	public RegisterPanel getMainAdd() {
		return registerPanel;
	}

	public void setRegisterPanel(RegisterPanel registerPanel) {
		this.registerPanel = registerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Register")) {
			registerPanel.Insert();
			registerPanel.saveIntoFile();
			registerPanel.mess();
		}else if (src.equals("Clear")) {
			registerPanel.ClearForm();
		}
	}
}
