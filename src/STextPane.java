import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;


public class STextPane extends JTextPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Style stylesys, stylemsg, styleown;
	public STextPane(){
		stylesys = this.addStyle("sysMsg", null);
		stylemsg = this.addStyle("simpleMsg", null);
		styleown = this.addStyle("ownMsg", null);
		StyleConstants.setForeground(stylesys, Color.RED);
		StyleConstants.setFontSize(stylesys, 14);
		StyleConstants.setForeground(stylemsg, Color.BLACK);
		StyleConstants.setFontSize(stylemsg, 14);
		StyleConstants.setForeground(styleown, Color.BLUE);
		StyleConstants.setFontSize(styleown, 14);
		this.setEditable(false);
	}
	public void sysMsg(String s){	
		if (s.length()>0)
			s += "\n";
		try {
			getDocument().insertString(getDocument().getLength(), s, stylesys);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollBar vertical = ((JScrollPane)Main.MainWindow.get("ScrollPane")).getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}
	public void simpleMsg(String s){		
		if (s.length()>0)
			s += "\n";
		try {
			getDocument().insertString(getDocument().getLength(), s, stylemsg);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		JScrollBar vertical = ((JScrollPane)Main.MainWindow.get("ScrollPane")).getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}
	public void ownMsg(String s){	
		if (s.length()>0)
			s += "\n";
		try {
			getDocument().insertString(getDocument().getLength(), s, styleown);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		JScrollBar vertical = ((JScrollPane)Main.MainWindow.get("ScrollPane")).getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}
	

}
