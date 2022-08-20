package grpackagefont;

public class Inputs {
	
	public static int size;
	public static String filter;
	public static String text;
	
	public Inputs () {
		
		size = 20;
		filter = "";
		text = "";
	
	}

	public static int getSize() {
		return size;
	}

	public void setSize(int size1) {
		size = size1;
	}

	public static String getFilter() {
		return filter;
	}

	public void setFilter(String filter1) {
		filter = filter1;
	}

	public static String getText() {
		return text;
	}

	public void setText(String text1) {
		text = text1;
	}

}
