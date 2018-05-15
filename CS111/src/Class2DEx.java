
public class Class2DEx {
	public static void main(String [] args) {
		int [][] arr= {{6,7,8,9}, {8,9,9,9}, {1,2,3,4}};
		print2DArray(arr);
		arravg(arr);
		stuavg(arr);
	}
	public static void print2DArray(int[][]a) {
		for (int row=0; row<a.length; row++) {
			System.out.print("Exam" + (row+1));
			for (int col=0; col<a[row].length; col++) {
				System.out.print("\t"+a[row][col]);
			}
			System.out.println();
		}
	}
	public static void arravg(int[][]a) {
		double []rowavg=new double [a.length];
		for(int row =0; row < a.length; row++) {
			double sum=0;
			for (int col=0; col <a[row].length;col++) {
				sum+=a[row][col];
			}
			rowavg[row]=sum/a[row].length;
		}
	}
	public static void stuavg(int[][]a) {
		//try to get col avg
	}
}