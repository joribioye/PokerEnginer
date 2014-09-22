
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> card_deck;

	
		
	
	public Deck() {
		card_deck = new ArrayList<Card>();
		for (short x = 0; x < 4; x++) {
			for (short y = 0; y < 13; y++) {
				card_deck.add(new Card(x,y));
			}}
		Collections.shuffle(card_deck, new Random());
		
}

	public Card draw() {
		Card firstcard = card_deck.get(0);
		card_deck.remove(0);
		return firstcard;
	}

	public int remaining_cards() {
		return card_deck.size();

	}

}


