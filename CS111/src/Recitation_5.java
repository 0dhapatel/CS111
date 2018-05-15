
public class Recitation_5 {
	public static void main(String[] args) {
		/*int num = IO.readInt();
		int x=0;
		for(int i= 0; i<=num; i++) {
			x=x+i;
		}
		
		
		while (num>0) {
			x=num+x;
			num--;
		}
		
		
		int y=0;
		do {
			y++;
			x+=y;
		}
		while (y<num);
		IO.outputIntAnswer(x);*/
		//sums the n number of times in 3 different loops
		
		int num = IO.readInt();
		int max=0;
		for(int i=0; i<num; i++) {
			int x = IO.readInt();
			if(x>max) {
				max=x;
			}
			//max=Math.max(x);
		}
		
	}
}
