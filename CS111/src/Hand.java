
/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */

//import java.util.ArrayList;

public class Hand {

	private Card[] hand;   // The cards in the hand.
	private int count; 

	/**
	 * Create a hand that is initially empty.
	 */
	public Hand() {
		hand = new Card[5];
		count = 0;
	}

	/**
	 * Remove all cards from the hand, leaving it empty.
	 */
	public void clear() {
		for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
		count = 0;
	}

	/**
	 * Add a card to the hand.  It is added at the end of the current hand.
	 * @param c the non-null card to be added.
	 * @throws NullPointerException if the parameter c is null.
	 */
	public void addCard(Card c) {

		for(int i=0 ; i<hand.length; i++){ 
			if (hand[i] == null){
				hand[i] = c;
				count = count + 1;
				break;
			}
		}


	}

	/**
	 * Remove a card from the hand, if present.
	 * @param c the card to be removed.  If c is null or if the card is not in 
	 * the hand, then nothing is done.
	 */
	public void removeCard(Card c) {

		for(int i=0 ; i<hand.length; i++){ 
			if (hand[i].equals(c)){
				hand[i] = null;
				count = count-1;
			}
		}

	}

	/**
	 * Remove the card in a specified position from the hand.
	 * @param position the position of the card that is to be removed, where
	 * positions are starting from zero.
	 * @throws IllegalArgumentException if the position does not exist in
	 * the hand, that is if the position is less than 0 or greater than
	 * or equal to the number of cards in the hand.
	 */
	public void removeCard(int position) {

		if (position < 0 || position >= hand.length)

			throw new IllegalArgumentException("Position does not exist in hand: " + position);

		hand[position] = null;

	count--;

	}

	/**
	 * Returns the number of cards in the hand.
	 */
	public int getCardCount() { 
		return count;
	}

	/**
	 * Gets the card in a specified position in the hand.  (Note that this card
	 * is not removed from the hand!)
	 * @param position the position of the card that is to be returned
	 * @throws IllegalArgumentException if position does not exist in the hand
	 */
	public Card getCard(int position) {
		if (position < 0 || position >= hand.length)
			throw new IllegalArgumentException("Position does not exist in hand: "
					+ position);
		return hand[position];
	}

