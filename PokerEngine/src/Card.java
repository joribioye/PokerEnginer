//Lab done by John Oribioye, Drew Madden, Aylin Dindi, Michael Matimu and Arnold Rivers

public class Card {
	private short CardValue;
	private short CardSuit;
	
	private static String[] Value = {"A","2","3","4","5","6","7","8",
		"9","10","J","Q","K" };
	private static String[] Suit = { "Spades", "Hearts", "Clubs", "Diamonds" };

	

	public Card() {}

	public Card(short CardValue, short CardSuit) {

		this.CardValue = CardValue;
		this.CardSuit = CardSuit;
	}
	public short getValue() {
		return CardValue;
}
	public short getSuit() {
		return CardSuit;
		}
		
}


