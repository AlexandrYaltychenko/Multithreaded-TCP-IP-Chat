import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;


public class Server extends Thread{
	public ServerSocket socket;
	public ConnectedClient csocket;
	public static ArrayList<ConnectedClient> clients = new ArrayList<ConnectedClient>();
	boolean running;
	private Scanner in = null;
	public Server() throws IOException{
		socket = new ServerSocket(3128);
		clients.add(new ConnectedClient (socket.accept()));
	}
	
	public void Run(){
		start();
	}
	public void Close(){
		for (ConnectedClient i:clients)
			i.kill();
		running = false;
		in.close();
	}
	public void disconnectClient(String id){
		for (int i=0; i<clients.size(); i++)
			if (clients.get(i).getNickname().equals(id)){
				clients.remove(i);
				break;
			}
				
	}
	public void sendtoAll (String msg){
		for (ConnectedClient i:clients)
			i.send("Server: "+msg);
	}
	public void run(){
		running = true;
		while(running){
			try {
				clients.add(new ConnectedClient (socket.accept()));
				} catch (IOException e) {
				}
		}
	}
}
