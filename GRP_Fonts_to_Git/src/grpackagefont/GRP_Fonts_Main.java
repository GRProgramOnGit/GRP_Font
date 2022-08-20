package grpackagefont;
import javax.swing.SwingUtilities;

public class GRP_Fonts_Main {

	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new Main_Wdw();
	            }
	        });
		

	}

}
