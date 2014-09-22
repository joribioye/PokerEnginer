
import java.util.ArrayList;
import java.util.Comparator;


public class Hand  {
	private ArrayList<Card> cards;
	
	private int HandStrength;
	
	private int Kicker;
	
	private boolean Ace;
	
	private boolean Flush;
	
	private boolean Straight;
	private int HighHand;
	
	private int LowHand;
	
	

	public Hand(Deck d) {
		ArrayList<Card> GetFivecards = new ArrayList<Card>();
		for (int x = 0; x < 5; x++) {
			GetFivecards.add(d.draw());
		}
		cards = GetFivecards;
	}

	
	public void card_eva() {
		ArrayList<Card> sorting = new ArrayList<Card>();
			for(int x = 12; x>=0; x--){
				for(int i = 0; i <= 4; i++){
					if (cards.get(i).getValue()==x){
						sorting.add(cards.get(i));
					}
				}
				
			}
			cards = sorting;

		// Ace evaluation
		if (cards.get(4).getValue() == (short) 0) {
			Ace = true;
		}

		// flush evaluation 	

		if (cards.get(0).getSuit() == cards.get(1).getSuit()
				&& cards.get(0).getSuit() == cards.get(2).getSuit()
				&& cards.get(0).getSuit() == cards.get(3).getSuit()
				&& cards.get(0).getSuit() == cards.get(4).getSuit()) {
			Flush = true;
		} else {
			Flush = false;
		}

		// straight evaluation
		// from ace to 10
		if (Ace) {
			if ((cards.get(0).getValue() == (short) 12)
					&& (cards.get(1).getValue() == (short) 11)
					&& (cards.get(2).getValue() == (short) 10)
					&& (cards.get(3).getValue() == (short) 9)) {
				Straight = true;
			}

			//from ace to 5
			else if ((cards.get(0).getValue() == (short) 4)
					&& (cards.get(1).getValue() == (short) 3)
					&& (cards.get(2).getValue() == (short) 2)
					&& (cards.get(3).getValue() == (short) 1)) {
				Straight = true;
			} else {
				Straight = false;
			}
		}

		//straight without ace
		else if ((cards.get(0).getValue() == cards.get(1).getValue() + 1)
				&& (cards.get(0).getValue() == cards.get(2).getValue() + 2)
				&& (cards.get(0).getValue() == cards.get(3).getValue() + 3)
				&& (cards.get(0).getValue() == cards.get(4).getValue() + 4)) {
			Straight = true;
		} else {
			Straight = false;
		}

		// combination that pulls a royal flush
		if ((Ace) && (cards.get(0).getValue() == 12)
				&& (Straight == true) && (Flush == true)) {
			HandStrength = 10;
		}

		// combination that pulls a Straight Flush
		else if ((Straight == true) && (Flush == true)) {
			HandStrength = 9;
			Kicker = cards.get(0).getValue();
		}

		// combination that pulls a four of a kind
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(0).getValue() == cards.get(2).getValue())
				&& (cards.get(0).getValue() == cards.get(3).getValue())) {
			HandStrength = 8;
			Kicker = cards.get(4).getValue();
			HighHand = cards.get(0).getValue();
		} else if ((cards.get(4).getValue() == cards.get(1).getValue())
				&& (cards.get(4).getValue() == cards.get(2).getValue())
				&& (cards.get(4).getValue() == cards.get(3).getValue())) {
			HandStrength = 8;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(4).getValue();
		}

		// combination that pulls a full house
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(0).getValue() == cards.get(2).getValue())
				&& (cards.get(3).getValue() == cards.get(4).getValue())) {
			HandStrength = 7;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(4).getValue();
		}

		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(2).getValue() == cards.get(4).getValue())
				&& (cards.get(3).getValue() == cards.get(4).getValue())) {
			HandStrength = 7;
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(4).getValue();
		}

		// combination that pulls a flush
		else if (Flush) {
			HandStrength = 6;
			Kicker = cards.get(0).getValue();
			
		}

		// combination that pulls a Straight
		else if (Straight) {
			HandStrength = 5;
			Kicker = cards.get(0).getValue();
		}

		// combination that pulls a three of a kind
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(0).getValue() == cards.get(2).getValue())) {
			HandStrength = 4;
			Kicker = cards.get(3).getValue();
			HighHand = cards.get(0).getValue();
		}

		else if ((cards.get(1).getValue() == cards.get(2).getValue())
				&& (cards.get(1).getValue() == cards.get(3).getValue())) {
			HandStrength = 4;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(1).getValue();
		}

		else if ((cards.get(2).getValue() == cards.get(3).getValue())
				&& (cards.get(2).getValue() == cards.get(4).getValue())) {
			HandStrength = 4;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(2).getValue();
		}

		// combination that pulls two pair
		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(2).getValue() == cards.get(3).getValue())) {
			HandStrength = 3;
			Kicker = cards.get(4).getValue();
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(2).getValue();
		}

		else if ((cards.get(0).getValue() == cards.get(1).getValue())
				&& (cards.get(3).getValue() == cards.get(4).getValue())) {
			HandStrength = 3;
			Kicker = cards.get(2).getValue();
			HighHand = cards.get(0).getValue();
			LowHand = cards.get(3).getValue();
		} else if ((cards.get(1).getValue() == cards.get(2).getValue())
				&& (cards.get(3).getValue() == cards.get(4).getValue())) {
			HandStrength = 3;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(1).getValue();
			LowHand = cards.get(3).getValue();
		}

		// pair

		else if (cards.get(0).getValue() == cards.get(1).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(2).getValue();
			HighHand = cards.get(0).getValue();
		} else if (cards.get(1).getValue() == cards.get(2).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(2).getValue();
		} else if (cards.get(2).getValue() == cards.get(3).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(2).getValue();
		}

		else if (cards.get(3).getValue() == cards.get(4).getValue()) {
			HandStrength = 2;
			Kicker = cards.get(0).getValue();
			HighHand = cards.get(3).getValue();
		}

		else {
			HandStrength = 1;
			Kicker = cards.get(0).getValue();
		}
	}
	
	public ArrayList<Card> getcards() {
		return cards;
	}

	public int getHandStrength() {
		return HandStrength;
	}


	public int getHighHand() {
		return HighHand;
	}

	public int getLowHand() {
		return LowHand;
	}
	public int getKicker() {
		return Kicker;
	}

	public boolean isAce() {
		return Ace;
	}


	//The methods below compare hand Strength
	//Winner has the highest numerical strength under strength of hand

	public static Comparator<Hand> RankOfHand = new Comparator<Hand>() {

		public int compare(Hand Hand1, Hand Hand2) {

			int FinalResult = 0;

			FinalResult = Hand2.getHandStrength() - Hand1.getHandStrength();

			//Check if FinalResult Does Not to Yield to 0, 
			//then Return the Strength by Subtracting the second hand 
			//Strength from the first hand Strength

			if (FinalResult != 0) {

				return FinalResult;
			}

			//Return the Strength of High Pair

			FinalResult = Hand2.getHighHand() - Hand1.getHighHand();

			if (FinalResult != 0) {

				return FinalResult;

			}

			

			FinalResult = Hand2.getLowHand() - Hand1.getLowHand();

			if (FinalResult != 0) {
				return FinalResult;

			}

			FinalResult = Hand2.getKicker() - Hand1.getKicker();
			if (FinalResult != 0) {
				return FinalResult;

			}
			return 0;

		}

		


	};
}



