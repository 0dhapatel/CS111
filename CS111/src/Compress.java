
public class Compress {

	public static void main(String[] args) {
		String word=IO.readString();
		IO.outputStringAnswer(compress(word));
	}
	public static String compress (String original){
		int count = 0;
		String temp = "";
		
		
		for(int i = 0; i < original.length(); i++){
			if(i == original.length()-1){
				if(count == 0){
				temp = temp + original.charAt(i);
				break;
				}
				else {
					temp = temp + (count+1) + original.charAt(i);
					break;
				}
			}
			if(original.charAt(i) == original.charAt(i+1)){
				count++;
				
			}
			else{
				if(count == 0){
					temp = temp + original.charAt(i);
				}
				else{
				temp = temp + (count+1) + original.charAt(i);
				count = 0;
				}
			}
		}
		return(temp);
	}

}
