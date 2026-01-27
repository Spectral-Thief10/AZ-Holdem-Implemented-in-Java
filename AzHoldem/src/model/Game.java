/*
 * Author: Cameron Rodgers
 */
package model;

import java.util.*;

public class Game {
	private final static Card C2 = new Card(Rank.DEUCE, Suit.CLUBS);
	private final static Card C3 = new Card(Rank.THREE, Suit.CLUBS);
	private final static Card C4 = new Card(Rank.FOUR, Suit.CLUBS);
	private final static Card C5 = new Card(Rank.FIVE, Suit.CLUBS);
	private final static Card C6 = new Card(Rank.SIX, Suit.CLUBS);
	private final static Card C7 = new Card(Rank.SEVEN, Suit.CLUBS);
	private final static Card C8 = new Card(Rank.EIGHT, Suit.CLUBS);
	private final static Card C9 = new Card(Rank.NINE, Suit.CLUBS);
	private final static Card C10 = new Card(Rank.TEN, Suit.CLUBS);
	private final static Card CJ = new Card(Rank.JACK, Suit.CLUBS);
	private final static Card CQ = new Card(Rank.QUEEN, Suit.CLUBS);
	private final static Card CK = new Card(Rank.KING, Suit.CLUBS);
	private final static Card CA = new Card(Rank.ACE, Suit.CLUBS);

	private final static Card D2 = new Card(Rank.DEUCE, Suit.DIAMONDS);
	private final static Card D3 = new Card(Rank.THREE, Suit.DIAMONDS);
	private final static Card D4 = new Card(Rank.FOUR, Suit.DIAMONDS);
	private final static Card D5 = new Card(Rank.FIVE, Suit.DIAMONDS);
	private final static Card D6 = new Card(Rank.SIX, Suit.DIAMONDS);
	private final static Card D7 = new Card(Rank.SEVEN, Suit.DIAMONDS);
	private final static Card D8 = new Card(Rank.EIGHT, Suit.DIAMONDS);
	private final static Card D9 = new Card(Rank.NINE, Suit.DIAMONDS);
	private final static Card D10 = new Card(Rank.TEN, Suit.DIAMONDS);
	private final static Card DJ = new Card(Rank.JACK, Suit.DIAMONDS);
	private final static Card DQ = new Card(Rank.QUEEN, Suit.DIAMONDS);
	private final static Card DK = new Card(Rank.KING, Suit.DIAMONDS);
	private final static Card DA = new Card(Rank.ACE, Suit.DIAMONDS);

	private final static Card H2 = new Card(Rank.DEUCE, Suit.HEARTS);
	private final static Card H3 = new Card(Rank.THREE, Suit.HEARTS);
	private final static Card H4 = new Card(Rank.FOUR, Suit.HEARTS);
	private final static Card H5 = new Card(Rank.FIVE, Suit.HEARTS);
	private final static Card H6 = new Card(Rank.SIX, Suit.HEARTS);
	private final static Card H7 = new Card(Rank.SEVEN, Suit.HEARTS);
	private final static Card H8 = new Card(Rank.EIGHT, Suit.HEARTS);
	private final static Card H9 = new Card(Rank.NINE, Suit.HEARTS);
	private final static Card H10 = new Card(Rank.TEN, Suit.HEARTS);
	private final static Card HJ = new Card(Rank.JACK, Suit.HEARTS);
	private final static Card HQ = new Card(Rank.QUEEN, Suit.HEARTS);
	private final static Card HK = new Card(Rank.KING, Suit.HEARTS);
	private final static Card HA = new Card(Rank.ACE, Suit.HEARTS);

	private final static Card S2 = new Card(Rank.DEUCE, Suit.SPADES);
	private final static Card S3 = new Card(Rank.THREE, Suit.SPADES);
	private final static Card S4 = new Card(Rank.FOUR, Suit.SPADES);
	private final static Card S5 = new Card(Rank.FIVE, Suit.SPADES);
	private final static Card S6 = new Card(Rank.SIX, Suit.SPADES);
	private final static Card S7 = new Card(Rank.SEVEN, Suit.SPADES);
	private final static Card S8 = new Card(Rank.EIGHT, Suit.SPADES);
	private final static Card S9 = new Card(Rank.NINE, Suit.SPADES);
	private final static Card S10 = new Card(Rank.TEN, Suit.SPADES);
	private final static Card SJ = new Card(Rank.JACK, Suit.SPADES);
	private final static Card SQ = new Card(Rank.QUEEN, Suit.SPADES);
	private final static Card SK = new Card(Rank.KING, Suit.SPADES);
	private final static Card SA = new Card(Rank.ACE, Suit.SPADES);

	Scanner str = new Scanner(System.in);
	ArrayList<Card> deck;
	ArrayList<Card> reset;
	int numPlayers;
	ArrayList<Player> players;

