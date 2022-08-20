package grpackagefont;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class About_Wdw extends JFrame {
	
	
	JLabel program;
	JLabel version1;
    JLabel version2;
    JLabel copyright1;
    JLabel copyright2;
    JLabel jLabelPic;
    JPanel jPanelPic;
    //Icon bild1;
    JTextArea text1;
		
	private ImageIcon GRPLogoIcon;	
	private Icon bild1;
		
	public About_Wdw() {
						
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		int frameWidth = 500; 					
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		// Bildschirmauflösung für Fensterlagenberechnung
		setResizable(true);
		int x = (d.width - getSize().width) / 2;						//Platzierung Mitte Fenster
        int y = (d.height - getSize().height) / 2;						//Platzierung Mitte Fenster
        setLocation(x, y);												//Platzierung Mitte Fenster				
        setTitle("GRP Font Explorer About");
        
        try {
			GRPLogoIcon = new ImageIcon("GRP_small.png");				//gespeichert direkt im Hauptprojekt
			setIconImage(GRPLogoIcon.getImage());
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}	
        
        setVisible(true);
        setLayout(null);
        
        program = new JLabel();
        version1 = new JLabel();
        version2 = new JLabel();
        copyright1 = new JLabel();
        copyright2 = new JLabel();
        text1 = new JTextArea();

        jLabelPic = new JLabel();											// Bild ist als JLabel in Jpanel einzufügen
        jPanelPic = new JPanel();

        try {
        	
			bild1= new ImageIcon("GRP_75.png");
			program.setText("rogram");
			
		} catch (Exception e) {
				
			e.printStackTrace();
			
		}
        
        File tempFile = new File("GRP_75.png");
        boolean exists = tempFile.exists();
        if (exists != true) {
        	System.out.println(" File exist nicht");
        	program.setText("GRProgram");
        	program.setBounds(100, 10, 400, 50);
        }
        else {
        	program.setBounds((frameWidth+114-400)/2+75, 10, 200, 50);
        	jLabelPic.setIcon(bild1);
    		jPanelPic.add(jLabelPic);
    		jPanelPic.setLocation((frameWidth+114-400)/2, 10);					//Auf Pixelbreite 728 berechnet da Bild nicht 500 sondern 728
            jPanelPic.setSize(75, 50);
            add(jPanelPic);
        }
       
        
//        pic12.add(pic11);
//        jPanelPic.setLocation((frameWidth+114-400)/2, 10);					//Auf Pixelbreite 728 berechnet da Bild nicht 500 sondern 728
//        jPanelPic.setSize(75, 50);
//        add(jPanelPic);
        
        Font schriftart1=new Font("Copperplate Gothic Bold",Font.BOLD,40);
        Font schriftart2=new Font("Copperplate Gothic Light",Font.PLAIN,12);	//font.plain+font.italic wäre auch noch kursiv
  
        program.setFont(schriftart1);
        //program.setBounds((frameWidth+114-400)/2+75, 10, 200, 50);
        add(program);
        
        version1.setText(" Version:");
        version1.setFont(schriftart2);
        Dimension size0 = version1.getPreferredSize();					//Textblockgröße durch Java errechnet
        version1.setBounds(50, 100, size0.width+10, 20);
        add(version1);
        
        version2.setText(" 0.1");
        version2.setFont(schriftart2);
        Dimension size1 = version2.getPreferredSize();
        version2.setBounds(50+size0.width+5, 100, size1.width+10, 20);			//size0.width und size0.heigth sindoptimale Höhe und Breite von String version1
        add(version2);
        
        copyright1.setText(" Copyright:");
        copyright1.setFont(schriftart2);
        Dimension size2 = copyright1.getPreferredSize();
        copyright1.setBounds(50, 130, size2.width+10, 20);
        add(copyright1);
        
        copyright2.setText(" by everyone how wants to use :)");
        copyright2.setFont(schriftart2);
        Dimension size3 = copyright2.getPreferredSize();
        copyright2.setBounds(50+size2.width+5, 130, size3.width+10, 20);
        add(copyright2);
        
        text1.setText("Filter Fonts installed on your Computer by name (Lower/Upper case don´t mind). Add your personal text to see how it looks. Change the Size you want to see. I hope you find the Program helpfully.");
        text1.setFont(schriftart2);
        text1.setBounds(50, 160, 400,200);
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		text1.setOpaque(false);											// setzt TextArea auf Durchsichtig für Hintergrund
		text1.setFocusable(false);										// text nicht mehr angreifbar oder veränderbar
		add(text1);
               
        repaint();
       
	}

}
