package tests;

/** 
 * Start of a JUnit test for class Card with enums.
 * 
 * @author Cameron Rodgers
 */
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import model.Card;
import model.Rank;
import model.Suit;

public class CardTest {

	@Test
	public void testGetters() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals(Rank.DEUCE, c1.getRank());
		assertEquals(Suit.CLUBS, c1.getSuit());
		assertEquals(2, c1.getValue());
		Card c2 = new Card(Rank.JACK, Suit.SPADES);
		assertEquals(11, c2.getValue());
		assertEquals(Suit.SPADES, c2.getSuit());
		Card c3 = new Card(Rank.QUEEN, Suit.HEARTS);
		assertEquals(12, c3.getValue());
		assertEquals(Suit.HEARTS, c3.getSuit());
		Card c4 = new Card(Rank.KING, Suit.DIAMONDS);
		assertEquals(13, c4.getValue());
		assertEquals(Suit.DIAMONDS, c4.getSuit());
	}

	@Test
	public void testCompareTo() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.DIAMONDS);
		Card c3 = new Card(Rank.KING, Suit.SPADES);
		Card c4 = new Card(Rank.ACE, Suit.SPADES);
		Card c5 = new Card(Rank.JACK, Suit.HEARTS);
		Card c6 = new Card(Rank.QUEEN, Suit.HEARTS);
		Card c7 = new Card(Rank.JACK, Suit.SPADES);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
		assertTrue(c1.compareTo(c1) == 0);
		assertTrue(c3.compareTo(c1) > 0);
		assertTrue(c3.compareTo(c4) < 0);
		assertTrue(c5.compareTo(c4) < 0);
		assertTrue(c5.compareTo(c1) > 0);
		assertTrue(c6.compareTo(c1) > 0);
		assertTrue(c4.compareTo(c6) > 0);
		assertTrue(c7.compareTo(c5) == 0);
	}

	@Test
	public void testToString() {
		Card c2 = new Card(Rank.DEUCE, Suit.CLUBS);
		assertEquals("2" + '\u2663', c2.toString());
		Card c3 = new Card(Rank.THREE, Suit.DIAMONDS);
		assertEquals("3" + '\u2666', c3.toString());
		Card c4 = new Card(Rank.FOUR, Suit.HEARTS);
		assertEquals("4" + '\u2665', c4.toString());
		Card c1 = new Card(Rank.JACK, Suit.SPADES);
		assertEquals("J" + '\u2660', c1.toString());
		Card c5 = new Card(Rank.KING, Suit.CLUBS);
		assertEquals("K" + '\u2663', c5.toString());
		Card c6 = new Card(Rank.QUEEN, Suit.HEARTS);
		assertEquals("Q" + '\u2665', c6.toString());
		Card c7 = new Card(Rank.ACE, Suit.DIAMONDS);
		assertEquals("A" + '\u2666', c7.toString());
	}

	@Test
	public void testEquals() {
		Card c1 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.DIAMONDS);
		Card c3 = new Card(Rank.DEUCE, Suit.CLUBS);
		Card c4 = new Card(Rank.KING, Suit.DIAMONDS);
		Card c5 = new Card(Rank.KING, Suit.HEARTS);
		Card c6 = new Card(Rank.JACK, Suit.HEARTS);
		Card c8 = new Card(Rank.JACK, Suit.CLUBS);
		Card c7 = new Card(Rank.TEN, Suit.SPADES);
		assertFalse(c1.equals(c2));
		assertFalse(c3.equals(c2));
		assertTrue(c1.equals(c3));
		assertTrue(c4.equals(c5));
		assertFalse(c4.equals(c3));
		assertFalse(c6.equals(c7));
		assertTrue(c8.equals(c6));

	}

}
