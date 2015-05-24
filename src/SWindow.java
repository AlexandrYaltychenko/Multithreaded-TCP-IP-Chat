import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;


public class SWindow extends JFrame{
	private static final long serialVersionUID = -7197486368118080492L;
	GridBagLayout g;
    GridBagConstraints c;
    ButtonGroup bg;
    ArrayList<SComponent>components = new ArrayList<SComponent>();

    public void add(String ID,Component a, int x, int y, int w, int h, String fill){
    	components.add(new SComponent(ID,a,x,y,w,h));
        c.gridx=y;
        c.gridy=x;
        c.gridheight=h;
        c.gridwidth=w;
        c.weightx=0.5;
        c.weighty=1.0;
        c.ipadx=2;
        c.ipady=2;
        switch(fill){
        case "BOTH":c.fill=GridBagConstraints.BOTH;break;
        case "HORIZONTAL":c.fill=GridBagConstraints.HORIZONTAL;break;
        case "VERTICAL":c.fill=GridBagConstraints.VERTICAL;break;
        }
        g.setConstraints(a,c);
        this.add(a);
        }
    public void add(String ID,Component a, String fill){
    	components.add(new SComponent(ID,a,0,0,1,1));
        c.gridx=0;
        c.gridy=0;
        c.gridheight=1;
        c.gridwidth=1;
        c.weightx=0.5;
        c.weighty=1.0;
        c.ipadx=2;
        c.ipady=2;
        switch(fill){
        case "BOTH":c.fill=GridBagConstraints.BOTH;break;
        case "HORIZONTAL":c.fill=GridBagConstraints.HORIZONTAL;break;
        case "VERTICAL":c.fill=GridBagConstraints.VERTICAL;break;
        }
        g.setConstraints(a,c);
        this.add(a);
        }
    public void add(String ID,Component a, int x, int y, int w, int h, String fill,int group){
    	components.add(new SComponent(ID,a,x,y,w,h));
        c.gridx=y;
        c.gridy=x;
        c.gridheight=h;
        c.gridwidth=w;
        c.weightx=0.5;
        c.weighty=1.0;
        c.ipadx=2;
        c.ipady=2;
        switch(fill){
        case "BOTH":c.fill=GridBagConstraints.BOTH;break;
        case "HORIZONTAL":c.fill=GridBagConstraints.HORIZONTAL;break;
        case "VERTICAL":c.fill=GridBagConstraints.VERTICAL;break;
        }
        g.setConstraints(a,c);
        this.add(a);
        if (group==1)
        	bg.add((AbstractButton) a);
        }
    public void add(String ID,Component a, int x, int y, int w, int h, String fill, int sizex, int sizey){
    	components.add(new SComponent(ID,a,x,y,w,h));
        c.gridx=y;
        c.gridy=x;
        c.gridheight=h;
        c.gridwidth=w;
        c.weightx=0.5;
        c.weighty=1.0;
        c.ipadx=2;
        c.ipady=2;
        a.setPreferredSize(new Dimension (sizex, sizey));
        switch(fill){
        case "BOTH":c.fill=GridBagConstraints.BOTH;break;
        case "HORIZONTAL":c.fill=GridBagConstraints.HORIZONTAL;break;
        case "VERTICAL":c.fill=GridBagConstraints.VERTICAL;break;
        }
        g.setConstraints(a,c);
        this.add(a);
        }
    public SWindow(String title){
    	super(title);
        g = new GridBagLayout();
        c = new GridBagConstraints();
        setLayout(g);
        bg = new ButtonGroup();
    }
    public Component get(String ID){
    	for (SComponent a:components){
    		if (a.ID==ID){
    			return a.c;
    		}
    	}
    	return null;
    }
    public void showWindow(){
    	setVisible(true);
    	pack();
    }
}
