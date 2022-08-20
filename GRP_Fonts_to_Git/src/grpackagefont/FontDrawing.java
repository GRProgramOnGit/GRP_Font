package grpackagefont;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;

import javax.swing.JComponent;

public class FontDrawing extends JComponent {
		
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] fontNames = ge.getAvailableFontFamilyNames();
	int[] fontStyles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
	String[] styleNames = { "Plain", "Italic", "Bold", "Bold Italic" };
	 
	String drawFilter, drawText, drawFilterLowerCase;
	int drawSize;
	int anzahl;
	 
	public void paintComponent (Graphics g) {
		
		drawFilter = Inputs.getFilter();
		drawFilterLowerCase = drawFilter.toLowerCase();
//		System.out.println("Paint Filter: " + drawFilter);
		drawText = Inputs.getText();
//		System.out.println("Paint Text: " + drawText);
		drawSize = Inputs.getSize();
//		System.out.println("Paint Size: " + drawSize);
		anzahl=1;
			
		for (int i = 0; i < fontNames.length; i++) { // for each family
			
			Font firstFont = new Font("Arial", Font.BOLD, drawSize);
			g.setFont(firstFont);
			String nameFirstFont = "Next Font: " + fontNames[i]; 	// create name
			String nameFirstFontLowerCase = nameFirstFont.toLowerCase();
			if (nameFirstFontLowerCase.contains(drawFilterLowerCase) == true) {
				g.drawLine(drawSize+4, (anzahl) * (drawSize+4)-drawSize,drawSize+2900, (anzahl) * (drawSize+4)-drawSize );
				g.drawString(nameFirstFont, drawSize+4, (anzahl) * (drawSize+4)); // display name
				g.drawLine(drawSize+4, (anzahl) * (drawSize+4)+4,drawSize+2900, (anzahl) * (drawSize+4)+4 );
				anzahl ++;
			}
			
			for (int j = 0; j < fontStyles.length; j++) { // for each style
				Font font = new Font(fontNames[i], fontStyles[j], drawSize); // create font
				g.setFont(font); // set font
				String name = fontNames[i] + " " + styleNames[j] + " " + drawText; // create name
				String nameLowerCase = fontNames[i].toLowerCase();
//				System.out.println("Font: " + name);
//				System.out.println("True or False: " + name.contains(drawFilter));
				
				if (nameLowerCase.contains(drawFilterLowerCase) == true) {
					g.drawString(name, drawSize+4, (anzahl) * (drawSize+4)); // display name
					anzahl ++;
				}
   	        }
		}
	}

	public void drawFontsNew () {
		 
		 drawText=Inputs.getText();
		 drawFilter=Inputs.getFilter();
		 
//		 System.out.println("FontDrawing " +  drawText);
//		 System.out.println("FontDrawing " + drawFilter);
			 
		 Main_Wdw.repaintPanel();
		 		 
	 }
	 
}
