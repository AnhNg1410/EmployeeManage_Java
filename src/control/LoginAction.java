package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginPanel;
import view.RegisterPanel;

public class LoginAction implements ActionListener {
	private LoginAction loginAction;
	private LoginPanel loginPanel;
	
	public LoginAction(LoginPanel loginPanel) {
		this.setLoginPanel(loginPanel);
	}

	public LoginAction getLoginAction() {
		return loginAction;
	}

	public void setLoginAction(LoginAction loginAction) {
		this.loginAction = loginAction;
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Login") && !loginPanel.getCheckLoginBoolean()) {
			if(loginPanel.checkAccoutBoolean()) {
				loginPanel.openTable();
				loginPanel.closeStartFrame();
			}
		} else if (command.equals("Login") && loginPanel.getCheckLoginBoolean()) {
			if(loginPanel.checkAccoutBoolean()) {
				loginPanel.openTable();
			}
		} else if(command.equals("Forget Password")){

		} else if(command.equals("Register")){
			RegisterPanel registerPanel = new RegisterPanel();
			registerPanel.setEmployModel(loginPanel.getEmployModel());
		}
	}


}
