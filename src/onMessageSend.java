import java.awt.event.ActionEvent;

import javax.swing.JTextField;


public class onMessageSend extends SListener{
	String msgtext;
	STextPane ChatField;
	public onMessageSend(){
		ChatField = (STextPane) Main.MainWindow.get("ChatField");
	}
	public void actionPerformed(ActionEvent e) {
		msgtext = ((JTextField) Main.MainWindow.get("MessageField")).getText();
		((JTextField) Main.MainWindow.get("MessageField")).setText("");
		switch(Main.mode){
		case 1:ProcessMessageFromServer(); break;
		case 2:ProcessMessageFromClient(); break;
		}
	}

	private void ProcessMessageFromServer() {
		Main.server.sendtoAll(msgtext);
		ChatField.ownMsg("Server: "+msgtext);
	}

	private void ProcessMessageFromClient() {
		Main.client.send(msgtext);
		ChatField.ownMsg(Main.client.getNickname()+": "+msgtext);		
	}
}
