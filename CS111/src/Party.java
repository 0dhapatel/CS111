
public class Party {
	public static void main(String[] args) {
		int people;
		int slicesPerPerson;
		int cansPerPerson;
		double costOfPie;
		int sliceInPie;
		double costOfSoda;
		int cansInCase;
		int numberOfPie;
		int numberOfCases;
		double totalCost;
		
		System.out.println("Number of people attend: ");
		people = IO.readInt();
		System.out.println("Number of slices each person will have: ");
		slicesPerPerson = IO.readInt();
		System.out.println("Number of cans of soda each person will have: ");
		cansPerPerson = IO.readInt();
		System.out.println("The cost of pizza pie: ");
		costOfPie = IO.readDouble();
		System.out.println("Number slices in the pizza pie: ");
		sliceInPie = IO.readInt();
		System.out.println("The cost of case of soda: ");
		costOfSoda = IO.readDouble();
		System.out.println("Number cans in the case of soda: ");
		cansInCase = IO.readInt();
		
		numberOfPie = (slicesPerPerson * people) / sliceInPie;
		if ((slicesPerPerson * people) % sliceInPie != 0) {
			numberOfPie ++;
		}
		
		numberOfCases= (cansPerPerson * people) / cansInCase;
		if ((cansPerPerson * people) % cansInCase != 0) {
			numberOfCases ++;
		}
		
		totalCost = (numberOfCases * costOfSoda) + (numberOfPie * costOfPie);
		totalCost = (int) (totalCost * 100);
		totalCost = totalCost / 100;
		IO.outputDoubleAnswer(totalCost);
	}

}
