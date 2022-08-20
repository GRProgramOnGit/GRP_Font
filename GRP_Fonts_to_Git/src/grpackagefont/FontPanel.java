package grpackagefont;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FontPanel extends JPanel {
		
	public FontDrawing fontDrawing = new FontDrawing();
	
	int fontHigh;
		
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] families = ge.getAvailableFontFamilyNames();
	private int panelHigth;
		
	public FontPanel() {
		
		//setLayout(null);										//Jpanel hat Flowlayoutmanager by default, damit ausgeschaltet
		
		fontHigh = Inputs.getSize();
		System.out.println("Zeichenhöhe bei Panel Start:" + fontHigh);	
		panelHigth = families.length*(72+4)*5+50;
		
		fontDrawing.setPreferredSize(new Dimension (3000,panelHigth));
		fontDrawing.setBounds(10,200,950,panelHigth);
		fontDrawing.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
		System.out.println(panelHigth);
		add(fontDrawing);
		
	}
	
}
