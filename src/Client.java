import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JTextField;

public class Client extends Thread{
	Socket socket;
	private PrintWriter out = null;
	private Scanner in = null;
	private String nickname;
	private STextPane ChatField;
	private boolean running;
	public String getNickname(){
		return nickname;
	}
	public Client(String address, int port) throws IOException{
		socket = new Socket(address,port);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new Scanner(socket.getInputStream());
		System.out.println("Enter your nickname");
		nickname = ((JTextField) Main.MainWindow.get("Nickname")).getText();
		out.println("#"+nickname);
		ChatField = (STextPane) Main.MainWindow.get("ChatField");
	}
	public void Run(){
		start();
	}
	public void Close(){
		running = false;
		in.close();
		out.println("-exit");
	}
	public void send(String msg){
		out.println(msg);
	}
	public void run(){
		running = true;
		while(running)
			if (in.hasNext() && running)
				ProcessMessage(in.nextLine());
	}
	public void ProcessMessage(String s){
		if (s.startsWith("Server"))
			ChatField.sysMsg(s);
		else if (s.startsWith("null") == false)
			ChatField.simpleMsg(s);
	}
}
