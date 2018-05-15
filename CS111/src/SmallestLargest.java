
public class SmallestLargest {

	public static void main(String[] args) {
		double input = IO.readDouble();
		double temp=0;
		temp=IO.readDouble(); 
		
		if (input==temp) {
			IO.reportBadInput();
			return;
		}
		
		double small= temp;
		double large = temp;
		while (input!=temp) {	
			if (temp<small && input!=temp) {
				small=temp;
			}
			if (temp>large && input!=temp) {
				large=temp;
			}
			temp=IO.readDouble();
		}
		
		IO.outputDoubleAnswer(small);
		IO.outputDoubleAnswer(large);
	}

}
