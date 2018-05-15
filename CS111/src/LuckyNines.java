
public class LuckyNines {
	public static void main(String[]args) {
		System.out.println("Lower number: ");
		int smallNum=IO.readInt();
		System.out.println("Upper number: ");
		int largeNum=IO.readInt();
		IO.outputIntAnswer(countLuckyNines(smallNum,largeNum));
	}
	public static int countLuckyNines(int lowerEnd, int upperEnd) {
		if(upperEnd<lowerEnd) {
			return -1;
		}
		else{
			int nine = 0;
			for (int i=lowerEnd; i<=upperEnd; i++) {
				String num=Integer.toString(i);
				for (int j=0; j<num.length(); j++) {
					char x = num.charAt(j);
					if( x == '9') {
						nine++;
					}
				}
			}
			return nine;
		}
	}
}
