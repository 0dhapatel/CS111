
public class LuckySevens {
	public static void main(String[] args) {
		System.out.println("Lower number: ");
		int smallNum=IO.readInt();
		System.out.println("Upper number: ");
		int largeNum=IO.readInt();
		int seven = 0;
		if(smallNum>largeNum) {
			IO.reportBadInput();
			return;
		}
		for (int i=smallNum; i<=largeNum; i++) {
			String num=Integer.toString(i);
			for (int j=0; j<num.length(); j++) {
				char x = num.charAt(j);
				if( x == '7') {
					seven++;
				}
			}
		}
		IO.outputIntAnswer(seven);
	}
}
