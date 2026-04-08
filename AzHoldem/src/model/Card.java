package model;

/**
 * class Card represents one of the 52 poker cards. There are no comments before
 * methods because the method name says it all.
 * 
 * @author Cameron Rodgers
 */

public class Card implements Comparable<Card> {
	private final Rank rank;
	private final Suit suit;

	// Constructor
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return rank.getValue();
	}

	public String toString() {
		// Use these four Unicode icons for the solid suit icons.
		char suitIcon = '\u2663';
		if (suit == Suit.DIAMONDS)
			suitIcon = '\u2666';
		if (suit == Suit.HEARTS)
			suitIcon = '\u2665';
		if (suit == Suit.SPADES)
			suitIcon = '\u2660';

		if (rank.getValue() == 11) {
			return "J" + suitIcon;
		}
		if (rank.getValue() == 12) {
			return "Q" + suitIcon;
		}
		if (rank.getValue() == 13) {
			return "K" + suitIcon;
		}
		if (rank.getValue() == 14) {
			return "A" + suitIcon;
		}
		// Need to get the value instead of "?"
		return Integer.toString(rank.getValue()) + suitIcon;
	}

	@Override
	public int compareTo(Card other) {
		return rank.getValue() - other.getValue();
	}

	public boolean equals(Card other) {
		return rank.getValue() == other.getValue();
	}

}
