public class Player{

	//declare your fields here
	private double totalBalance;
	private Hand hand;
	
	//initialize your fields in the constructor
	public Player(double balance){
		totalBalance = balance;
		hand = new Hand();
		
	}

	public void deal(Card c){
		hand.addCard(c);
	}

	//Returns an array of Cards that the Player wishes to discard.
	//The game engine will call deal() on this player for each card
	//that exists in the return value. MS2 Instructions: Print the hand to
	//the terminal using System.out.println and ask the user which cards 
	//they would like to discard. The user will first the number of cards they
    //wish to discard, followed by the indices, one at a time, of
	//the card(s) they would like to discard, 
	//Return an array with the appropriate Card objects
	//that have been discarded, and remove the Card objects from this
	//player's hand. Use IO.readInt() for all inputs. In cases of error
	//re-ask the user for input.
	//
	// Example call to discard():
	//
	// This is your hand:
	// 0: Ace of Hearts
	// 1: 2 of Diamonds
	// 2: 5 of Hearts
	// 3: Jack of Spades
	// 4: Ace of Clubs
	// How many cards would you like to discard?
	// 2
	// 1
	// 2
	//
	// The resultant array will contain the 2 of Diamonds and the 5 of hearts in that order
	// This player's hand will now only have 3 cards
	public Card[] discard(){
		hand.printHand();
		int numOfCardsDiscard=0;
		while(numOfCardsDiscard<0||numOfCardsDiscard>5) {
			//numOfCardsDiscard=IO.readInt();
			return null;
		}
		int position=0;
		Card[]values=new Card[numOfCardsDiscard];
		for(int i=0; i<numOfCardsDiscard; i++) {
			//position=IO.readInt();
			while(position<0||position>4) {
				//position=IO.readInt();
				return null;
			}
			values[i]=hand.getCard(position);
			hand.removeCard(position);
			
		}
		return values;
	}

	//Returns the amount that this player would like to wager, returns
	//-1.0 to fold hand. Any non zero wager should immediately be deducted
	//from this player's balance. This player's balance can never be below
	// 0 at any time. This player's wager must be >= to the parameter min
	// MS2 Instructions: Show the user the minimum bet via the terminal 
	//(System.out.println), and ask the user for their wager. Use
	//IO.readDouble() for input. In cases of error re-ask the user for 
	//input.
	// 
	// Example call to wager()
	//
	// How much do you want to wager?
	// 200
	//
	// This will result in this player's balance reduced by 200
	
	public double wager(double min){
		//System.out.println("Bet bigger or equal than $ " + min + " or enter -1 to fold");
		double bet=min;
		if(bet<=-1) {
			return -1;
		}
		while (bet>totalBalance) {
			bet=-1;
		}
		while (bet<min) {
			bet=-1;
		}
		totalBalance=totalBalance-bet;
		return bet;
	}

	//Returns this player's hand
	public Hand showHand(){
		return hand;
	}

	//Returns this player's current balance
	public double getBalance(){
		return totalBalance;
	}

	//Increase player's balance by the amount specified in the parameter,
	//then reset player's hand in preparation for next round. Amount will
	//be 0 if player has lost hand
	public void winnings(double amount){
		totalBalance=totalBalance+amount;
		hand.clear();
	}

}