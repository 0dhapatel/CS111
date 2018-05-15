
public class Change {
	public static void main(String[] args) {
		System.out.println("How much does it cost: ");
		double cost = IO.readDouble();
		
		System.out.println("How much are you paying: ");
		double pay = IO.readDouble();
		
		double change;
		int num;
		change=pay-cost;
		if (change/20>=1) {
			num=(int)(change/20);
			System.out.println(num + " $20");
			change=change-(num*20);
		}
		if (change/10>=1) {
			num=(int)(change/10);
			System.out.println(num +" $10");
			change=change-(num*10);
		}
		if (change/1>=1) {
			num=(int)(change/1);
			System.out.println(num +" $1");
			change=change-(num*1);
		}
		if (change/.25>=1) {
			num=(int)(change/.25);
			System.out.println(num +" quarters");
			change=change-(num*.25);
		}
		if (change/.1>=1) {
			num=(int)(change/.1);
			System.out.println(num +" dimes");
			change=change-(num*.1);
		}
		if (change/.05>=1) {
			num=(int)(change/.05);
			System.out.println(num +" nickels");
			change=change-(num*.05);
		}
		if (change/.01>=1) {
			num=(int)(change/.01);
			System.out.println(num +" pennies");
			change=change-(num*.01);
		}
		
	}
}
