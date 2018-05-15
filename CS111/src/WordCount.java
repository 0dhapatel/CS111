
public class WordCount {
	public static void main(String[] args){

		String sentence = IO.readString();
		int length=IO.readInt();

		IO.outputStringAnswer(""+countWords(sentence,length));
	}

	public static int countWords(String original, int maxLength){
		int count = 0;
		int myStringLn=0;
		int found=0;
		for (int i=0;i<original.length();i++){
			myStringLn++;
			if((original.charAt(i)>='a' && original.charAt(i)<='z')||(original.charAt(i)>='A' && original.charAt(i)<='Z')||original.charAt(i)==' '||(myStringLn==original.length())) {
				count++;
				if (original.charAt(i)==' ') {
					if ((count-1)<=maxLength && (count-1)>0) {
						found++;
					}
					count=0;
				}
				if ((myStringLn)==original.length()) {
					if (!((original.charAt(i)>='a' && original.charAt(i)<='z')||(original.charAt(i)>='A' && original.charAt(i)<='Z'))){
						count=count-1;
					}
					if ((count)<=maxLength && count>0) {
						found++;
					}
					count=0;
				}
			}
		}
		return found;
	}
}
