package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Card;
import model.PokerHand;
import model.Rank;
import model.Suit;

/**
 * Tests the CardHand class, last modified August 23
 * @author Cameron Rodgers
 */
public class PokerHandTest {

	// Set up 52 cards so we can use C2 instead of new Card(Rank.Deuce, Suit.Clubs)
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

	@Test
	public void testHighCard1() {
		PokerHand a = new PokerHand(H2, D2, S4, C4, H9);
		PokerHand b = new PokerHand(S2, C2, H3, D3, CA);
		assertTrue(a.compareTo(b) > 0);
		PokerHand c = new PokerHand(D3, D6, D7, DJ, SK);
		PokerHand d = new PokerHand(C3, C5, C7, CJ, DK);
		assertTrue(c.compareTo(d) > 0);
	}

	@Test
	public void testCompareTo() {
		PokerHand a = new PokerHand(C3, C4, D6, D7, DA);
		PokerHand b = new PokerHand(C2, C5, C7, DQ, DK);
		PokerHand e = new PokerHand(H2, D2, S5, C5, H5);
		PokerHand f = new PokerHand(S4, C4, H4, HA, CA);
		assertTrue(e.compareTo(f) > 0);
		a = new PokerHand(H2, D2, S5, C5, H5);
		b = new PokerHand(S4, C4, H4, HA, CA);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(CQ, HQ, CK, DK, HK);
		b = new PokerHand(H2, D2, CA, DA, HA);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D2, H2, DQ, HK, SA);
		b = new PokerHand(C3, H3, H4, H5, S6);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D2, H2, C2, HK, SA);
		b = new PokerHand(C3, H3, D3, H4, S5);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D3, D6, D7, DJ, DK);
		b = new PokerHand(C2, C6, C7, CJ, CK);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(D2, D6, C7, DJ, DK);
		b = new PokerHand(C2, C6, D7, DJ, DK);
		assertTrue(a.compareTo(b) == 0);
		a = new PokerHand(D3, D6, C6, DJ, CJ);
		b = new PokerHand(C3, H6, S6, HJ, SJ);
		assertTrue(a.compareTo(b) == 0);
		a = new PokerHand(D3, D4, D5, D6, D7);
		b = new PokerHand(CA, SA, DA, H7, C7);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(H2, H5, H7, HJ, HA);
		b = new PokerHand(S10, CJ, HQ, HK, CA);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(S2, C3, H5, S5, D5);
		b = new PokerHand(H2, C4, H4, H6, D6);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(H2, D2, S4, C4, HA);
		b = new PokerHand(S2, C3, H3, D3, C4);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D3, D6, D7, DJ, DK);
		b = new PokerHand(C2, C6, C8, CJ, CK);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(S2, D6, C9, HA, DK);
		b = new PokerHand(C2, S2, C8, S8, CK);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D3, S3, D4, C4, DK);
		b = new PokerHand(C2, H2, C4, H4, CK);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(D3, S3, D4, C4, DK);
		b = new PokerHand(C2, HA, C4, H6, CK);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(D2, S2, D4, D7, D10);
		b = new PokerHand(C2, H2, C4, H7, H10);
		assertTrue(a.compareTo(b) == 0);
		a = new PokerHand(D2, SA, C2, D7, D10);
		b = new PokerHand(C2, H2, D2, H7, H10);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D2, S3, D4, D5, C6);
		b = new PokerHand(C2, H2, C4, H7, H10);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(D2, S3, D4, D5, C6);
		a = new PokerHand(C2, H2, C4, H7, H10);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D2, S3, D4, D5, C6);
		b = new PokerHand(C2, H3, C4, C5, D6);
		assertTrue(a.compareTo(b) == 0);
		a = new PokerHand(D2, S3, D4, D5, C6);
		b = new PokerHand(C3, H4, C5, C6, D7);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D2, D7, D4, D10, DK);
		b = new PokerHand(C2, C7, C4, C10, CK);
		assertTrue(a.compareTo(b) == 0);
		a = new PokerHand(D2, C3, D4, D10, DK);
		b = new PokerHand(C2, C7, C4, C10, CK);
		assertTrue(a.compareTo(b) < 0);
		b = new PokerHand(D2, S2, C2, D10, C10);
		a = new PokerHand(C2, C7, C4, C10, CK);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(H2, S2, C2, D10, C10);
		b = new PokerHand(D2, S2, C2, D10, C10);
		assertTrue(a.compareTo(b) == 0);
		a = new PokerHand(H2, S2, C2, D10, C10);
		b = new PokerHand(D2, S2, CA, D10, C10);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(H2, S2, C2, D2, C10);
		b = new PokerHand(DA, SA, CA, HA, C10);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(H2, S2, C2, D2, C10);
		b = new PokerHand(DA, S3, CA, HA, C10);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(H2, S2, C2, D2, C10);
		b = new PokerHand(D2, S2, C2, H2, C10);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H3, H2, H4, H5, H6);
		a = new PokerHand(DA, S3, CA, HA, C10);
		assertTrue(a.compareTo(b) < 0);
		b = new PokerHand(H3, H2, H4, H5, H6);
		a = new PokerHand(C2, C3, C4, C5, C6);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H3, H2, H4, H5, H6);
		a = new PokerHand(C7, C3, C4, C5, C6);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H10, HJ, H4, H5, H6);
		a = new PokerHand(C7, C3, C4, C5, C6);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H10, HJ, HQ, HK, HA);
		a = new PokerHand(C10, CJ, CQ, CK, CA);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H10, HJ, H7, HK, HA);
		a = new PokerHand(C10, CJ, CQ, CK, CA);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(H10, H2, H7, HK, HA);
		b = new PokerHand(C10, CJ, CQ, CK, CA);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(D10, DJ, DQ, DK, DA);
		b = new PokerHand(C10, CJ, CQ, CK, CA);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(S10, SJ, SQ, SK, SA);
		a = new PokerHand(C10, CJ, CQ, CK, CA);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(S8, SJ, SQ, SK, S4);
		a = new PokerHand(C9, CJ, CQ, CK, C4);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(S9, SJ, SQ, SK, S4);
		a = new PokerHand(C9, CJ, CQ, CK, C4);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, H5, H6, H7, H8);
		a = new PokerHand(C4, C5, C6, C7, C8);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H3, H4, H5, H6, H7);
		a = new PokerHand(C4, C5, C6, C7, C8);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S4, C4, D4, C8);
		a = new PokerHand(C5, S5, D5, H5, C8);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S4, C4, D4, C8);
		a = new PokerHand(C4, S4, D4, H4, C10);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S4, C4, D4, C8);
		a = new PokerHand(C4, S4, D4, H4, S8);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, S4, C4, D2, C2);
		a = new PokerHand(C4, S4, D4, H3, C3);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S4, C4, D2, C2);
		a = new PokerHand(C4, S4, D4, H2, C2);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, S4, C4, D2, C2);
		a = new PokerHand(C5, S5, D5, H2, C2);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, H2, HJ, HK, H5);
		a = new PokerHand(C4, C2, CJ, CK, C5);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, H2, HJ, HK, H5);
		a = new PokerHand(C4, C2, CJ, CK, C6);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, H5, S6, D7, C8);
		a = new PokerHand(C4, C5, C6, D7, H8);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, H5, S6, D7, C8);
		a = new PokerHand(C8, C5, C6, D7, H9);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, D4, C4, S5, D8);
		a = new PokerHand(C4, D4, S4, D5, H8);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, D4, C4, S5, D8);
		a = new PokerHand(C4, D4, S4, D5, H9);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S4, D3, S3, D8);
		a = new PokerHand(C4, D4, S3, D3, H8);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, S4, D3, S3, DJ);
		a = new PokerHand(C4, D4, S3, D3, H8);
		assertTrue(a.compareTo(b) < 0);
		b = new PokerHand(H4, S4, D5, S5, D8);
		a = new PokerHand(C4, D4, S3, D3, H8);
		assertTrue(a.compareTo(b) < 0);
		b = new PokerHand(D5, S5, D2, S2, D8);
		a = new PokerHand(C4, D4, S3, D3, H8);
		assertTrue(a.compareTo(b) < 0);
		b = new PokerHand(S2, D2, D8, S10, DK);
		a = new PokerHand(C2, D2, S8, D10, HK);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(S2, D2, D8, S10, DK);
		a = new PokerHand(C2, D2, S8, D10, HA);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(S2, D2, D8, S10, DK);
		a = new PokerHand(C3, D3, S8, D10, HK);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(S2, D2, D8, S10, DK);
		a = new PokerHand(C2, D2, S8, DJ, HK);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(S2, D2, D8, S10, DK);
		a = new PokerHand(C2, D2, S9, D10, HK);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S6, CK, H8, S3);
		a = new PokerHand(H4, D6, CK, D8, S3);
		assertTrue(a.compareTo(b) == 0);
		b = new PokerHand(H4, S6, CK, H8, S3);
		a = new PokerHand(H4, D7, CK, D8, S3);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S6, CK, H8, S3);
		a = new PokerHand(H4, D6, CA, D8, S3);
		assertTrue(a.compareTo(b) > 0);
		b = new PokerHand(H4, S6, CK, H8, S9);
		a = new PokerHand(H4, D6, CK, D8, S3);
		assertTrue(a.compareTo(b) < 0);

		a = new PokerHand(C10, CQ, CK, CA, CJ);
		b = new PokerHand(C3, C4, C6, C5, C2);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C3, C4, C6, C5, C2);
		b = new PokerHand(C3, D3, H3, S3, C2);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C3, D3, H3, S3, C2);
		b = new PokerHand(C3, D3, H3, S6, C6);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C3, D3, H3, S6, C6);
		b = new PokerHand(C3, C4, C5, C7, C8);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C3, C4, C5, C7, C8);
		b = new PokerHand(C3, C4, H6, H5, D2);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C3, C4, H6, H5, D2);
		b = new PokerHand(SK, HK, CK, C5, D8);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(SK, HK, CK, C5, D8);
		b = new PokerHand(C3, S9, H9, D5, C5);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C3, S9, H9, D5, C5);
		b = new PokerHand(C9, H10, C6, S6, D2);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C9, H10, C6, S6, D2);
		b = new PokerHand(D4, S6, CK, H8, S3);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(D4, S6, CK, H8, S3);
		b = new PokerHand(D4, S6, CK, H8, S3);
		assertTrue(a.compareTo(b) == 0);

		b = new PokerHand(C3, D3, H3, S3, C2);
		a = new PokerHand(C3, S9, H9, D5, C5);
		assertTrue(a.compareTo(b) < 0);
		a = new PokerHand(S6, D6, DA, CA, HA);
		b = new PokerHand(C7, H7, DA, CA, HA);
		assertTrue(a.compareTo(b) < 0);
		assertTrue(b.compareTo(a) > 0);
		a = new PokerHand(S6, D6, DA, CA, HA);
		b = new PokerHand(S3, D3, DA, CA, HA);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(S6, D6, DA, CA, HA);
		b = new PokerHand(S3, D3, DA, CA, HA);
		assertTrue(b.compareTo(a) < 0);
		a = new PokerHand(C2, S4, D4, H4, SA);
		b = new PokerHand(CA, HA, SA, CK, CQ);
		assertTrue(a.compareTo(b) <0);
		a = new PokerHand(D2, S5, D5, H5, CA);
		b = new PokerHand(C2, S4, D4, H4, SA);
		assertTrue(a.compareTo(b) > 0);
		a = new PokerHand(C2, S4, D4, H4, SA);
		b = new PokerHand(S6, D6, DA, CA, HA);
		assertTrue(a.compareTo(b) < 0);
		b = new PokerHand(C7, H7, DA, CA, HA);
		assertTrue(a.compareTo(b) < 0);
		
	}

	@Test
	public void testRoyalFlush() {
		PokerHand a = new PokerHand(C10, CQ, CK, CA, CJ);
		assertTrue(a.royalFlush());
		PokerHand b = new PokerHand(C7, C4, C6, C5, C3);
		assertFalse(b.royalFlush());
		PokerHand c = new PokerHand(H7, C4, C6, C5, C2);
		assertFalse(c.royalFlush());
		PokerHand d = new PokerHand(C7, D4, C6, CA, C2);
		assertFalse(d.royalFlush());
		PokerHand e = new PokerHand(DK, DA, CJ, DQ, D10);
		assertFalse(e.royalFlush());
		PokerHand f = new PokerHand(D10, DK, DQ, SA, DJ);
		assertFalse(f.royalFlush());
		PokerHand g = new PokerHand(H10, HK, HQ, HA, HJ);
		assertTrue(g.royalFlush());
		PokerHand h = new PokerHand(D10, DK, DQ, D9, DJ);
		assertFalse(h.royalFlush());
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.royalFlush());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.royalFlush());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.royalFlush());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.royalFlush());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.royalFlush());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.royalFlush());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.royalFlush());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.royalFlush());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.royalFlush());
	}

	@Test
	public void testStraightFlush() {
		PokerHand a = new PokerHand(C3, C4, C6, C5, C2);
		assertTrue(a.straightFlush());
		PokerHand b = new PokerHand(C7, C4, C6, C5, C3);
		assertTrue(b.straightFlush());
		PokerHand c = new PokerHand(H7, C4, C6, C5, C2);
		assertFalse(c.straightFlush());
		PokerHand d = new PokerHand(C7, D4, C6, CA, C2);
		assertFalse(d.straightFlush());

		PokerHand h = new PokerHand(D10, DK, DQ, D9, DJ);
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertTrue(h.straightFlush());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.straightFlush());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.straightFlush());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.straightFlush());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.straightFlush());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.straightFlush());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.straightFlush());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.straightFlush());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.straightFlush());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.straightFlush());
	}

	@Test
	public void testFourOfAKind() {
		PokerHand a = new PokerHand(C3, D3, H3, S3, C2);
		assertTrue(a.fourOfAKind());
		PokerHand b = new PokerHand(SA, CA, DA, HA, S2);
		assertTrue(b.fourOfAKind());
		PokerHand c = new PokerHand(C3, C4, C6, C5, C2);
		assertFalse(c.fourOfAKind());
		PokerHand d = new PokerHand(SK, HK, DK, DA, DQ);
		assertFalse(d.fourOfAKind());
		PokerHand e = new PokerHand(SK, S3, DK, HK, CK);
		assertTrue(e.fourOfAKind());
		PokerHand f = new PokerHand(S4, S3, DK, HK, CK);
		assertFalse(f.fourOfAKind());
		PokerHand g = new PokerHand(SK, S4, DK, HK, CK);
		assertTrue(g.fourOfAKind());
		a = new PokerHand(D3, S3, H3, C3, D4);
		assertTrue(a.fourOfAKind());
		a = new PokerHand(C6, DJ, HJ, SJ, CQ);
		assertFalse(a.fourOfAKind());

		PokerHand h = new PokerHand(D10, DK, DQ, D9, DJ);
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertTrue(h.fourOfAKind());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.fourOfAKind());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.fourOfAKind());
	}

	@Test
	public void testFullHouse() {
		PokerHand a = new PokerHand(C3, D3, H3, S6, C6);
		assertTrue(a.fullHouse());
		PokerHand b = new PokerHand(SA, CA, H8, D8, S8);
		assertTrue(b.fullHouse());
		PokerHand c = new PokerHand(C3, C4, C6, C5, C2);
		assertFalse(c.fullHouse());
		PokerHand d = new PokerHand(SK, HK, DK, DA, DQ);
		assertFalse(d.fullHouse());
		PokerHand e = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertTrue(e.fullHouse());
		PokerHand f = new PokerHand(S4, S3, DK, HK, CK);
		assertFalse(f.fullHouse());
		PokerHand g = new PokerHand(SK, DK, SQ, HQ, C10);
		assertFalse(g.fullHouse());
		PokerHand h = new PokerHand(SK, DK, HK, CK, C10);
		assertFalse(h.fullHouse());
		PokerHand i = new PokerHand(SK, C10, DK, H10, HK);
		assertTrue(i.fullHouse());
		PokerHand j = new PokerHand(D9, H9, C9, HQ, HJ);
		assertFalse(j.fullHouse());

		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.fullHouse());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.fullHouse());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.fullHouse());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertTrue(h.fullHouse());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.fullHouse());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.fullHouse());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.fullHouse());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.fullHouse());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.fullHouse());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.fullHouse());
	}

	@Test
	public void testFlush() {
		PokerHand a = new PokerHand(C3, C4, C5, C7, C8);
		assertTrue(a.flush());
		PokerHand b = new PokerHand(C3, C4, C5, C6, C7);
		assertFalse(b.flush());
		PokerHand c = new PokerHand(H10, H3, H4, H2, HK);
		assertTrue(c.flush());
		PokerHand d = new PokerHand(H10, HJ, HK, HQ, HA);
		assertFalse(d.flush());

		PokerHand h = new PokerHand(D10, DK, DQ, D9, DJ);
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.flush());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.flush());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.flush());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.flush());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertTrue(h.flush());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.flush());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.flush());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.flush());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.flush());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.flush());
	}

	@Test
	public void testStraight() {
		PokerHand a = new PokerHand(C3, C4, H6, H5, D2);
		assertTrue(a.straight());
		PokerHand b = new PokerHand(C7, H4, D6, C5, C3);
		assertTrue(b.straight());
		PokerHand c = new PokerHand(H7, C4, C6, C5, C2);
		assertFalse(c.straight());
		PokerHand d = new PokerHand(C7, D4, C6, CA, C2);
		assertFalse(d.straight());
		PokerHand e = new PokerHand(C7, C8, C9, C10, CJ);
		assertFalse(e.straight());
		PokerHand f = new PokerHand(H7, D8, C9, C10, CJ);
		assertTrue(f.straight());
		PokerHand g = new PokerHand(H10, HJ, HQ, HA, HK);
		assertFalse(g.straight());
		PokerHand h = new PokerHand(H10, H3, H4, H2, HK);
		assertFalse(h.straight());
		PokerHand i = new PokerHand(C7, C4, C6, C5, C3);
		assertFalse(i.straight());
		PokerHand j = new PokerHand(HA, DJ, CK, SQ, H10);
		assertTrue(j.straight());
		PokerHand k = new PokerHand(C8, C4, C6, C5, C3);
		assertFalse(k.straight());

		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.straight());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.straight());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.straight());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.straight());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.straight());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertTrue(h.straight());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.straight());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.straight());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.straight());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.straight());
	}

	@Test
	public void testThreeOfAKind() {
		PokerHand a = new PokerHand(SK, HK, CK, C5, D8);
		assertTrue(a.threeOfAKind());
		PokerHand b = new PokerHand(SK, H10, CK, C5, DK);
		assertTrue(b.threeOfAKind());
		PokerHand c = new PokerHand(SK, HK, CK, C5, D5);
		assertFalse(c.threeOfAKind());
		PokerHand d = new PokerHand(C8, C4, C6, C5, C3);
		assertFalse(d.threeOfAKind());
		PokerHand e = new PokerHand(CK, C10, HK, D5, SK);
		assertTrue(e.threeOfAKind());

		PokerHand h = d;
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertTrue(h.threeOfAKind());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.threeOfAKind());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.threeOfAKind());
	}

	@Test
	public void testTwoPair() {
		PokerHand a = new PokerHand(C3, S9, H9, D5, C5);
		assertTrue(a.twoPair());
		PokerHand b = new PokerHand(H5, S9, H10, D5, C10);
		assertTrue(b.twoPair());
		PokerHand c = new PokerHand(C2, S9, H9, D3, C5);
		assertFalse(c.twoPair());
		PokerHand d = new PokerHand(C3, S9, HK, SK, C5);
		assertFalse(d.twoPair());
		PokerHand f = new PokerHand(S4, D4, DK, HK, CK);
		assertFalse(f.twoPair());

		PokerHand h = d;
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.twoPair());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.twoPair());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.twoPair());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.twoPair());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.twoPair());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.twoPair());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.twoPair());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertTrue(h.twoPair());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.twoPair());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.twoPair());
	}

	@Test
	public void pair() {
		PokerHand a = new PokerHand(C9, H10, C6, S6, D2);
		assertTrue(a.pair());
		PokerHand b = new PokerHand(C3, S9, H10, D7, H3);
		assertTrue(b.pair());
		PokerHand c = new PokerHand(C3, S9, H9, D7, H3);
		assertFalse(c.pair());
		PokerHand d = new PokerHand(C3, S10, H10, D7, H3);
		assertFalse(d.pair());
		PokerHand e = new PokerHand(C3, H2, HQ, DK, H5);
		assertFalse(e.pair());
		PokerHand f = new PokerHand(C3, SA, H9, DA, H2);
		assertTrue(f.pair());
		PokerHand g = new PokerHand(C3, SJ, H9, D8, H2);
		assertFalse(g.pair());

		PokerHand h = d;
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.pair());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.pair());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.pair());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.pair());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.pair());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.pair());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.pair());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.pair());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertTrue(h.pair());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertFalse(h.pair());
	}

	@Test
	public void testHighCard() {
		PokerHand a = new PokerHand(D4, S6, CK, H8, S3);
		assertTrue(a.highCard());
		PokerHand b = new PokerHand(D4, S4, CK, H8, S3);
		assertFalse(b.highCard());
		PokerHand c = new PokerHand(D4, S6, CK, HJ, S2);
		assertTrue(c.highCard());
		PokerHand d = new PokerHand(D4, S6, SK, CK, S3);
		assertFalse(d.highCard());
		a = new PokerHand(H2, D4, C4, H4, H9);
		assertTrue(a.threeOfAKind());

		PokerHand h = d;
		h = new PokerHand(C4, C5, C6, C7, C8);
		assertFalse(h.highCard());
		h = new PokerHand(H10, HJ, HQ, HK, HA);
		assertFalse(h.highCard());
		h = new PokerHand(CA, HA, DA, SA, S8);
		assertFalse(h.highCard());
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		assertFalse(h.highCard());
		h = new PokerHand(D4, D8, D6, D7, D2);
		assertFalse(h.highCard());
		h = new PokerHand(C3, C6, H4, D5, H7);
		assertFalse(h.highCard());
		h = new PokerHand(SK, HK, CK, S5, D8);
		assertFalse(h.highCard());
		h = new PokerHand(C3, S9, H9, D5, C5);
		assertFalse(h.highCard());
		h = new PokerHand(S9, H10, C6, S6, D2);
		assertFalse(h.highCard());
		h = new PokerHand(D4, S6, CK, H8, S3);
		assertTrue(h.highCard());

	}

	@Test
	public void testMain() {

		PokerHand a = new PokerHand(D2, C3, H5, H9, H8);

		PokerHand b = new PokerHand(D4, C4, H4, H7, HA);

		PokerHand c = new PokerHand(D4, C4, H4, H9, H8);

		PokerHand d = new PokerHand(D4, C4, H4, H9, H6);

		PokerHand e = new PokerHand(D4, C4, H4, H9, H8);

		PokerHand f = new PokerHand(D4, C4, H4, H9, H2);

		PokerHand g = new PokerHand(S6, D6, D2, CA, H3);

		PokerHand h = new PokerHand(S3, D3, S9, CA, H4);

		PokerHand i = new PokerHand(S6, D6, D4, CA, H5);

		PokerHand j = new PokerHand(C6, H9, D6, CQ, H6);

		PokerHand k = new PokerHand(S6, D6, C3, CK, H7);

		PokerHand l = new PokerHand(C7, H7, C4, C3, H8);

		PokerHand m = new PokerHand(S6, D7, C5, C7, H9);

		ArrayList<PokerHand> hands = new ArrayList<>();

		hands.add(a);

		hands.add(b);

		hands.add(c);

		hands.add(d);

		hands.add(e);

		hands.add(f);

		hands.add(g);

		hands.add(h);

		hands.add(i);

		hands.add(j);

		hands.add(k);

		hands.add(l);

		hands.add(m);

		Collections.shuffle(hands);

		Collections.sort(hands);

		for (PokerHand hand : hands) {

			System.out.println(hand);

		}

		System.out.println("Best Hand: " + Collections.max(hands));

	}

	@Test
	public void testStrings() {
		PokerHand h = new PokerHand(C4, C5, C6, C7, C8);
		if (h.straightFlush()) {
			assertEquals("Straight Flush", h.getType());
		}
		h = new PokerHand(C10, CJ, CQ, CK, CA);
		if (h.royalFlush()) {
			assertEquals("Royal Flush", h.getType());
		}
		h = new PokerHand(CA, HA, DA, SA, S8);
		if (h.fourOfAKind()) {
			assertEquals("Four of a Kind", h.getType());
		}
		h = new PokerHand(SQ, HQ, CQ, S6, D6);
		if (h.fullHouse()) {
			assertEquals("Full House", h.getType());
		}
		h = new PokerHand(D4, D8, D6, D7, D2);
		if (h.flush()) {
			assertEquals("Flush", h.getType());
		}
		h = new PokerHand(C3, C6, H4, D5, H7);
		if (h.straight()) {
			assertEquals("Straight", h.getType());
		}
		h = new PokerHand(SK, HK, CK, S5, D8);
		if (h.threeOfAKind()) {
			assertEquals("Three of a Kind", h.getType());
		}
		h = new PokerHand(C3, S9, H9, D5, C5);
		if (h.twoPair()) {
			assertEquals("Two Pair", h.getType());
		}
		h = new PokerHand(S9, H10, C6, S6, D2);
		if (h.pair()) {
			assertEquals("Pair", h.getType());
		}
		h = new PokerHand(D4, S6, CK, H8, S3);
		if (h.highCard()) {
			assertEquals("High Card", h.getType());
		}
	}

	@Test
	public void testAssertions() {
		assertThrows(IllegalArgumentException.class, () -> {
			PokerHand a = new PokerHand(C10, C10, CQ, CK, CA);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			PokerHand a = new PokerHand(C10, C8, CQ, C10, CA);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			PokerHand a = new PokerHand(CA, C10, CQ, CK, CA);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			PokerHand a = new PokerHand(C10, C9, C10, CK, CA);
		});
	}

}
