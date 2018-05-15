
public class Convert {

	public static void main(String[] args) {
		String string=IO.readString();
		Boolean sign=IO.readBoolean();
		IO.outputIntAnswer(convert(string,sign));
	}

	public static int convert (String binaryString, boolean signBit){
		String number="";
		String num="";
		int converted=0;
		if (signBit==true) {
			int x=Integer.parseInt(binaryString);
			while(x>0) {
				number+=(x%2);
				x=x/2;
			}
			for (int i = number.length()-1; i>-1; i--) {
				num+=number.charAt(i);
			}
			converted=Integer.parseInt(num);
		}

		else if (signBit==false) {
			converted=Integer.parseInt(binaryString, 2);
		}
		return converted;
	}

}
