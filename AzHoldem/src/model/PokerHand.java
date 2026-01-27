// Cameron Rodgers

package model;

import java.util.*;

public class PokerHand implements Comparable<PokerHand> {

	ArrayList<Card> cards;

	public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		cards.add(c1);
		if (cards.contains(c2)) {
			throw new IllegalArgumentException();
		} else {
			cards.add(c2);
		}
		if (cards.contains(c3)) {
			throw new IllegalArgumentException();
		} else {
			cards.add(c3);
		}
		if (cards.contains(c4)) {
			throw new IllegalArgumentException();
		} else {
			cards.add(c4);
		}
		if (cards.contains(c5)) {
			throw new IllegalArgumentException();
		} else {
			cards.add(c5);
		}
		Collections.sort(cards);
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < cards.size(); i++) {
			str += cards.get(i) + " ";
		}
		return str;
	}

	@Override
	public int compareTo(PokerHand o) {
		// TODO Complete this method, which will take many hours and many many @Tests
		// Royal flush tests
		if (royalFlush() && !o.royalFlush()) {
			return 1;
		} else if (royalFlush() && o.royalFlush()) {
			return 0;
		} else if (!royalFlush() && o.royalFlush()) {
			return -1;
		}

		// Straight flush tests
		else if (straightFlush() && !o.straightFlush()) {
			return 1;
		} else if (straightFlush() && o.straightFlush()) {
			int index = 4;
			Card occur1;
			Card occur2;
			while (index >= 0) {
				occur1 = cards.get(index);
				occur2 = o.cards.get(index);
				if (occur1.compareTo(occur2) != 0) {
					return occur1.compareTo(occur2);
				}
				index -= 1;
			}
			return 0;
		} else if (!straightFlush() && o.straightFlush()) {
			return -1;
		}

		// Four of a kind tests
		else if (fourOfAKind() && !o.fourOfAKind()) {
			return 1;
		} else if (fourOfAKind() && o.fourOfAKind()) {
			Card occur2 = o.mostOccurring();
			Card occur1 = mostOccurring();
			if (occur1.compareTo(occur2) == 0) {
				occur1 = leastOccurring();
				occur2 = o.leastOccurring();
				return occur1.compareTo(occur2);
			} else {
				return occur1.compareTo(occur2);
			}
		} else if (!fourOfAKind() && o.fourOfAKind()) {
			return -1;
		}

		// Full house tests
		else if (fullHouse() && !o.fullHouse()) {
			return 1;
		} else if (fullHouse() && o.fullHouse()) {
			Card occur2 = o.mostOccurring();
			Card occur1 = mostOccurring();
			if (occur1.compareTo(occur2) == 0) {
				occur1 = leastOccurring();
				occur2 = o.leastOccurring();
				return occur1.compareTo(occur2);
			} else {
				return occur1.compareTo(occur2);
			}
		} else if (!fullHouse() && o.fullHouse()) {
			return -1;
		}

		// Flush tests
		else if (flush() && !o.flush()) {
			return 1;
		} else if (flush() && o.flush()) {
			int index = 4;
			Card occur1;
			Card occur2;
			while (index >= 0) {
				occur1 = cards.get(index);
				occur2 = o.cards.get(index);
				if (occur1.compareTo(occur2) != 0) {
					return occur1.compareTo(occur2);
				}
				index -= 1;
			}
			return 0;
		} else if (!flush() && o.flush()) {
			return -1;
		}

		// Straight tests
		else if (straight() && !o.straight()) {
			return 1;
		} else if (straight() && o.straight()) {
			int index = 4;
			Card occur1;
			Card occur2;
			while (index >= 0) {
				occur1 = cards.get(index);
				occur2 = o.cards.get(index);
				if (occur1.compareTo(occur2) != 0) {
					return occur1.compareTo(occur2);
				}
				index -= 1;
			}
			return 0;
		} else if (!straight() && o.straight()) {
			return -1;
		}

		// Three of a kind tests
		else if (threeOfAKind() && !o.threeOfAKind()) {
			return 1;
		} else if (threeOfAKind() && o.threeOfAKind()) {
			Card occur1 = mostOccurring();
			Card occur2 = o.mostOccurring();
			if (occur1.compareTo(occur2) == 0) {
				ArrayList<Card> occur3 = allLeastOccur();
				ArrayList<Card> occur4 = o.allLeastOccur();
				if (occur3.get(1).compareTo(occur4.get(1)) != 0) {
					return occur3.get(1).compareTo(occur4.get(1));
				}

				return occur3.get(0).compareTo(occur4.get(0));
			} else {
				return occur1.compareTo(occur2);
			}
		} else if (!threeOfAKind() && o.threeOfAKind()) {
			return -1;
		}

		// Two pair tests
		else if (twoPair() && !o.twoPair()) {
			return 1;
		} else if (twoPair() && o.twoPair()) {
			ArrayList<Card> occur1 = allMostOccur();
			ArrayList<Card> occur2 = o.allMostOccur();
			Collections.sort(occur1);
			Collections.sort(occur2);
			if (occur1.get(3).compareTo(occur2.get(3)) == 0) {
				if (occur1.get(0).compareTo(occur2.get(0)) == 0) {
					Card occur3 = leastOccurring();
					Card occur4 = o.leastOccurring();
					return occur3.compareTo(occur4);
				} else {
					return occur1.get(0).compareTo(occur2.get(0));
				}
			} else {
				return occur1.get(3).compareTo(occur2.get(3));
			}
		} else if (!twoPair() && o.twoPair()) {
			return -1;
		}

		// Pair tests
		else if (pair() && !o.pair()) {
			return 1;
		} else if (pair() && o.pair()) {
			ArrayList<Card> occur1 = allMostOccur();
			ArrayList<Card> occur2 = o.allMostOccur();
			if (occur1.get(0).compareTo(occur2.get(0)) == 0) {
				ArrayList<Card> occur3 = allLeastOccur();
				ArrayList<Card> occur4 = o.allLeastOccur();
				Collections.sort(occur3);
				Collections.sort(occur4);
				for (int i = 2; i >= 0; i--) {
					if (occur3.get(i).compareTo(occur4.get(i)) != 0) {
						return occur3.get(i).compareTo(occur4.get(i));
					}
				}
				return 0;
			} else {
				return occur1.get(0).compareTo(occur2.get(0));
			}
		} else if (!pair() && o.pair()) {
			return -1;
		}

		// high card tests
		else {
			int index = 4;
			Card occur1;
			Card occur2;
			while (index >= 0) {
				occur1 = cards.get(index);
				occur2 = o.cards.get(index);
				if (occur1.compareTo(occur2) != 0) {
					return occur1.compareTo(occur2);
				}
				index -= 1;
			}
			return 0;

		}
	}

	public boolean royalFlush() {
		Suit suit = cards.get(0).getSuit();
		int prev = cards.get(0).getValue();
		int next = cards.get(0).getValue();
		if (next != 10) {
			return false;
		}
		for (int i = 0; i < cards.size(); i++) {
			next = cards.get(i).getValue();
			if (cards.get(i).getSuit() != suit) {
				return false;
			}
			prev = next;
		}
		return true;
	}

	public boolean straightFlush() {
		if (royalFlush() == true) {
			return false;
		}
		Suit suit = cards.get(0).getSuit();
		int prev = cards.get(0).getValue();
		int next = cards.get(0).getValue();

		for (int i = 0; i < cards.size(); i++) {
			next = cards.get(i).getValue();
			if (cards.get(i).getSuit() != suit) {
				return false;
			}
			if (i >= 1) {
				if (prev + 1 != next) {
					return false;
				}
				prev = next;
			}
		}

		return true;
	}

	public boolean fourOfAKind() {
		Card prev = cards.get(0);
		int count = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (prev.compareTo(cards.get(i)) == 0) {
				count += 1;
			}
		}
		if (count == 4) {
			return true;
		}
		count = 0;
		prev = cards.get(1);
		for (int i = 0; i < cards.size(); i++) {
			if (prev.compareTo(cards.get(i)) == 0) {
				count += 1;
			}
		}
		if (count == 4) {
			return true;
		}

		return false;
	}

	public boolean fullHouse() {
		int prev = cards.get(0).getValue();
		Suit suit = cards.get(0).getSuit();
		int save = prev;
		int count = 1;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() == prev && cards.get(i).getSuit() != suit) {
				count += 1;
				save = cards.get(i).getValue();
			}
		}

		if (count != 2 && count != 3) {
			return false;
		}
		int count2 = 1;

		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() != save) {
				prev = cards.get(i).getValue();
				suit = cards.get(i).getSuit();
			}
		}
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() == prev && suit != cards.get(i).getSuit()) {
				count2 += 1;
			}
		}
		if (count2 == 3 && count == 2) {
			return true;
		}
		if (count2 == 2 && count == 3) {
			return true;
		}
		return false;
	}

	public boolean flush() {
		Suit suit = cards.get(0).getSuit();
		if (straightFlush() == true || royalFlush() == true) {
			return false;
		}
		for (int i = 0; i < cards.size(); i++) {
			if (suit != cards.get(i).getSuit()) {
				return false;
			}
		}
		return true;
	}

	public boolean straight() {
		if (royalFlush() == true || straightFlush() == true || flush() == true) {
			return false;
		}
		Suit suit = cards.get(0).getSuit();
		int prev = cards.get(0).getValue();
		int next = cards.get(0).getValue();

		for (int i = 0; i < cards.size(); i++) {
			next = cards.get(i).getValue();
			if (i >= 1) {
				if (prev + 1 != next) {
					return false;
				}
				prev = next;
			}
		}
		return true;
	}

	public boolean threeOfAKind() {
		if (fullHouse() == true) {
			return false;
		}
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		for (Card i : cards) {
			count = 0;
			for (Card e : cards) {
				if (e.compareTo(i) == 0) {
					count += 1;
				}
			}
			list.add(count);
		}
		Collections.sort(list);
		if (list.get(3) == 3 && list.get(0) == 1) {
			return true;
		}
		return false;
	}

	public boolean twoPair() {
		if (fullHouse() == true || threeOfAKind() == true) {
			return false;
		}
		int current = cards.get(0).getValue();
		Suit suit = cards.get(0).getSuit();
		int count = 1;
		ArrayList<Integer> counts = new ArrayList<>();
		for (int i = 0; i < cards.size(); i++) {
			count = 1;
			suit = cards.get(i).getSuit();
			current = cards.get(i).getValue();
			for (int e = 0; e < cards.size(); e++) {
				if (e != i) {
					if (cards.get(e).getValue() == current && cards.get(e).getSuit() != suit) {
						count += 1;
					}
				}
			}
			counts.add(count);
		}
		int cardCount = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (counts.get(i) == 2) {
				cardCount += counts.get(i);
			}
		}
		if (cardCount == 8) {
			return true;
		}
		return false;
	}

	public boolean pair() {
		if (fullHouse() == true || threeOfAKind() == true || twoPair() == true) {
			return false;
		}
		int current = cards.get(0).getValue();
		Suit suit = cards.get(0).getSuit();
		int count = 1;
		ArrayList<Integer> counts = new ArrayList<>();
		for (int i = 0; i < cards.size(); i++) {
			count = 1;
			suit = cards.get(i).getSuit();
			current = cards.get(i).getValue();
			for (int e = 0; e < cards.size(); e++) {
				if (e != i) {
					if (cards.get(e).getValue() == current && cards.get(e).getSuit() != suit) {
						count += 1;
					}
				}
			}
			counts.add(count);
		}
		int cardCount = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (counts.get(i) == 2) {
				cardCount += counts.get(i);
			}
		}
		if (cardCount == 4) {
			return true;
		}
		return false;
	}

	public boolean highCard() {
		if (royalFlush() == true || straightFlush() == true || fourOfAKind() == true || fullHouse() == true
				|| flush() == true || straight() == true || threeOfAKind() == true || twoPair() == true
				|| pair() == true) {
			return false;
		} else {
			return true;
		}
	}

	public Card mostOccurring() {
		ArrayList<Integer> freq = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < cards.size(); i++) {
			count = 0;
			Card curr = cards.get(i);
			for (int e = 0; e < cards.size(); e++) {
				if (curr.getValue() == cards.get(e).getValue()) {
					count += 1;
				}
			}
			freq.add(count);
		}
		int index = 0;
		int max = freq.get(0);
		for (int i = 0; i < freq.size(); i++) {
			if (max < freq.get(i)) {
				max = freq.get(i);
				index = i;
			}
		}
		return cards.get(index);
	}

	public Card leastOccurring() {
		ArrayList<Integer> freq = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < cards.size(); i++) {
			count = 0;
			Card curr = cards.get(i);
			for (int e = 0; e < cards.size(); e++) {
				if (curr.getValue() == cards.get(e).getValue()) {
					count += 1;
				}
			}
			freq.add(count);
		}
		int index = 0;
		int min = freq.get(3);
		for (int i = 0; i < freq.size(); i++) {
			if (min > freq.get(i)) {
				min = freq.get(i);
				index = i;
			}
		}
		return cards.get(index);
	}

	public ArrayList allMostOccur() {
		ArrayList<Integer> freq = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < cards.size(); i++) {
			count = 0;
			Card curr = cards.get(i);
			for (int e = 0; e < cards.size(); e++) {
				if (curr.getValue() == cards.get(e).getValue()) {
					count += 1;
				}
			}
			freq.add(count);
		}
		ArrayList<Card> max1 = new ArrayList<>();
		int max = freq.get(0);
		int index = 0;
		for (int i = 0; i < freq.size(); i++) {
			if (max < freq.get(i)) {
				index = i;
				max = freq.get(i);
			}
		}
		for (int i = 0; i < cards.size(); i++) {
			if (max == freq.get(i)) {
				max1.add(cards.get(i));
			}
		}

		return max1;
	}

	public ArrayList allLeastOccur() {
		ArrayList<Card> pair = new ArrayList<>();
		Card max = mostOccurring();
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).compareTo(max) != 0) {
				pair.add(cards.get(i));
			}
		}
		Collections.sort(pair);
		return pair;
	}

	public String getType() {
		if (royalFlush()) {
			return "Royal Flush";
		}
		if (straightFlush()) {
			return "Straight Flush";
		}
		if (fourOfAKind()) {
			return "Four of a Kind";
		}
		if (fullHouse()) {
			return "Full House";
		}
		if (flush()) {
			return "Flush";
		}
		if (straight()) {
			return "Straight";
		}
		if (threeOfAKind()) {
			return "Three of a Kind";
		}
		if (twoPair()) {
			return "Two Pair";
		}
		if (pair()) {
			return "Pair";
		}
		return "High Card";
	}

}
