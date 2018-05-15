
public class PayFee {
	
	public static void main(String[] args) 
	{
		double payment;
		double fee=0.0;
		
		System.out.println("Payment amount: ");
		payment = IO.readDouble();
		
		if (payment>0 && payment<=500) 
		{
			fee=10;
		}
		
		else if (payment>500 && payment<5000) 
		{
			fee = payment*.01;
			if (fee<20) 
			{
				fee=20;
			}
		}
		else if (payment>=5000 && payment<10000) 
		{
			fee = payment * .02;
			if (fee<120) 
			{
				fee=120;
			}
		}
		else if (payment>=10000) 
		{
			if (payment == 10000) {
				fee = payment * .02;
			}
			else if (payment > 10000 && payment <= 15000) {
				payment = payment - 10000;
				fee = (10000 * .02) + (payment * .03);
			}
			else if (payment > 15000) {
				payment = payment - 15000;
				fee = (10000 * .02) + (5000 * .03) + (payment * .04);
			}
		}
		

		IO.outputDoubleAnswer(fee);
	}

}
