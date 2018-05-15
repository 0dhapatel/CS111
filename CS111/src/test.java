
public class test {

	public static void main(String[] args) {
		//pyramid(5);
		//System.out.println(anagram("silence","silent"));
		//String [] x={"i","coool", "did","found"};
		//parse(x);
		//int [] num = {2,2,2,4,5};
		//int [] bum = {1,2,3,4,5};
		//System.out.println(numPairs(num,bum));

		Hand test = new Hand();

		Card a= new Card(2,1);
		Card b= new Card(2,1);
		Card c= new Card(2,2);
		Card d= new Card(2,0);
		Card e= new Card(4,2);

		test.addCard(a);
		test.addCard(b);
		test.addCard(c);
		test.addCard(d);
		test.addCard(e);

	/*	Hand two = new Hand();

		Card f= new Card(1,1);
		Card g= new Card(1,1);
		Card h= new Card(1,2);
		Card i= new Card(1,0);
		Card j= new Card(3,2);

		two.addCard(f);
		two.addCard(g);
		two.addCard(h);
		two.addCard(i);
		two.addCard(j);

		System.out.println(test.compareTo(two));
		System.out.println("hi");
		binary(100);
		System.out.println();*/
		
		System.out.println("#");
		/*int numOfCardsDiscard=IO.readInt();
		int position=0;
		Card[]values=new Card[5];
		for(int j1=0; j1<numOfCardsDiscard; j1++) {
			System.out.println("Card");
			position=IO.readInt();
			values[j1]=test.getCard(position);
			test.removeCard(position);		
		}
		System.out.println(values);
		*/
			int delNumb = 0;
			int indexNumb = 0;
			Card[] deletedCards = new Card[5];
			System.out.println("How many cards to discard");
			delNumb = IO.readInt();
			
			int i = 0;
			while(delNumb > 0) {
			System.out.println("What indices to delete?");
			indexNumb = IO.readInt();
			deletedCards[i] = test.getCard(indexNumb);
			i++;
			test.removeCard(indexNumb);
			delNumb--; 
			}
			System.out.println( deletedCards);
			
	}
	
	public static double wager(double min){
		if(min==-1) {
			return -1;
		}
		while (min>1000 || min<-1) {
			min=IO.readDouble();
		}
		return min;
	}
	
	public static void binary(int n) {
		if(n>0) {
			System.out.print(n%2);
			binary(n/2);
		}
	}

	/*public static int numPairs(int [] hand, int [] two) {
		int rank=0;
		for(int i=hand.length-1; i>=0; i--) {
			if((hand[0]==1) ^ (two[0]==1)) {
				   if(hand[0]==1) {
					   rank=1;
					   break;
				   }
				   if(two[0]==1) {
					   rank=-1;
					   break;
				   }
			   }
			   if(hand[i]>two[i]) {
				   rank=1;
				   break;
			   }
			   System.out.println(rank);
			   if(hand[i]<two[i]) {
				   rank=-1;
				   break;
			   }
			   System.out.println(rank);
		   }
		   return rank;
	   }*/

	/*public static void pyramid(int height) {
		//rec 6 4a
		for (int i=1;i<height; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i=height;i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}


		//rec 6 4b
		for(int x=0; x<height; x++) {
			for (int y=0; y<height-x; y++) {
				System.out.print(" ");
			}
			for (int z=0; z<=x; z++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}*/

	/*public static boolean anagram(String x, String y) {
		//rec 7 3
		boolean can=false;
			for (int i=0; i<x.length(); i++) {
			for(int j=0; j<y.length(); j++) {
				if(x.charAt(i)==y.charAt(j)) {
					can=true;
				}
				else {
					continue;
				}
			}
		}
			return can;
	}*/


	/*public static void parse (String [] arr) {
			//rec 8 3
		String x="";
		int count=0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i].length()>0) {
				x=arr[i];
				count++;
			}
		}
		System.out.println("word: " +x+ " number: "+count);
	}*/
	//rec 9 3&4

}
