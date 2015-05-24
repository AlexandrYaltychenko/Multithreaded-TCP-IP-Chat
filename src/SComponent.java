import java.awt.Component;


public class SComponent {
	public Component c;
	public int x, y;
	public int w,h;
	public String ID;
	public  SComponent(String ID, Component c,int x, int y, int w, int h){
		this.ID=ID;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.c=c;
		}
}