	public Game() {
		deck = new ArrayList();
		deck.add(C2);
		deck.add(C3);
		deck.add(C4);
		deck.add(C5);
		deck.add(C6);
		deck.add(C7);
		deck.add(C8);
		deck.add(C9);
		deck.add(C10);
		deck.add(CJ);
		deck.add(CQ);
		deck.add(CK);
		deck.add(CA);

		deck.add(H2);
		deck.add(H3);
		deck.add(H4);
		deck.add(H5);
		deck.add(H6);
		deck.add(H7);
		deck.add(H8);
		deck.add(H9);
		deck.add(H10);
		deck.add(HJ);
		deck.add(HQ);
		deck.add(HK);
		deck.add(HA);

		deck.add(D2);
		deck.add(D3);
		deck.add(D4);
		deck.add(D5);
		deck.add(D6);
		deck.add(D7);
		deck.add(D8);
		deck.add(D9);
		deck.add(D10);
		deck.add(DJ);
		deck.add(DQ);
		deck.add(DK);
		deck.add(DA);

		deck.add(S2);
		deck.add(S3);
		deck.add(S4);
		deck.add(S5);
		deck.add(S6);
		deck.add(S7);
		deck.add(S8);
		deck.add(S9);
		deck.add(S10);
		deck.add(SJ);
		deck.add(SQ);
		deck.add(SK);
		deck.add(SA);

		players = new ArrayList();
		System.out.print("How many players? ");
		numPlayers = str.nextInt();
		for (int i = 1; i <= numPlayers; i++) {
			players.add(new Player(i));
		}
		System.out.println();
	}

	public void entryFee() {
		for (int i = 0; i < numPlayers; i++) {
			players.get(i).subtractBalance();
		}
	}

	public void start() {
		// TODO Auto-generated method stub
		Collections.shuffle(deck);
		entryFee();
		ArrayList<Card> community = communityCards();
		System.out.println("Community Cards: " + toString(community)+"\n");
		ArrayList<Card> playerCards = playerCards();
		ArrayList<PokerHand> hands = new ArrayList();
		ArrayList<Player> allPlayers = new ArrayList();
		PokerHand max = new PokerHand(community.get(0), community.get(1), community.get(2), community.get(3),
				community.get(4));
		for (int i = 0; i < numPlayers; i++) {
			System.out.println(
					players.get(i).toString() + playerCards.get(0).toString() + " " + playerCards.get(1).toString());
			allPlayers.add(players.get(i));
			PokerHand best = getBestHand(community, playerCards.get(0), playerCards.get(1));
			System.out.println("   Best hand: " + best.toString() + "- " + best.getType() + "\n");
			hands.add(best);
			playerCards.remove(0);
			playerCards.remove(0);
		}
		max = hands.get(0);
		for (int i = 0; i < hands.size(); i++) {
			if (max.compareTo(hands.get(i)) < 0) {
				max = hands.get(i);
			}
		}
		ArrayList<PokerHand> bestHands = new ArrayList();
		ArrayList<Player> bestPlayers = new ArrayList();
		for (int i = 0; i < hands.size(); i++) {
			if (hands.get(i).compareTo(max) == 0) {
				bestHands.add(hands.get(i));
				bestPlayers.add(allPlayers.get(i));
			}
		}
		if (bestPlayers.size() == 1) {
			for (int i = 0; i < players.size(); i++) {
				bestPlayers.get(0).addBalance();
			}

			System.out.println("Winner: " + bestPlayers.get(0).playerID() + " " + bestPlayers.get(0).getBalance());
			System.out.println(bestHands.get(0).toString() + " " + bestHands.get(0).getType());
		} else {
			System.out.println("Winning hands (tie)");
			double totalBalance = 0;
			for (int i = 0; i < players.size(); i++) {
				totalBalance += 2;
			}
			totalBalance = (double) totalBalance / bestHands.size();
			for (int i = 0; i < bestHands.size(); i++) {
				bestPlayers.get(i).addSpecificBalance(totalBalance);
				System.out.println(bestHands.get(i).toString() + " " + bestHands.get(i).getType() + " "
						+ bestPlayers.get(i).playerID() + " " + bestPlayers.get(i).getBalance());
			}
		}
		System.out.println();

		System.out.println("Play another game <y or n> ");
		Scanner newStr = new Scanner(System.in);
		String newGame = newStr.nextLine();
		if (newGame.equals("y")) {
			reset();
			start();
		} else {
			return;
		}

	}

