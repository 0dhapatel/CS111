
public class Prime {
	public static void main(String[] args) {
		boolean prime=false;
		int num = IO.readInt();
		if (num == 2) {
			prime = true;
		}
		int odd = 3;
		while (prime) {
			if (num % odd == 0) {
			prime = false;
			}
			odd +=2;
		}
		prime = false;
		IO.outputBooleanAnswer(prime);
	}
}