	/**
	 * Sorts the cards in the hand so that cards of the same suit are
	 * grouped together, and within a suit the cards are sorted by value.
	 * Note that aces are considered to have the lowest value, 1.
	 */
	public void sortBySuit() {
		int size = count;
		int nonnull = 0;
		int index = 0;

		Card[] newHand = new Card[5];
		while (size > 0) {
			if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
			int pos = nonnull;  // Position of minimal card.
			Card c = hand[nonnull];  // Minimal card.

			for (int i = nonnull+1; i < hand.length; i++) {
				Card c1 = hand[i];
				if (c1 != null){
					if ( c1.getSuit() < c.getSuit() ||
							(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
						pos = i;
						c = c1;
					}
				}
			}
			hand[pos] = null;
			size = size - 1;
			newHand[index++] = c;
			nonnull = 0;
		}
		hand = newHand;
	}

	/**
	 * Sorts the cards in the hand so that cards of the same value are
	 * grouped together.  Cards with the same value are sorted by suit.
	 * Note that aces are considered to have the lowest value, 1.
	 */
	public void sortByValue() {
		int size = count;
		int nonnull = 0;
		int index = 0;

		Card[] newHand = new Card[5];
		while (size > 0) {
			if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
			int pos = nonnull;  // Position of minimal card.
			Card c = hand[nonnull];  // Minimal card.

			for (int i = nonnull+1; i < hand.length; i++) {

				Card c1 = hand[i];
				if (c1 != null){
					if ( c1.getValue() < c.getValue() ||
							(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
						pos = i;
						c = c1;
					}
				}
			}
			hand[pos] = null;
			size = size - 1;
			newHand[index++] = c;
			nonnull = 0;
		}
		hand = newHand;
	}

	public void printHand(){

		for(int i=0; i<hand.length; i++){
			if (hand[i] != null){
				System.out.println(hand[i]);
			}
		}
		System.out.println();
	}


	/******************************** Implement your methods here ****************************************/
	//Returns the number of pairs this hand contains
	public int numPairs() {
		sortByValue();
		int pair=0;
		for(int i=0; i<hand.length-1; i++) {
			if (hand[i].getValue()==hand[i+1].getValue()) {
				pair++;
				i++;
			}
		}
		return pair;
	}

	//Returns true if this hand has 3 cards that are of the same value
	public boolean hasTriplet() {
		sortByValue();
		int triplet =0;
		for(int i=0; i<hand.length-2; i++) {
			if (hand[i].getValue()==hand[i+1].getValue() && hand[i].getValue()==hand[i+2].getValue()) {
				triplet++;
			}
		}
		if (triplet==1) {
			return true;
		}
		else {
			return false;
		}
	}

	//Returns true if this hand has all cards that are of the same suit
	public boolean hasFlush() {
		sortBySuit();
		int flush=0;
		for (int i = 0; i < hand.length-1; i++) {
			if (hand[i].getSuit()==hand[i+1].getSuit()) {
				flush++;
			}
		}
		if(flush<4) {
			return false;
		}
		else {
			return true;
		}
	}

	//Returns true if this hand has 5 consecutive cards of any suit
	public boolean hasStraight() {
		sortByValue();
		if (hand[0].getValue()== 1 && hand[1].getValue()== 10 && hand[2].getValue()== 11 && hand[3].getValue()== 12 && hand[4].getValue()== 13) {
			return true;
		}
		int straight=0;
		for (int i=0; i<hand.length-1; i++){
			if ((hand[i].getValue()+1) == (hand[i+1].getValue())) {
				straight++;
			} 
		}
		if(straight<4) {
			return false;
		}
		else {
			return true;
		}
	}

	//Returns true if this hand has a triplet and a pair of different values
	public boolean hasFullHouse() {
		sortByValue();
		if (numPairs()==2 && hasTriplet()==true) {
			return true;
		}
		else {
			return false;
		}
	}

	//Returns true if this hand has 4 cards that are of the same value
	public boolean hasFourOfAKind() {
		sortByValue();
		int fourOfAKind=0;
		for(int i=0; i<hand.length-3; i++) {
			if (hand[i].getValue()==hand[i+1].getValue() && hand[i].getValue()==hand[i+2].getValue() && hand[i].getValue()==hand[i+3].getValue()) {
				fourOfAKind++;
			}
		}
		if (fourOfAKind==1) {
			return true;
		}
		else {
			return false;
		}
	}

	//Returns the card with the highest value in the hand. When there is
	//more than one highest value card, you may return any one of them
	public Card highestValue() {
		this.sortByValue();
		int temp=0; 

		for (int i=0; i<hand.length; i++) {
			if (hand[i].getValue()>1) {
				temp=i;
			}
			if (hand[i].getValue()==1) {
				temp=i;
			}

		}
		if (hand[0].getValue()==1) {
			temp=0;
		}
		return hand[temp];
	}

	//Returns the highest valued Card of any pair or triplet found, null if
	// none. When values are equal, you may return either
	public Card highestDuplicate() {
		this.sortByValue();
		if (numPairs()==0) {
			return null;
		}
		int temp=0;
		for (int i=hand.length-1; i>0; i--) {
			if (hand[i].getValue()==hand[i-1].getValue()) {
				temp=i;
				break;
			}
		}
		if(hand[0].getValue()==1 && hand[1].getValue()==1) {
			temp=0;
		}
		return hand[temp];
	}

	//created myself
	public int ranking() {
		sortByValue();
		int handRanking=0;
		if (numPairs()==1) {
			handRanking=1;
		}
		if (numPairs()==2) {
			handRanking=2;
		}
		if (hasTriplet()==true) {
			handRanking=3;
		}
		if (hasFlush()==true) {
			handRanking=4;
		}
		if (hasStraight()==true) {
			handRanking=5;
		}
		if (hasFullHouse()==true) {
			handRanking=6;
		}
		if (hasFourOfAKind()==true) {
			handRanking=7;
		}
		if (hasFlush()==true && hasStraight()==true) {
			handRanking=8;
		}
		if ((hand[0].getValue()== 1 && hand[1].getValue()== 10 && hand[2].getValue()== 11 && hand[3].getValue()== 12 && hand[4].getValue()== 13) && hasFlush()==true) {
			handRanking=9;
		}
		return handRanking;
	}

	//Returns -1 if the instance hand loses to the parameter hand, 0 if 
	//the hands are equal, and +1 if the instance hand wins over the 
	//parameter hand. Hint: you might want to use some of the methods 
	//above
	public int compareTo(Hand h) {
		this.sortByValue();
		h.sortByValue();
		int handOne=this.ranking();
		int handTwo=h.ranking();
		int rank=0;
		if(handOne<handTwo) {
			rank= -1;
		}
		if(handOne>handTwo) {
			rank= 1;
		}
		if(handOne==handTwo) {
			if(numPairs()==1 && hasTriplet()==false && hasFourOfAKind()==false && h.numPairs()==1 && h.hasTriplet()==false && h.hasFourOfAKind()==false) { //ace
				if(this.highestDuplicate().getValue()>h.highestDuplicate().getValue()) {
					rank=1;
				}
				if(this.highestDuplicate().getValue()<h.highestDuplicate().getValue()) {
					rank=-1;
				}
				if((this.hand[0].getValue()==1) ^ (h.hand[0].getValue()==1) ) {
					if(this.hand[0].getValue()==1) {
						rank=1;
					}
					if(h.hand[0].getValue()==1) {
						rank=-1;
					}
				}
				if(this.highestDuplicate().getValue()==h.highestDuplicate().getValue()) {
					for(int i=hand.length-1; i>0; i--) {
						if((this.hand[0].getValue()==1) ^ (h.hand[0].getValue()==1) ) {
							if(this.hand[0].getValue()==1) {
								rank=1;
								break;
							}
							if(h.hand[0].getValue()==1) {
								rank=-1;
								break;
							}
						}
						if(this.hand[i].getValue()>h.hand[i].getValue()) {
							rank=1;
							break;
						}
						if(this.hand[i].getValue()<h.hand[i].getValue()) {
							rank=-1;
							break;
						}
					}
				}
			}
			if(numPairs()==2 && hasTriplet()==false && hasFourOfAKind()==false && h.numPairs()==2 && h.hasTriplet()==false && h.hasFourOfAKind()==false) {
				if(this.highestDuplicate().getValue()>h.highestDuplicate().getValue()) {
					rank=1;
				}
				if(this.highestDuplicate().getValue()<h.highestDuplicate().getValue()) {
					rank=-1;
				}
				if((this.hand[0].getValue()==1) ^ (h.hand[0].getValue()==1) ) {
					if(this.hand[0].getValue()==1) {
						rank=1;
					}
					if(h.hand[0].getValue()==1) {
						rank=-1;
					}
				}
				if(this.highestDuplicate().getValue()==h.highestDuplicate().getValue()) {
					//find second highest
					//highest value
					//rem ace
				}
			}
			if(hasTriplet()==true && h.hasTriplet()==true) { //ace
				int cardValueOfThis=0;
				for(int i=0; i<hand.length-2; i++) {
					if(hand[i].getValue()>1) {
						if (hand[i].getValue()==hand[i+1].getValue() && hand[i].getValue()==hand[i+2].getValue()) {
						}
						cardValueOfThis=hand[i].getValue();
					}
					if(hand[i].getValue()==1) {
						cardValueOfThis=14;
						break;
					}
				}
				
				int cardValueOfh=0;
				for(int j=0; j<hand.length-2; j++) {
					if(h.hand[j].getValue()>1) {
						if (h.hand[j].getValue()==h.hand[j+1].getValue() && h.hand[j].getValue()==h.hand[j+2].getValue()) {
							cardValueOfh=h.hand[j].getValue();
						}
					}
						if(h.hand[j].getValue()==1) {
							cardValueOfh=14;
							break;
					}
				}
				
				
				if(cardValueOfThis<cardValueOfh) {
					rank=-1;
				}
				
				if(cardValueOfThis>cardValueOfh) {
					rank=1;
				}
				if(cardValueOfThis==cardValueOfh) {
					if(h.numPairs()==1 && this.numPairs()==2) {
						rank=1;
					}
					if(h.numPairs()==2 && this.numPairs()==1) {
						rank=-1;
					}
					if(h.numPairs()==this.numPairs()) {
						for(int i=hand.length-1; i>0; i--) {
							if((this.hand[0].getValue()==1) ^ (h.hand[0].getValue()==1) ) {
								if(this.hand[0].getValue()==1) {
									rank=1;
									break;
								}
								if(h.hand[0].getValue()==1) {
									rank=-1;
									break;
								}
							}
							if(this.hand[i].getValue()>h.hand[i].getValue()) {
								rank=1;
								break;
							}
							if(this.hand[i].getValue()<h.hand[i].getValue()) {
								rank=-1;
								break;
							}
						}
					}
				}
			}
			if(hasFourOfAKind()==true && h.hasFourOfAKind()==true) { //ace
				int cardValueOfThis=0;
				for(int i=0; i<hand.length-3; i++) {
					if(hand[i].getValue()>1) {
						if (hand[i].getValue()==hand[i+1].getValue() && hand[i].getValue()==hand[i+2].getValue() && hand[i].getValue()==hand[i+3].getValue()) {
					}
						cardValueOfThis=h.hand[i].getValue();
					}
					if(h.hand[i].getValue()==1) {
						cardValueOfThis=14;
						break;
					}
				}
				if (hand[0].getValue()==1) {
					cardValueOfThis=14;
				}
				int cardValueOfh=0;
				for(int i=0; i<hand.length-3; i++) {
					if(h.hand[i].getValue()>1) {
						if (h.hand[i].getValue()==h.hand[i+1].getValue() && h.hand[i].getValue()==h.hand[i+2].getValue() && h.hand[i].getValue()==h.hand[i+3].getValue()) {
					}
						cardValueOfh=h.hand[i].getValue();
					}
					if(h.hand[i].getValue()==1) {
						cardValueOfh=14;
						break;
					}
				}
				
				if(cardValueOfThis>cardValueOfh) {
					rank=1;
				}
				if(cardValueOfThis<cardValueOfh) {
					rank=-1;
				}
				if(cardValueOfThis==cardValueOfh) {
					for(int i=hand.length-1; i>0; i--) {
						if((this.hand[0].getValue()==1) ^ (h.hand[0].getValue()==1) ) {
							if(this.hand[0].getValue()==1) {
								rank=1;
								break;
							}
							if(h.hand[0].getValue()==1) {
								rank=-1;
								break;
							}
						}
						if(this.hand[i].getValue()>h.hand[i].getValue()) {
							rank=1;
							break;
						}
						if(this.hand[i].getValue()<h.hand[i].getValue()) {
							rank=-1;
							break;
						}
					}
				}
			}

			else {
				for(int i=hand.length-1; i>0; i--) {
					if((this.hand[0].getValue()==1) ^ (h.hand[0].getValue()==1) ) {
						if(this.hand[0].getValue()==1) {
							rank=1;
							break;
						}
						if(h.hand[0].getValue()==1) {
							rank=-1;
							break;
						}
					}
					if(this.hand[i].getValue()>h.hand[i].getValue()) {
						rank=1;
						break;
					}
					if(this.hand[i].getValue()<h.hand[i].getValue()) {
						rank=-1;
						break;
					}
				}
			}
		}
		return rank;
	}
}