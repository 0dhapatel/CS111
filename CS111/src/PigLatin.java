
public class PigLatin {

	public static void main(String[] args) {
		String word = IO.readString();
		IO.outputStringAnswer(translate(word));
	}
	
	public static String translate (String original){
		if (original.charAt(0)=='a' || 
				original.charAt(0)=='e' || 
				original.charAt(0)=='i' || 
				original.charAt(0)=='o' || 
				original.charAt(0)=='u' ||
				original.charAt(0)=='A' || 
				original.charAt(0)=='E' || 
				original.charAt(0)=='I' || 
				original.charAt(0)=='O' || 
				original.charAt(0)=='U') {
			original = original +"vai";
		}
		else {
			original = original.substring(1) + original.charAt(0) +"ai";
		}
		return original;
	}

}
