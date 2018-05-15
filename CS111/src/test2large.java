public class test2large {
	public static void main(String [] args){

		int counter = 0; 

		double term = IO.readDouble();

		double input = IO.readDouble();
		double l1, l2;
		if(input!=term){
			l1 = input;
			l2 = input;
			counter++; 
		}
		else{ 
			do{
				IO.reportBadInput();
				input = IO.readDouble();
			}
			while(input==term);
			l1 = input;
			l2 = input;
			counter++; 
		}

		input = IO.readDouble();

		if(input==term){
			do{
				IO.reportBadInput();
				input = IO.readDouble();
			}
			while(input==term);
			counter++; 
		}
		else
			counter++; 

		if(input > l1){
			double temp = l1;
			l1 = input;
			l2 = temp;
		}
		else
			l2 = input;

		if(counter == 2){
			input = IO.readDouble();
			while(input != term){
				if(input > l1){
					double temp = l1;
					l1 = input;
					l2 = temp;
				}
				else{
					if(input > l2)
						l2 = input;
				}
				input = IO.readDouble();
			}
		}

		else
			IO.reportBadInput();

		IO.outputDoubleAnswer(l1);
		IO.outputDoubleAnswer(l2);

	}
}
