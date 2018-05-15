
public class StringRec {
	
	public static void main(String [] args) {
		String rle=IO.readString();
		IO.outputStringAnswer(decompress(rle));
	}
	
	public static String decompress(String compressedText) {
	    if (compressedText.length() <= 1) {
	        return compressedText;
	    }

	    char c = compressedText.charAt(0);

	    if (Character.isDigit(c)) {
	    		if (compressedText.charAt(0)=='1') {
	    			return compressedText.charAt(1) + decompress(compressedText.substring(2));
	    		}
	    		int count = c-'0';
	    		count --;
	    		
	        return compressedText.charAt(1) + decompress(count + "" + compressedText.charAt(1)+compressedText.substring(2));
	    }

	    return compressedText.charAt(0) + decompress(compressedText.substring(1));
	}
}