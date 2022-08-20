package grpackagefont;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main_Wdw {
	
	private ImageIcon GRPLogoIcon;
	
	static JPanel panelFont;
    static JPanel panelInput;
    static JScrollPane scrollPane;
	
	public Main_Wdw() {
		
		JFrame frame = new JFrame();
			
		frame.setSize(1200,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		// Bildschirmauflösung für Fensterlagenberechnung
		int x = (d.width - frame.getSize().width) / 2;			//Platzierung Mitte Fenster
        int y = (d.height - frame.getSize().height) / 2;			//Platzierung Mitte Fenster
        frame.setLocation(x, y);									//Platzierung Mitte Fenster	
		frame.setTitle("GRP Font Explorer");
		try {
			GRPLogoIcon = new ImageIcon("GRP_small.png");
			frame.setIconImage(GRPLogoIcon.getImage());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
        
//        frame.setLayout(null);									//JFramel hat Borderlayoutmanager by default, damit kann man ausschalten		
																	//deaktiviert damit man JPanel keine Position geben muss.
        panelFont = new FontPanel();
        panelInput = new InputPanel();
        panelInput.setPreferredSize(new Dimension(200,200));
               
//        panel.setPreferredSize(new Dimension (900,900));
//        panel.setBounds(10,200,950,950);
//        panel.setSize(500, 500); 
        
        scrollPane = new JScrollPane(panelFont);					// JScrollpane funkt nur wenn panelFont direkt im Aufruf
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);		// Scrollgeschwindigkeit
        
        //ScrollPane scrollPane = new ScrollPane();					// Scrollpane  Ausführung der Laufleisten
        //scrollPane.add(panelFont);								// Hier kann man seperat adden, aber Scrollgesschwindikeitszeile funbt nicht mit Scrollpane
        
//        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelInput, BorderLayout.NORTH);
        frame.setVisible(true);
	
	} 
	
	public static void repaintPanel () {
		
		panelFont.setVisible(false);
		panelFont.setVisible(true);
	}
		
	public static void scrollbarOnTop() {							// Aufruf über Button GoGo in InputPanel
		scrollPane.getViewport().setViewPosition(new Point (0,0));	// Springt bei Buttonbetätigung auf x,y 0,0 im Fenster also nach oben
	}
}      
    