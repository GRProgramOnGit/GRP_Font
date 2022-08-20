package grpackagefont;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class InputPanel extends JPanel{
	
	private JButton butGo, butAbout;
	JLabel fontLabel, textlabel;
	JTextField fontFilter, privateText;
	JComboBox comboSize;
	
	public Inputs input1 = new Inputs();
	FontDrawing drawFont = new FontDrawing();
	
	ImageIcon icoN;
	ImageIcon icoN2;
	
	  
	public InputPanel() {
				
		setLayout(null);
		
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 25));
		
		butGo = new JButton();
		butGo.setFont(new Font("Arial", Font.PLAIN, 40));
		butGo.setBounds(625,100,250,50);
		butGo.setToolTipText("Push to Redraw");
        try {
			icoN = new ImageIcon ("GRP_60.png");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        int h = 50-20;
        int b = 50+10;
        try {
			icoN.setImage(icoN.getImage().getScaledInstance(b,h,Image.SCALE_DEFAULT));
			butGo.setIcon(icoN);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
        
        butGo.setText("GoGo");
		butGo.addActionListener(new GRP_ButtonListener());
		add(butGo);
		
		butAbout = new JButton();
		butAbout.setFont(new Font("Arial", Font.PLAIN, 20));
		butAbout.setBounds(1000,25,125,25);
		butAbout.setToolTipText("About GRP");
       	try {
			icoN2 = new ImageIcon ("GRP_60.png");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        int h2 = (50-20)/2;
        int b2 = (50+10)/2;
        try {
			icoN2.setImage(icoN2.getImage().getScaledInstance(b2,h2,Image.SCALE_DEFAULT));
			butAbout.setIcon(icoN2);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
        
		butAbout.setText("About");
		butAbout.addActionListener(new GRP_ButtonListener());
		add(butAbout);
		
		fontFilter = new JTextField();
		fontFilter.setText(input1.getFilter());
		fontFilter.setFont(new Font("Arial", Font.PLAIN, 30));
		fontFilter.setBounds(20,25,400,50);
		fontFilter.setToolTipText("Set a Font Name Filter");
		fontFilter.addActionListener(new GRP_ButtonListener());
		add(fontFilter);
		
		privateText = new JTextField();
		privateText.setText(input1.getText());
		privateText.setFont(new Font("Arial", Font.PLAIN, 30));
		privateText.setBounds(20,100,400,50);
		privateText.setToolTipText("Set a additional private Print Text");
		privateText.addActionListener(new GRP_ButtonListener());
		add(privateText);
		
		fontLabel = new JLabel();
		fontLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		fontLabel.setText("Font Filter");
		fontLabel.setBounds(450,25,150,50);
		fontLabel.setToolTipText("Set a Font Name Filter");
		add(fontLabel);
		
		textlabel = new JLabel();
		textlabel.setFont(new Font("Arial", Font.PLAIN, 30));
		textlabel.setText("Add Text");
		textlabel.setBounds(450,100,200,50);
		textlabel.setToolTipText("Set a additional private Print Text");
		add(textlabel);
		
		String [] fontSizes = { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72" };
		comboSize = new JComboBox<Object>(fontSizes);
		comboSize.setFont(new Font("Arial", Font.PLAIN, 30));
		comboSize.setBounds(625,25,80,40);
		comboSize.setToolTipText("Set a Font Size");
		comboSize.setSelectedIndex(8);
		comboSize.addItemListener(new GRP_ComboListener());
		add(comboSize);
		
	}
	
	class GRP_ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == butGo) {
			
				System.out.println("Klick");
				input1.setText(privateText.getText());
				input1.setFilter(fontFilter.getText());
				
				System.out.println("GoGo " + privateText.getText());
				System.out.println("GoGo " + fontFilter.getText());
				System.out.println("Übergabe " + Inputs.getText());
				System.out.println("Übergabe " + Inputs.getFilter());
						
				drawFont.drawFontsNew();
				Main_Wdw.scrollbarOnTop();
			
			}
			
			if(e.getSource() == butAbout) {
				About_Wdw aboutWdW = new About_Wdw();
			}
			
		}
	}
	
	class GRP_ComboListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	    	int itemInt = 0;
	    	if (event.getStateChange() == ItemEvent.SELECTED) {
	    		Object item = event.getItem();
	    		System.out.println("Combo-Box Wert: " + item);
	    		String itemString = item.toString();										// Objekt to String
	    		System.out.println("String-Box Wert: " + itemString);
	    		itemInt = Integer.parseInt(itemString);										// String to Integer
	    		input1.setSize(itemInt);
	    		System.out.println("Inputs Size Wert: " + Inputs.getSize());
	       }
	    }       
	}

}
