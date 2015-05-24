import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class button_Connect extends SListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Main.mode==0){
		if (((JRadioButton) Main.MainWindow.get("ChooseServer")).isSelected()){
				startServer();
				Main.mode = 1;
				((JTextField) Main.MainWindow.get("Nickname")).setText("Server");
		}
		else{
			startClient();
			Main.mode = 2;
		}
		((JRadioButton) Main.MainWindow.get("ChooseServer")).setEnabled(false);
		((JRadioButton) Main.MainWindow.get("ChooseClient")).setEnabled(false);
		((JTextField) Main.MainWindow.get("Address")).setEnabled(false);
		((JTextField) Main.MainWindow.get("Nickname")).setEnabled(false);
		((JButton)Main.MainWindow.get("Connect")).setText("Disconnect");
		}
		else
		{
			System.exit(0);
		}
			
	}
	public void startServer(){
		try {
			Main.server = new Server();
		} catch (IOException e) {System.out.println("Jora");}
		Main.server.Run();
	}
	public void startClient(){
		try {
			Main.client = new Client(((JTextField) Main.MainWindow.get("Address")).getText(),3128);
		} catch (IOException e) {}
		Main.client.Run();
	}
}
