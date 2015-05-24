import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Main {
	public static Client client;
	public static Server server;
	public static Scanner systemIn;
	public static SWindow MainWindow;
	public static int mode;
	public static void main(String args[]) throws IOException{
		MainWindow = new SWindow("II-Chat-II");
		mode = 0;
		createInterface();		
		MainWindow.showWindow();
	}
	public static void createInterface(){
		try {
		      UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
    	MainWindow.add("MainTitle",new JLabel("Please select the mode..."),0,0,4,1,"BOTH");
    	MainWindow.add("ChooseServer",new JRadioButton("Server"),2,0,1,1,"BOTH",1);
    	MainWindow.add("ChooseClient",new JRadioButton("Client",true),2,1,1,1,"BOTH",1);
    	MainWindow.add("AdressTitle",new JLabel("Address to connect:"),3,0,1,1,"BOTH");
    	MainWindow.add("Address",new JTextField("localhost"),3,1,3,1,"BOTH");
    	MainWindow.add("NickTitle",new JLabel("Nickname:"),4,0,1,1,"BOTH");
    	MainWindow.add("Nickname",new JTextField(System.getProperty("user.name")),4,1,3,1,"BOTH");
    	MainWindow.add("Connect",new JButton("Connect"),5,0,4,1,"BOTH");
    	(new button_Connect()).addButton(MainWindow.get("Connect"));
    	MainWindow.add("ChatField", new STextPane(),0,0,0,0,"BOTH");
    	MainWindow.add("ScrollPane", new JScrollPane (MainWindow.get("ChatField")),6,0,2,4, "BOTH",420,320);
		((JScrollPane)Main.MainWindow.get("ScrollPane")).setAutoscrolls(true);
    	MainWindow.add("MessageField",new JTextField ("Enter your message"),10,0,2,4,"BOTH");
    	((JTextField) MainWindow.get("MessageField")).addActionListener(new onMessageSend());
    	MainWindow.addWindowListener(new SWindowListener());
    	MainWindow.setResizable(false);
    }
	public static void restart() throws IOException {
		Runtime.getRuntime().exec("java Chat.jar");
		System.exit(0);
  }
}