	public PokerHand getBestHand(ArrayList<Card> community, Card card1, Card card2) {
		ArrayList<PokerHand> hands = new ArrayList();
		PokerHand max = new PokerHand(community.get(0), community.get(1), community.get(2), community.get(3),
				community.get(4));
		PokerHand hand1 = new PokerHand(card1, community.get(1), community.get(2), community.get(3), community.get(4));
		PokerHand hand2 = new PokerHand(community.get(0), card1, community.get(2), community.get(3), community.get(4));
		PokerHand hand3 = new PokerHand(community.get(0), community.get(1), card1, community.get(3), community.get(4));
		PokerHand hand4 = new PokerHand(community.get(0), community.get(1), community.get(2), card1, community.get(4));
		PokerHand hand5 = new PokerHand(community.get(0), community.get(1), community.get(2), community.get(3), card1);
		PokerHand hand6 = new PokerHand(card2, community.get(1), community.get(2), community.get(3), community.get(4));
		PokerHand hand7 = new PokerHand(community.get(0), card2, community.get(2), community.get(3), community.get(4));
		PokerHand hand8 = new PokerHand(community.get(0), community.get(1), card2, community.get(3), community.get(4));
		PokerHand hand9 = new PokerHand(community.get(0), community.get(1), community.get(2), card2, community.get(4));
		PokerHand hand10 = new PokerHand(community.get(0), community.get(1), community.get(2), community.get(3), card2);
		PokerHand hand11 = new PokerHand(card1, card2, community.get(2), community.get(3), community.get(4));
		PokerHand hand12 = new PokerHand(card1, community.get(1), card2, community.get(3), community.get(4));
		PokerHand hand13 = new PokerHand(card1, community.get(1), community.get(2), card2, community.get(4));
		PokerHand hand14 = new PokerHand(card1, community.get(1), community.get(2), community.get(3), card2);
		PokerHand hand15 = new PokerHand(community.get(0), card1, card2, community.get(3), community.get(4));
		PokerHand hand16 = new PokerHand(community.get(0), card1, community.get(2), card2, community.get(4));
		PokerHand hand17 = new PokerHand(community.get(0), card1, community.get(2), community.get(3), card2);
		PokerHand hand18 = new PokerHand(community.get(0), community.get(1), card1, card2, community.get(4));
		PokerHand hand19 = new PokerHand(community.get(0), community.get(1), card1, community.get(3), card2);
		PokerHand hand20 = new PokerHand(community.get(0), community.get(1), community.get(2), card1, card2);
		hands.add(hand1);
		hands.add(hand2);
		hands.add(hand3);
		hands.add(hand4);
		hands.add(hand5);
		hands.add(hand6);
		hands.add(hand7);
		hands.add(hand8);
		hands.add(hand9);
		hands.add(hand10);
		hands.add(hand11);
		hands.add(hand12);
		hands.add(hand13);
		hands.add(hand14);
		hands.add(hand15);
		hands.add(hand16);
		hands.add(hand17);
		hands.add(hand18);
		hands.add(hand19);
		hands.add(hand20);
		for (int i = 0; i < hands.size(); i++) {
			if (max.compareTo(hands.get(i)) < 0) {
				max = hands.get(i);
			}
		}
		return max;
	}

	public ArrayList playerCards() {
		ArrayList<Card> cards = new ArrayList();
		for (int i = 0; i < numPlayers; i++) {
			cards.add(deck.get(0));
			deck.remove(0);
			cards.add(deck.get(0));
			deck.remove(0);
		}
		return cards;
	}

	public String deckString() {
		String str = "";
		for (int i = 0; i < deck.size(); i++) {
			str += deck.get(i) + "\n";
		}
		return str;
	}

	public String toString(ArrayList cards) {
		String str = "";
		for (int i = 0; i < cards.size(); i++) {
			str += cards.get(i) + " ";
		}
		return str;
	}

	public ArrayList communityCards() {
		ArrayList<Card> community = new ArrayList();
		for (int i = 0; i < 5; i++) {
			community.add(deck.get(0));
			deck.remove(0);
		}
		return community;
	}

	public void reset() {
		deck = new ArrayList();
		deck.add(C2);
		deck.add(C3);
		deck.add(C4);
		deck.add(C5);
		deck.add(C6);
		deck.add(C7);
		deck.add(C8);
		deck.add(C9);
		deck.add(C10);
		deck.add(CJ);
		deck.add(CQ);
		deck.add(CK);
		deck.add(CA);

		deck.add(H2);
		deck.add(H3);
		deck.add(H4);
		deck.add(H5);
		deck.add(H6);
		deck.add(H7);
		deck.add(H8);
		deck.add(H9);
		deck.add(H10);
		deck.add(HJ);
		deck.add(HQ);
		deck.add(HK);
		deck.add(HA);

		deck.add(D2);
		deck.add(D3);
		deck.add(D4);
		deck.add(D5);
		deck.add(D6);
		deck.add(D7);
		deck.add(D8);
		deck.add(D9);
		deck.add(D10);
		deck.add(DJ);
		deck.add(DQ);
		deck.add(DK);
		deck.add(DA);

		deck.add(S2);
		deck.add(S3);
		deck.add(S4);
		deck.add(S5);
		deck.add(S6);
		deck.add(S7);
		deck.add(S8);
		deck.add(S9);
		deck.add(S10);
		deck.add(SJ);
		deck.add(SQ);
		deck.add(SK);
		deck.add(SA);
	}

}
