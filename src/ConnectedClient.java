import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ConnectedClient extends Thread{
	private Socket socket;
	private String nickname;
	private PrintWriter out;
	private Scanner in;
	private boolean running;
	private STextPane ChatField;
	public ConnectedClient(Socket socket) throws IOException{
		this.socket = socket;
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new Scanner(socket.getInputStream());
		ChatField = (STextPane) Main.MainWindow.get("ChatField");
		start();
	}
	public void setNickname(String s){
		nickname = s;
	}
	public String getNickname(){
		return nickname;
	}
	public PrintWriter getWriter(){
		return out;
	}
	public Scanner getScanner(){
		return in;
	}
	public void send(String s){
		out.println(s);
	}
	public InetAddress getAddress(){
		return socket.getLocalAddress();
	}
	public String receive(){
		if (in.hasNext())
			return in.nextLine();
		else
			return null;
	}
	public void run(){
		running = true;
		while (running){
			ProcessRequest(receive());
		}
	}
	public void kill(){
		running = false;
	}
	public void kick(){
		running = false;
		Main.server.disconnectClient(nickname);
		
	}
	public void sendtoOthers(String msg){
		for (ConnectedClient i:Server.clients)
			if (this!=i)
				i.send(msg);
	}
	public void ProcessRequest(String request){
		if (request == null){
			kick();
			Main.server.sendtoAll("Client "+nickname+" disconnected from the server");
			ChatField.sysMsg("Client "+getNickname()+" disconnected from the server");
			System.out.println("Client "+getNickname()+" disconnected from the server");
		}
		else
		if (request.charAt(0)=='#'){			
			setNickname(request.substring(1));
			Main.server.sendtoAll("Client "+nickname+"("+socket.getInetAddress()+") connected to the server");
			ChatField.sysMsg("Client "+getNickname()+" connected to the server");
			System.out.println("Client "+getNickname()+" connected to the server");
		}
		else if (request.charAt(0)=='-')
			switch(request){
			case "-time":out.println(System.currentTimeMillis()); break;
			case "-exit":kick(); break;
			}
		else{
			sendtoOthers(nickname +": "+request);
			ChatField.simpleMsg(nickname +": "+request);
			System.out.println(nickname +": "+request);
		}
	}
}
